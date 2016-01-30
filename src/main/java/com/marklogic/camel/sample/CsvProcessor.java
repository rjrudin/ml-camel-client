package com.marklogic.camel.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;

/**
 * Simple Java class for showing how we can implement custom delimited-text processing and then feed the results into a
 * Velocity template for XML generation.
 * 
 * We expect the delimited text to have two values - a name, consisting of a space-delimited first and last name; and a
 * birth date. Ingesting this via mlcp would result in two elements, but we'll instead show how we can use Velocity to
 * create 3 elements instead - one for first name, one for last name, and one for date of birth. This is a simple
 * example, but it shows how you can create the precise XML you want before ingesting it either via mlcp or XCC.
 */
public class CsvProcessor {

    @Handler
    public void processCsv(Exchange exchange) {
        // We assume Camel CSV is used beforehand to set the body to a List<List<String>>
        @SuppressWarnings("unchecked")
        List<List<String>> list = (List<List<String>>) exchange.getIn().getBody();

        List<String> tokens = list.get(0);

        // Build up a model for Velocity to use
        Map<String, Object> model = new HashMap<String, Object>();

        String[] nameParts = tokens.get(0).split(" ");
        model.put("firstName", nameParts[0]);
        model.put("lastName", nameParts[1]);
        model.put("birthDate", tokens.get(1));

        exchange.getIn().setBody(model);

        // Set the header required by ml-xcc for ingestion
        exchange.getIn().setHeader("MlXccUri", tokens.get(0) + ".xml");
    }
}
