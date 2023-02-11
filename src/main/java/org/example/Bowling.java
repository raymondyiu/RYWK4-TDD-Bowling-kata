package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bowling {

    private static final String SPACE_DELIMITER = " ";
    private static final int MAX_PINS = 10;
    private static final int MAX_FRAME = 10;
    private static final int FIRST_FRAME = 0;
    private static final int SECOND_FRAME = 1;
    private static final int LAST_FRAME = MAX_FRAME-1;
    private static final char SPARE = '/';
    private static final char STRIKE = 'X';
    private static final char MISS = '-';
    private List<List<String>> csvData;
    private int convert2value(char inputChar){
        // if 'X', frameScore[0][i]=10
        // if '/', frameScore[0][i]=10
        // if '-', frameScore[0][i]=0
        // if [1..9] frameScore[0][i]=no of pins
        // other return -1
        // use switch statement
        return switch (inputChar) {
            case MISS -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case STRIKE -> MAX_PINS;
            case SPARE -> MAX_PINS;
            default -> 0;
        };
    }
    public int score (String frameStr){
        // create spare flag for each frame
        boolean[] spareFlag = new boolean[MAX_FRAME+2];

        // strikeMode = 0 (no previous strike), 1 (add score 1 time), 2 (add score 2 times)
        int[] strikeMode = new int[MAX_FRAME+2];



        // create a 3 x 10 two dimensions array to store the scores
        int[] frameScore = new int[MAX_FRAME+2];
        // store the total score
        int totalScore = 0;
        // initialize frameScore to zero
        for (int i=0; i<frameScore.length; i++){
                frameScore[i] = 0;
        }
        // initialize spare flag and strike flag
        for (int i=0; i<spareFlag.length; i++){
            spareFlag[i] = false;
            strikeMode[i] = 0;
        }
        //use string.split to break a give string around matches of space
        String[] frames = frameStr.split(SPACE_DELIMITER);

        //for each frames check the first and second character
        for (int i=0; i<frames.length; i++){
            // use String.charAt() to get character
            char firstChar = frames[i].charAt(0);

            // if spareFlag, add score to previous frame
            if (i > FIRST_FRAME) { // skip the first one
                if (spareFlag[i - 1]) {
                    frameScore[i - 1] += convert2value(firstChar);
                }
            }

            // if 'X', check first character only
            if (firstChar == STRIKE) {
                frameScore[i] = MAX_PINS;
                strikeMode[i] = 2;
                // check previous 2 frame's strikeMode
                if (i > FIRST_FRAME){ // skip the first frame
                    if (i == SECOND_FRAME) { // handle second frame
                        if (strikeMode[i-1] > 0) {
                            frameScore[i-1] += MAX_PINS;
                            strikeMode[i-1] -= 1;
                        }
                    } else { // i must greater than or equal 2
                        if (strikeMode[i-1] > 0) {
                            frameScore[i-1] += MAX_PINS;
                            strikeMode[i-1] -= 1;
                        }
                        if (strikeMode[i-2] > 0) {
                            frameScore[i-2] += MAX_PINS;
                            strikeMode[i-2] -= 1;
                        }
                    }
                }
            }  else {

                frameScore[i] = convert2value(firstChar);

                // first value need to check previous two frame
                if (i > FIRST_FRAME){ // skip the first frame
                    if (i == SECOND_FRAME) { //handle second frame
                        if (strikeMode[i-1] > 0) {
                            frameScore[i-1] += convert2value(firstChar);;
                            strikeMode[i-1] -= 1;
                        }
                    } else { // i must greater than or equal 2
                        if (strikeMode[i-1] > 0) {
                            frameScore[i-1] += convert2value(firstChar);;
                            strikeMode[i-1] -= 1;
                        }
                        if (strikeMode[i-2] > 0) {
                            frameScore[i-2] += convert2value(firstChar);;
                            strikeMode[i-2] -= 1;
                        }
                    }
                }
                char secondChar = frames[i].charAt(1);
                // second value need to check for previous one only
                if (i > 0){// skip the first frame
                    if (strikeMode[i-1] > 0) {
                        if (secondChar == SPARE) {
                            //revert the score added in the first roll of this frame
                            frameScore[i - 1] += convert2value(secondChar) - convert2value(firstChar);
                        }else {
                            frameScore[i-1] += convert2value(secondChar);
                        }
                        strikeMode[i-1] -= 1;
                    }
                }
                // if secondChar is SPARE, frameScore is 10 and spareFlag to true
                // else frameScore is first + second value
                if (secondChar == SPARE){
                    frameScore[i]=MAX_PINS;
                    spareFlag[i] = true;
                    if (i == LAST_FRAME) {
                        char thirdChar = frames[i].charAt(2);
                        frameScore[i] += convert2value(thirdChar);
                    }
                } else {
                    frameScore[i] += convert2value(secondChar);
                }
            }
        }

        // sum of MAX_FRAME's frameScore only
        for (int i=0; i<MAX_FRAME; i++){
            totalScore += frameScore[i];
        }

        return totalScore;
    }

}
