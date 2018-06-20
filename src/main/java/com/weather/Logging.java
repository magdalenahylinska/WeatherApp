package com.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private static Logging instance = new Logging ();
    public static final Logger logger = LoggerFactory.getLogger(Logging.class);

    private Logging () {
    }

    public static Logging getInstance() {
        return instance;
    }
}
