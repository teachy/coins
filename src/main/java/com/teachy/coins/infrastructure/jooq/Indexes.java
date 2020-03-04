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

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index COIN_LIST_PRIMARY = Indexes0.COIN_LIST_PRIMARY;
    public static final Index HOSTS_IP = Indexes0.HOSTS_IP;
    public static final Index HOSTS_PRIMARY = Indexes0.HOSTS_PRIMARY;
    public static final Index IP_LIST_PRIMARY = Indexes0.IP_LIST_PRIMARY;
    public static final Index SOURCES_NGRAM_IDX = Indexes0.SOURCES_NGRAM_IDX;
    public static final Index SOURCES_PRIMARY = Indexes0.SOURCES_PRIMARY;
    public static final Index SOURCES_URL = Indexes0.SOURCES_URL;
    public static final Index SPIDER_BASE_PRIMARY = Indexes0.SPIDER_BASE_PRIMARY;
    public static final Index SPIDER_QUEUE_PRIMARY = Indexes0.SPIDER_QUEUE_PRIMARY;
    public static final Index SPIDER_UNIQUE_PRIMARY = Indexes0.SPIDER_UNIQUE_PRIMARY;
    public static final Index SPIDER_URL_NAME = Indexes0.SPIDER_URL_NAME;
    public static final Index SPIDER_URL_PRIMARY = Indexes0.SPIDER_URL_PRIMARY;
    public static final Index TOOLS_NGRAM_IDX = Indexes0.TOOLS_NGRAM_IDX;
    public static final Index TOOLS_PRIMARY = Indexes0.TOOLS_PRIMARY;
    public static final Index TOOLS_URL = Indexes0.TOOLS_URL;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index COIN_LIST_PRIMARY = Internal.createIndex("PRIMARY", CoinList.COIN_LIST, new OrderField[] { CoinList.COIN_LIST.ID }, true);
        public static Index HOSTS_IP = Internal.createIndex("ip", Hosts.HOSTS, new OrderField[] { Hosts.HOSTS.IP }, true);
        public static Index HOSTS_PRIMARY = Internal.createIndex("PRIMARY", Hosts.HOSTS, new OrderField[] { Hosts.HOSTS.ID }, true);
        public static Index IP_LIST_PRIMARY = Internal.createIndex("PRIMARY", IpList.IP_LIST, new OrderField[] { IpList.IP_LIST.ID }, true);
        public static Index SOURCES_NGRAM_IDX = Internal.createIndex("ngram_idx", Sources.SOURCES, new OrderField[] { Sources.SOURCES.NAME }, false);
        public static Index SOURCES_PRIMARY = Internal.createIndex("PRIMARY", Sources.SOURCES, new OrderField[] { Sources.SOURCES.ID }, true);
        public static Index SOURCES_URL = Internal.createIndex("url", Sources.SOURCES, new OrderField[] { Sources.SOURCES.URL }, true);
        public static Index SPIDER_BASE_PRIMARY = Internal.createIndex("PRIMARY", SpiderBase.SPIDER_BASE, new OrderField[] { SpiderBase.SPIDER_BASE.ID }, true);
        public static Index SPIDER_QUEUE_PRIMARY = Internal.createIndex("PRIMARY", SpiderQueue.SPIDER_QUEUE, new OrderField[] { SpiderQueue.SPIDER_QUEUE.ID }, true);
        public static Index SPIDER_UNIQUE_PRIMARY = Internal.createIndex("PRIMARY", SpiderUnique.SPIDER_UNIQUE, new OrderField[] { SpiderUnique.SPIDER_UNIQUE.ID }, true);
        public static Index SPIDER_URL_NAME = Internal.createIndex("name", SpiderUrl.SPIDER_URL, new OrderField[] { SpiderUrl.SPIDER_URL.NAME }, true);
        public static Index SPIDER_URL_PRIMARY = Internal.createIndex("PRIMARY", SpiderUrl.SPIDER_URL, new OrderField[] { SpiderUrl.SPIDER_URL.ID }, true);
        public static Index TOOLS_NGRAM_IDX = Internal.createIndex("ngram_idx", Tools.TOOLS, new OrderField[] { Tools.TOOLS.NAME, Tools.TOOLS.DESCRIPTION }, false);
        public static Index TOOLS_PRIMARY = Internal.createIndex("PRIMARY", Tools.TOOLS, new OrderField[] { Tools.TOOLS.ID }, true);
        public static Index TOOLS_URL = Internal.createIndex("url", Tools.TOOLS, new OrderField[] { Tools.TOOLS.URL }, true);
    }
}
