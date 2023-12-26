package com.animousen4.core.file.write;

import com.animousen4.core.file.AbstractIOFIle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

abstract public class OutputWriterFile<T> extends AbstractIOFIle implements OutputWriter<T>{
    public OutputWriterFile(String fileName) {
        super(fileName);
    }

    public void save(T entity) throws IOException {
        write(convertEntityToString(entity));
    }

    abstract String convertEntityToString(T ent);
    private void write(String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);
        writer.close();
    }

}
