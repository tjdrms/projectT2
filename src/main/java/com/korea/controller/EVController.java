package com.korea.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.korea.k2.charge.EVSearchServiceImpl;
import com.korea.k2.charge.EVSearchVO;

@Controller
public class EVController {
	@Autowired
	EVSearchServiceImpl es;
	
	
	@RequestMapping("/evSelectAll.do")
    ModelAndView companySelectAll ( EVSearchVO  vo , ModelAndView mav) {
		mav.addObject("li2", es.selectAllEV(vo));
		mav.setViewName("/company/evList.jsp");
		return mav;
	}
	
	@RequestMapping("/evSelectMapAll.do")
    ModelAndView companySelectMapAll ( EVSearchVO  vo , ModelAndView mav) {
		mav.addObject("li3", es.selectAllEV(vo));
		mav.setViewName("/company/EVMapList.jsp");
		return mav;
	}
	
	@RequestMapping("/evEditMap.do")
    ModelAndView evEditMap ( EVSearchVO  vo , ModelAndView mav) {
		mav.addObject("m2", es.editEV(vo));
		mav.setViewName("/company/EVMapEdit.jsp");
		return mav;
	}
	
	
	
// http://apis.data.go.kr/6480000/   <===  https 를  http 로 변경하기 
	@GetMapping("/insertEV.do")
	public String insert( EVSearchVO  vo  ) throws Exception {
	        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=4gj9Twc31okjS8vyGhyUgF2a9PtDT0SUb3ccLz8LHzmSPG%2FX523Ax5fSVYiQ5OLCePkff%2BvIU6I8dGXW%2F1q72g%3D%3D"); /*Service Key (일반인증키)*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*상태갱신 조회 범위(분) (기본값 5, 최소 1, 최대 10)*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();

	        // XML 데이터 읽어 오기 
	        System.out.println(sb.toString());
   
	        Node data1 = null;   
	        Node data2 = null;   
	        Node data3 = null;
	        Node data4 = null;
	        
	        try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
	         FileOutputStream output = new FileOutputStream("./ApiExplorer");
	         output.write(sb.toString().getBytes("UTF-8"));  // 전체 데이터 읽어 오기 
	         output.close();

	         Document doc = dBuilder.parse("./ApiExplorer");
	         doc.getDocumentElement().normalize();
	         Element body =(Element) doc.getElementsByTagName("body").item(0);
	         Element items =(Element) body.getElementsByTagName("items").item(0);

	         
	         es.deleteEV(vo);
	         
	         for(int i=0 ; i<=999 ; i++ ) {
	         Element item =(Element) items.getElementsByTagName("item").item(i);
	          
	         // 필요한 데이터 값 추출하기 
	         data1 = item.getElementsByTagName("addr").item(0);  
	         data2 = item.getElementsByTagName("cpNm").item(0); 
	         data3 = item.getElementsByTagName("cpStat").item(0); 
	         data4 = item.getElementsByTagName("csNm").item(0); 


	         String strData1 = data1.getChildNodes().item(0).getNodeValue();
	         String strData2 = data2.getChildNodes().item(0).getNodeValue();
	         String strData3 = data3.getChildNodes().item(0).getNodeValue();
	         String strData4 = data4.getChildNodes().item(0).getNodeValue();
	         
	         System.out.println( strData1 + " " + strData2 + " " + strData3 + " " + strData4);
        
	         vo.setAddr(strData1);
	         vo.setCpNm(strData2);
	         vo.setCpStat(strData3);
	         vo.setCsNm(strData4);
	         
	         es.insertEV(vo);        
	         
	         }         

	        } catch (Exception e) {
	         e.printStackTrace();
	        }
	      return "/index.jsp";        
    }
}
