package com.eiv;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class App2 {

	private static final Logger LOG = LogManager.getLogger(App2.class);
	public static void main(String[] args) {
		
		LOG.trace("Mensaje de trace");
		LOG.info("Mensaje de info");
		LOG.warn("Mensaje de warn");
		LOG.error("Mensaje de error");
		LOG.fatal("Mensaje fatal");
		

	}

}
