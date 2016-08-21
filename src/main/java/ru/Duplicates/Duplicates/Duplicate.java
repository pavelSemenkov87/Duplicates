package ru.Duplicates.Duplicates;

import java.io.File;

public interface Duplicate {
    boolean process(File firstFile, File secondFile);
}
