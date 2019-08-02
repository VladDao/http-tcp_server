package com.plietnov.task.strategy;

import com.plietnov.task.Util;
import org.apache.log4j.Logger;

public class StrategyManual implements Strategy {

    private static final Logger LOGGER = Logger.getLogger(StringBuilder.class);
    private static final String PLEASE_ENTER = "please_enter";

    @Override
    public String getString(String string) {
        LOGGER.info(Util.getResource(PLEASE_ENTER) + " " + string);
        return Util.readFromConsole();
    }

    @Override
    public int getInt(String string) {
        LOGGER.info(Util.getResource(PLEASE_ENTER) + " " + string);
        return Util.readIntFromConsole();
    }

    @Override
    public double getDouble(String string) {
        LOGGER.info(Util.getResource(PLEASE_ENTER) + " " + string);
        return Double.parseDouble(Util.readFromConsole());
    }
}
