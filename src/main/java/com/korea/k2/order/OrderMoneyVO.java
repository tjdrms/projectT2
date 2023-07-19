package com.korea.k2.order;

import java.sql.Date;

import lombok.Data;

@Data
public class OrderMoneyVO {
	private int idx;
	private int custno2;
	private int baesongbi;
	private int totalMoney;
	private Date getDate;
}
