package com.animousen4.core.file.read;

import com.animousen4.core.file.AbstractIOFIle;

abstract public class InputReaderFile<T> extends AbstractIOFIle implements InputReader<T>{
    public InputReaderFile(String fileName) {
        super(fileName);
    }
}
