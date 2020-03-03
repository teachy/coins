/*
 * This file is generated by jOOQ.
 */
package com.teachy.coins.infrastructure.jooq.tables.records;


import com.teachy.coins.infrastructure.jooq.tables.SpiderBase;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 爬虫基本信息
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SpiderBaseRecord extends UpdatableRecordImpl<SpiderBaseRecord> implements Record14<String, String, String, Timestamp, Timestamp, String, String, Integer, Integer, Timestamp, Timestamp, String, String, Integer> {

    private static final long serialVersionUID = 1544154579;

    /**
     * Setter for <code>spider_base.ID</code>. 爬虫id
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>spider_base.ID</code>. 爬虫id
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>spider_base.NAME</code>. 名称
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>spider_base.NAME</code>. 名称
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>spider_base.DESCRIPTION</code>. 描述
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>spider_base.DESCRIPTION</code>. 描述
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>spider_base.START_TIME</code>. 开始时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public void setStartTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>spider_base.START_TIME</code>. 开始时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public Timestamp getStartTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>spider_base.LAST_DATE</code>. 最后一次运行时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public void setLastDate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>spider_base.LAST_DATE</code>. 最后一次运行时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public Timestamp getLastDate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>spider_base.HOST_ID</code>. hostId
     */
    public void setHostId(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>spider_base.HOST_ID</code>. hostId
     */
    public String getHostId() {
        return (String) get(5);
    }

    /**
     * Setter for <code>spider_base.HOST_TYPE</code>. hostType
     */
    public void setHostType(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>spider_base.HOST_TYPE</code>. hostType
     */
    public String getHostType() {
        return (String) get(6);
    }

    /**
     * Setter for <code>spider_base.ENABLE</code>. 0 未启用
            1 已启动
     */
    public void setEnable(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>spider_base.ENABLE</code>. 0 未启用
            1 已启动
     */
    public Integer getEnable() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>spider_base.STATUS</code>. 状态
     */
    public void setStatus(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>spider_base.STATUS</code>. 状态
     */
    public Integer getStatus() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>spider_base.NEXT_START_TIME</code>. 下次开始时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public void setNextStartTime(Timestamp value) {
        set(9, value);
    }

    /**
     * Getter for <code>spider_base.NEXT_START_TIME</code>. 下次开始时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public Timestamp getNextStartTime() {
        return (Timestamp) get(9);
    }

    /**
     * Setter for <code>spider_base.UPDATE_TIME</code>. 配置更新时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public void setUpdateTime(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>spider_base.UPDATE_TIME</code>. 配置更新时间 格式为YYYY-MM-DD HH:MM:SS
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>spider_base.PAGE_XML</code>. xml配置信息
     */
    public void setPageXml(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>spider_base.PAGE_XML</code>. xml配置信息
     */
    public String getPageXml() {
        return (String) get(11);
    }

    /**
     * Setter for <code>spider_base.IP_ADDR</code>. 爬虫服务器所在的IP地址
     */
    public void setIpAddr(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>spider_base.IP_ADDR</code>. 爬虫服务器所在的IP地址
     */
    public String getIpAddr() {
        return (String) get(12);
    }

    /**
     * Setter for <code>spider_base.NEED_LOAD</code>. 0 未登陆
            1 已登陆
     */
    public void setNeedLoad(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>spider_base.NEED_LOAD</code>. 0 未登陆
            1 已登陆
     */
    public Integer getNeedLoad() {
        return (Integer) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, String, Timestamp, Timestamp, String, String, Integer, Integer, Timestamp, Timestamp, String, String, Integer> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, String, Timestamp, Timestamp, String, String, Integer, Integer, Timestamp, Timestamp, String, String, Integer> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return SpiderBase.SPIDER_BASE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SpiderBase.SPIDER_BASE.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SpiderBase.SPIDER_BASE.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return SpiderBase.SPIDER_BASE.START_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return SpiderBase.SPIDER_BASE.LAST_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return SpiderBase.SPIDER_BASE.HOST_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return SpiderBase.SPIDER_BASE.HOST_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return SpiderBase.SPIDER_BASE.ENABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return SpiderBase.SPIDER_BASE.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field10() {
        return SpiderBase.SPIDER_BASE.NEXT_START_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return SpiderBase.SPIDER_BASE.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return SpiderBase.SPIDER_BASE.PAGE_XML;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return SpiderBase.SPIDER_BASE.IP_ADDR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return SpiderBase.SPIDER_BASE.NEED_LOAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getLastDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getHostId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getHostType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getEnable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component10() {
        return getNextStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getPageXml();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getIpAddr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component14() {
        return getNeedLoad();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getLastDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getHostId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getHostType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getEnable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value10() {
        return getNextStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getPageXml();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getIpAddr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getNeedLoad();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value3(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value4(Timestamp value) {
        setStartTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value5(Timestamp value) {
        setLastDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value6(String value) {
        setHostId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value7(String value) {
        setHostType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value8(Integer value) {
        setEnable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value9(Integer value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value10(Timestamp value) {
        setNextStartTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value11(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value12(String value) {
        setPageXml(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value13(String value) {
        setIpAddr(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord value14(Integer value) {
        setNeedLoad(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SpiderBaseRecord values(String value1, String value2, String value3, Timestamp value4, Timestamp value5, String value6, String value7, Integer value8, Integer value9, Timestamp value10, Timestamp value11, String value12, String value13, Integer value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SpiderBaseRecord
     */
    public SpiderBaseRecord() {
        super(SpiderBase.SPIDER_BASE);
    }

    /**
     * Create a detached, initialised SpiderBaseRecord
     */
    public SpiderBaseRecord(String id, String name, String description, Timestamp startTime, Timestamp lastDate, String hostId, String hostType, Integer enable, Integer status, Timestamp nextStartTime, Timestamp updateTime, String pageXml, String ipAddr, Integer needLoad) {
        super(SpiderBase.SPIDER_BASE);

        set(0, id);
        set(1, name);
        set(2, description);
        set(3, startTime);
        set(4, lastDate);
        set(5, hostId);
        set(6, hostType);
        set(7, enable);
        set(8, status);
        set(9, nextStartTime);
        set(10, updateTime);
        set(11, pageXml);
        set(12, ipAddr);
        set(13, needLoad);
    }
}
