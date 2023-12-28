package com.animousen4.core.file.write;

import com.animousen4.core.file.AbstractOutputFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

abstract public class OutputWriterFile<T> extends AbstractOutputFile implements OutputWriter<T>{
    public OutputWriterFile(OutputStreamWriter writer) {
        super(writer);
    }

    public void save(T entity) throws IOException {
        write(convertEntityToString(entity));
    }

    abstract String convertEntityToString(T ent);
    private void write(String str) throws IOException {
        BufferedWriter writer = new BufferedWriter(streamWriter);
        writer.write(str);
        writer.close();
    }

}
