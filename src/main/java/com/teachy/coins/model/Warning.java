package com.teachy.coins.model;

import java.io.Serializable;

import com.teachy.coins.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * warning
 * @author
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Warning implements Serializable {
	private Integer id;

	private String website;

	private String name;

	private Integer volume;

	private Integer price;

	private Integer count;

	/**
	 * 0:未发送，1：已发送
	 */
	private Integer isemail;

	private String marks;

	private long timelong;

	private String timeStr;

	private static final long serialVersionUID = 1L;

	public Warning(String website, String name, Integer volume, Integer price, Integer count, Integer isemail,
		String marks) {
		this.website = website;
		this.name = name;
		this.volume = volume;
		this.price = price;
		this.count = count;
		this.isemail = isemail;
		this.marks = marks;
		this.timelong = System.currentTimeMillis();
		this.timeStr = DateUtils.convertTimeToString(timelong);
	}
}