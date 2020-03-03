package com.teachy.coins.infrastructure;

import org.jooq.DSLContext;
import org.jooq.ExecuteContext;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultExecuteListener;

import java.text.MessageFormat;

public class JooqLogListener extends DefaultExecuteListener {


    long startTime = 0;

    String logTemplate = "{0} execute-time: {1}ms";

    String logContent = "";

    /**
     * Hook into the query execution lifecycle before executing queries
     */
    @Override
    public void executeStart(ExecuteContext ctx) {
        super.executeStart(ctx);
        startTime = System.currentTimeMillis();
        DSLContext create = DSL.using(ctx.dialect(),
                new Settings().withRenderFormatted(true));

        // If we're executing a query
        if (ctx.query() != null) {
            logContent = create.renderInlined(ctx.query());
        }

        // If we're executing a routine
        else if (ctx.routine() != null) {
            logContent = create.renderInlined(ctx.routine());
        }
    }

    @Override
    public void executeEnd(ExecuteContext ctx) {
        super.executeEnd(ctx);
        long takeTime = System.currentTimeMillis() - startTime;
        System.out.println(MessageFormat.format(logTemplate, logContent, takeTime));
    }
}