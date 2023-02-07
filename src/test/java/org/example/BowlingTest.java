package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingTest {

    @Test
    void score() {
        Bowling bowling = new Bowling();
        assertEquals(10, bowling.score("1- 1- 1- 1- 1- 1- 1- 1- 1- 1-"));
    }
}