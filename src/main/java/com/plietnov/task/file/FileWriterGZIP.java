package com.plietnov.task.file;

import com.plietnov.task.Util;
import com.plietnov.task.bean.Basket;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPOutputStream;

public class FileWriterGZIP {

    private static final Logger LOGGER = Logger.getLogger(FileWriterGZIP.class);
    private static final String FILE_NAME = Util.getResource("file_name_gz");

    public void write(Basket container) {
        File file = new File(FILE_NAME);
        try (ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)))) {
            oos.writeObject(container);
            oos.flush();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}