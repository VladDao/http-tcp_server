package com.plietnov.task;

import com.plietnov.task.entity.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Util {

    private static final Logger LOGGER = Logger.getLogger(Util.class);
    private static final String DATE_TIME_FORMAT_PATTERN = "dd-MM-yyyy HH:mm";
    private static final String INCORRECT_INPUT_DATE = "incorrect input date";
    private static final String INCORRECT_INPUT = "incorrect input.";
    private static final String MESSAGES = "messages";
    private static final Locale EN = new Locale("en", "US");
    private static final Locale RU = new Locale("ru", "RU");
    private static ResourceBundle resourceBundle = ResourceBundle
            .getBundle(MESSAGES, EN);
    private static Map<String, Locale> localeMap = new HashMap<>();

    private Util() {
    }

    public static LocalDateTime readDateFromConsole() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_PATTERN);
        try {
            return LocalDateTime.parse(readFromConsole(), formatter);
        } catch (DateTimeException ex) {
            LOGGER.error(INCORRECT_INPUT_DATE);
        }
        return null;
    }

    public static int readIntFromConsole() {
        try {
            return Integer.parseInt(readFromConsole());
        } catch (DateTimeException ex) {
            LOGGER.error(INCORRECT_INPUT);
        }
        return -1;
    }

    public static String readFromConsole() {
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(System.in));
        String tmpReader = StringUtils.EMPTY;
        try {
            tmpReader = bf.readLine().trim();
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return tmpReader;
    }

    public static String productToJson(Product computer) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(computer);
    }

    public static String getResource(String key) {
        return resourceBundle.getString(key);
    }

    public static void setLocale(String locale) {
        resourceBundle = ResourceBundle.getBundle(MESSAGES,
                localeMap.getOrDefault(locale, EN));
    }

    public static void initLocale() {
        localeMap.put("1", RU);
        localeMap.put("2", EN);
    }
}
