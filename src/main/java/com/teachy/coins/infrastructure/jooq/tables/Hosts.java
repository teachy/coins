/*
 * This file is generated by jOOQ.
 */
package com.teachy.coins.infrastructure.jooq.tables;


import com.teachy.coins.infrastructure.jooq.DefaultSchema;
import com.teachy.coins.infrastructure.jooq.Indexes;
import com.teachy.coins.infrastructure.jooq.Keys;
import com.teachy.coins.infrastructure.jooq.tables.records.HostsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Hosts extends TableImpl<HostsRecord> {

    private static final long serialVersionUID = 503878625;

    /**
     * The reference instance of <code>hosts</code>
     */
    public static final Hosts HOSTS = new Hosts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HostsRecord> getRecordType() {
        return HostsRecord.class;
    }

    /**
     * The column <code>hosts.id</code>.
     */
    public final TableField<HostsRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>hosts.ip</code>.
     */
    public final TableField<HostsRecord, String> IP = createField("ip", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>hosts.user</code>.
     */
    public final TableField<HostsRecord, String> USER = createField("user", org.jooq.impl.SQLDataType.VARCHAR(32).nullable(false), this, "");

    /**
     * The column <code>hosts.password_mysql</code>.
     */
    public final TableField<HostsRecord, String> PASSWORD_MYSQL = createField("password_mysql", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>hosts.password_host</code>.
     */
    public final TableField<HostsRecord, String> PASSWORD_HOST = createField("password_host", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * Create a <code>hosts</code> table reference
     */
    public Hosts() {
        this(DSL.name("hosts"), null);
    }

    /**
     * Create an aliased <code>hosts</code> table reference
     */
    public Hosts(String alias) {
        this(DSL.name(alias), HOSTS);
    }

    /**
     * Create an aliased <code>hosts</code> table reference
     */
    public Hosts(Name alias) {
        this(alias, HOSTS);
    }

    private Hosts(Name alias, Table<HostsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Hosts(Name alias, Table<HostsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Hosts(Table<O> child, ForeignKey<O, HostsRecord> key) {
        super(child, key, HOSTS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.HOSTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<HostsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_HOSTS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<HostsRecord> getPrimaryKey() {
        return Keys.KEY_HOSTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<HostsRecord>> getKeys() {
        return Arrays.<UniqueKey<HostsRecord>>asList(Keys.KEY_HOSTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hosts as(String alias) {
        return new Hosts(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hosts as(Name alias) {
        return new Hosts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Hosts rename(String name) {
        return new Hosts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Hosts rename(Name name) {
        return new Hosts(name, null);
    }
}
