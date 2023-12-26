package com.animousen4.core.file.read;

import java.io.FileNotFoundException;

public interface InputReader<T> {
    T read() throws FileNotFoundException;
}
