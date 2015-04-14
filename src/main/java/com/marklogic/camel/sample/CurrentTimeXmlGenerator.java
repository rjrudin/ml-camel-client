package com.marklogic.camel.sample;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;

public class CurrentTimeXmlGenerator {

    /**
     * This is a simple method that sets the body of the input message to a simple block of XML with the current time in
     * it. You could do anything you like in here - generate any kind of body you want - and then use a Camel File2
     * component to write it to a file, where mlcp can then ingest it.
     * 
     * See http://camel.apache.org/bean.html for more info on Camel Bean components.
     * 
     * @param exchange
     */
    @Handler
    public void generateCurrentTimeAsXml(Exchange exchange) {
        String xml = "<sample>The current time is " + new Date() + "</sample>";
        exchange.getIn().setBody(xml);
    }
}
