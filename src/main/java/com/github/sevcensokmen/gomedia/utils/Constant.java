package com.github.sevcensokmen.gomedia.utils;

import java.io.File;
import java.io.IOException;

public class Constant {

    public static String PATH;

    static {
        try {
            PATH = new File(".").getCanonicalPath();
        } catch (IOException e) {
            // Should not be here at all
            e.printStackTrace();
        }
    }

    public final static String CONFIG_PROPERTIES_DIRECTORY = PATH
            + "/src/test/resources/properties/config.properties";

    public final static String GECKO_DRIVER_DIRECTORY = PATH
            + "/src/test/resources/executables/geckodriver";

    public final static String CHROME_DRIVER_DIRECTORY = PATH
            + "/src/test/resources/executables/chromedriver";

    public final static String GECKO_DRIVER_DIRECTORY_WINDOWS = PATH
            + "//src//test//resources//executables//geckodriver.exe";

    public final static String CHROME_DRIVER_DIRECTORY_WINDOWS = PATH
            + "//src//test//resources//executables//chromedriver.exe";

    public final static String LOG4J_CONFIG_DIRECTORY = PATH
            + "/src/test/resources/properties/log4j.properties";

    public final static String EMPTY_STRING = "";

}
