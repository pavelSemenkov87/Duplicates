package ru.Duplicates.Duplicates;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Павел on 21.08.2016.
 */
public class DuplicateImplTest {

    @Test
    public void process() throws Exception {
        Duplicate d = new DuplicateImpl();
        assertEquals(true, d.process(new File("first.txt"), new File("second.txt")));
    }
}