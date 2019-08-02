package com.plietnov.task.file;

import com.plietnov.task.Util;
import com.plietnov.task.bean.Basket;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectForPart2 {

    private static final Logger LOGGER = Logger.getLogger(ObjectForPart2.class);
    private static final String FILE_NAME = Util.getResource("file_name");

    public void write(Basket container, int number) {
        File file = new File(FILE_NAME);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (int i = 0; i < number; i++) {
                oos.writeObject(container);
                LOGGER.info(file.length() + " ");
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
