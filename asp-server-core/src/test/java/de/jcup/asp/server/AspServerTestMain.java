package de.jcup.asp.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.jcup.asp.server.core.AspServer;

public class AspServerTestMain {

    private static final Logger LOG = LoggerFactory.getLogger(AspServerTestMain.class);
    
    public static void main(String[] args) {
        AspServer server = new AspServer();
        server.setRequestHandler(new DummyOutputClientRequestHandler());
        String portProperty = System.getProperty("asp.server.port");
        try {
            if (portProperty != null) {
                server.setPortNumber(Integer.parseInt(portProperty));
            }
        } catch (NumberFormatException e) {
            LOG.error("worng port definition:{} using default", portProperty);
        }
        server.start();
    }
}
