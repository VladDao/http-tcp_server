package com.plietnov.task.file;

import com.plietnov.task.Util;
import com.plietnov.task.bean.Basket;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileReader {

    private static final Logger LOGGER = Logger.getLogger(FileReader.class);
    private static final String FILE_NOT_FOUND = "file_not_found";
    private static final String FILE_NAME = Util.getResource("file_name");

    public Basket read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Basket) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(Util.getResource(FILE_NOT_FOUND));
        }
        return new Basket();
    }
}
