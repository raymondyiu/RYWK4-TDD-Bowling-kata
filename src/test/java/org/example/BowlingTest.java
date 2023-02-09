package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlingTest {

    public List<String[]> readLineByLine(String filename) {
        List<String[]> allData = new ArrayList<>();
        try {
        Path path = Paths.get(
                ClassLoader.getSystemResource(filename).toURI());
            Reader reader = Files.newBufferedReader(path);
            CSVReader csvReader = new CSVReaderBuilder(reader).build();
                allData = csvReader.readAll();

        } catch (Exception e){
            e.printStackTrace();
        }
        return allData;
    }

    @Test
    void score() {
        List<String[]> csvTestCases = new ArrayList<>();;
        csvTestCases = readLineByLine("testcases.csv");

        Bowling bowling = new Bowling();

        for (String[] item : csvTestCases) {
            assertEquals(Integer.valueOf(item[0]), bowling.score(item[1]));
        }

    }
}