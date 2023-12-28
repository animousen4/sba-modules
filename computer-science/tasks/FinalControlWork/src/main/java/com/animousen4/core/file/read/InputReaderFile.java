package com.animousen4.core.file.read;

import com.animousen4.core.file.AbstractInputFile;
import com.animousen4.core.file.AbstractOutputFile;

import java.io.InputStreamReader;

abstract public class InputReaderFile<T> extends AbstractInputFile implements InputReader<T>{
    public InputReaderFile(InputStreamReader streamReader) {
        super(streamReader);
    }
}
