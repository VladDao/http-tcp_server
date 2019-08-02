package com.plietnov.task.file;

import com.plietnov.task.Util;
import com.plietnov.task.bean.Basket;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter {

    private static final Logger LOGGER = Logger.getLogger(FileWriter.class);
    private static final String FILE_NAME = Util.getResource("file_name");

    public void write(Basket container) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(container);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }
}
