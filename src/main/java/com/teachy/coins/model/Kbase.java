package com.teachy.coins.model;

import java.io.Serializable;

import com.teachy.coins.utils.DateUtils;
import com.teachy.coins.utils.StringUtils;

public class Kbase implements Serializable {
	private static final long serialVersionUID = 1L;

	public Kbase(long timeLong, Double volume, Double close, Double high, Double low, Double open, String website,
		String type, String name, String tableName) {
		this.id = "'" + StringUtils.getUUid() + "'";
		this.timeLong = timeLong;
		this.volume = volume;
		this.close = close;
		this.high = high;
		this.low = low;
		this.open = open;
		this.timeStr = "'" + DateUtils.convertTimeToString(timeLong) + "'";
		this.website = "'" + website + "'";
		this.type = "'" + type + "'";
		this.name = "'" + name + "'";
		this.tableName = tableName;
	}

	private String id;

	/**
	 * 网站，比如币安,火币等
	 */
	private String website;

	/**
	 * 交易类型,比如：usdt_eth
	 */
	private String type;

	/**
	 * name
	 */
	private String name;

	/**
	 * 时间
	 */
	private long timeLong;

	/**
	 * 量
	 */
	private Double volume;

	/**
	 * 闭盘价
	 */
	private Double close;

	/**
	 * 开盘价
	 */
	private Double open;

	/**
	 * 最高价
	 */
	private Double high;

	/**
	 * 最低阶
	 */
	private Double low;

	/**
	 * 时间 非时间戳
	 */
	private String timeStr;
	/**
	 * 属于哪个表
	 */
	private String tableName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTimeLong() {
		return timeLong;
	}

	public void setTimeLong(long timeLong) {
		this.timeLong = timeLong;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public String getTimeStr() {
		return timeStr;
	}

	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", website=").append(website);
		sb.append(", type=").append(type);
		sb.append(", name=").append(name);
		sb.append(", timeLong=").append(timeLong);
		sb.append(", volume=").append(volume);
		sb.append(", close=").append(close);
		sb.append(", open=").append(open);
		sb.append(", high=").append(high);
		sb.append(", low=").append(low);
		sb.append(", timeStr=").append(timeStr);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}
