package com.rjrudin.marklogic.camel.sample;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.factory.annotation.Autowired;

import com.rjrudin.marklogic.xcc.XccTemplate;

public class CurrentTimeXmlGenerator {

    @Autowired
    private XccTemplate xccTemplate;

    /**
     * This is a simple method that sets the body of the input message to a simple block of XML with
     * the current time in it. You could do anything you like in here - generate any kind of body
     * you want - and then use a Camel File2 component to write it to a file, where mlcp can then
     * ingest it.
     * 
     * See http://camel.apache.org/bean.html for more info on Camel Bean components.
     * 
     * @param exchange
     */
    @Handler
    public void generateCurrentTimeAsXml(Exchange exchange) {
        String xml = xccTemplate.executeAdhocQuery("<sample>The current time is {fn:current-dateTime()}</sample>");
        exchange.getIn().setBody(xml);
    }

    public void setXccTemplate(XccTemplate xccTemplate) {
        this.xccTemplate = xccTemplate;
    }
}
