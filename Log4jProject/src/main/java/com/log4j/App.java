package com.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger LOG = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LOG.debug("This is a debug statement");
        LOG.info("This is Info Log");
        LOG.warn("This is Warn Log");
        LOG.error("This is Error Log");
        LOG.fatal("This is Fatal Log");
        LOG.trace("This is trace Log");
    }
}
