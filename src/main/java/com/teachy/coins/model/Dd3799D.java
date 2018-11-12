package com.teachy.coins.model;

import com.teachy.coins.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dd3799D {
	private int id;
	private String type;
	private String qihao;
	private String jieguo;
	private String timeStr;
	private String timeDay;

	public Dd3799D(String type, String qihao, String jieguo) {
		this.type = type;
		this.qihao = qihao;
		this.jieguo = jieguo;
		this.timeStr = DateUtils.convertTimeToString(System.currentTimeMillis());
		this.timeDay = DateUtils.convertTimeToString(System.currentTimeMillis(), "yyyy-MM-dd");
	}
}
