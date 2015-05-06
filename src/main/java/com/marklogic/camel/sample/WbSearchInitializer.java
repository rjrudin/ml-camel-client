package com.marklogic.camel.sample;

import org.apache.camel.Exchange;

public class WbSearchInitializer {

    private int rows;
    private int page;

    public void setHeadersForSearch(Exchange exchange) {
        exchange.getIn().setHeader("WbSearchStart", ((page - 1) * rows) + 1);
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
