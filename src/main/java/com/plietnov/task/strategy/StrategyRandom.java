package com.plietnov.task.strategy;

import org.apache.log4j.Logger;

import java.security.SecureRandom;

public class StrategyRandom implements Strategy {

    private static final Logger LOGGER = Logger.getLogger(StringBuilder.class);
    private static final int RANDOM_LIMIT = 200000;

    @Override
    public String getString(String string) {
        String result = string + randomInt();
        LOGGER.info(string + "= " + result);
        return result;
    }

    @Override
    public int getInt(String string) {
        int result = randomInt();
        LOGGER.info(string + "= " + result);
        return result;
    }

    @Override
    public double getDouble(String string) {
        double result = randomDouble();
        LOGGER.info(string + "= " + result);
        return result;
    }

    private int randomInt() {
        SecureRandom random = new SecureRandom();
        return random.nextInt(RANDOM_LIMIT);
    }

    private double randomDouble() {
        SecureRandom random = new SecureRandom();
        return random.nextDouble() * randomInt();
    }
}

