package com.korea.k2.order;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderJumunVO {
	private int idx;
	private int cartId;
	private int custno;
	private int productId;
	private String productName;
	private int amount;
	private Date getDate;
	
	private int orderG;
}
