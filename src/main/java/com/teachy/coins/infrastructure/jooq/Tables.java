/*
 * This file is generated by jOOQ.
 */
package com.teachy.coins.infrastructure.jooq;


import com.teachy.coins.infrastructure.jooq.tables.CoinList;
import com.teachy.coins.infrastructure.jooq.tables.Hosts;
import com.teachy.coins.infrastructure.jooq.tables.IpList;
import com.teachy.coins.infrastructure.jooq.tables.Sources;
import com.teachy.coins.infrastructure.jooq.tables.SpiderBase;
import com.teachy.coins.infrastructure.jooq.tables.SpiderQueue;
import com.teachy.coins.infrastructure.jooq.tables.SpiderUnique;
import com.teachy.coins.infrastructure.jooq.tables.SpiderUrl;
import com.teachy.coins.infrastructure.jooq.tables.Tools;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in 
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>coin_list</code>.
     */
    public static final CoinList COIN_LIST = com.teachy.coins.infrastructure.jooq.tables.CoinList.COIN_LIST;

    /**
     * The table <code>hosts</code>.
     */
    public static final Hosts HOSTS = com.teachy.coins.infrastructure.jooq.tables.Hosts.HOSTS;

    /**
     * The table <code>ip_list</code>.
     */
    public static final IpList IP_LIST = com.teachy.coins.infrastructure.jooq.tables.IpList.IP_LIST;

    /**
     * The table <code>sources</code>.
     */
    public static final Sources SOURCES = com.teachy.coins.infrastructure.jooq.tables.Sources.SOURCES;

    /**
     * 爬虫基本信息
     */
    public static final SpiderBase SPIDER_BASE = com.teachy.coins.infrastructure.jooq.tables.SpiderBase.SPIDER_BASE;

    /**
     * 爬虫队列
     */
    public static final SpiderQueue SPIDER_QUEUE = com.teachy.coins.infrastructure.jooq.tables.SpiderQueue.SPIDER_QUEUE;

    /**
     * The table <code>spider_unique</code>.
     */
    public static final SpiderUnique SPIDER_UNIQUE = com.teachy.coins.infrastructure.jooq.tables.SpiderUnique.SPIDER_UNIQUE;

    /**
     * The table <code>spider_url</code>.
     */
    public static final SpiderUrl SPIDER_URL = com.teachy.coins.infrastructure.jooq.tables.SpiderUrl.SPIDER_URL;

    /**
     * The table <code>tools</code>.
     */
    public static final Tools TOOLS = com.teachy.coins.infrastructure.jooq.tables.Tools.TOOLS;
}
