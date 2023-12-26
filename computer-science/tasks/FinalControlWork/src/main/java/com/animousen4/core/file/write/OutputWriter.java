package com.animousen4.core.file.write;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OutputWriter<T> {
    void save(T entity) throws IOException;
}
