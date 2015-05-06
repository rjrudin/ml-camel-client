package com.marklogic.camel.sample;

import org.apache.camel.Exchange;

public class WbSearchInitializer {

    private int rows = 500;
    private int page = 3;

    public void setHeadersForSearch(Exchange exchange) {
        exchange.getIn().setHeader("WbSearchStart", (page * rows) + 1);
        exchange.getIn().setHeader("WbSearchRows", rows);
        page++;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
