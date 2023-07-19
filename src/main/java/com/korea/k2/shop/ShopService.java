package com.korea.k2.shop;

import java.util.List;

public interface ShopService {
   List<MemberVO> selectAll(MemberVO vo);
   void  insert(MemberVO vo);
   void  update(MemberVO vo);
   MemberVO  edit(MemberVO vo);
   MemberVO  login(MemberVO vo);
   int custno();
   List<MoneyVO> ShopMoney();
   String idCk(MemberVO vo);
}
