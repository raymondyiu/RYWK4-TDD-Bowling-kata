package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Bowling {

    private static final String COMMA_DELIMITER = ",";
    private List<List<String>> csvData;
    private int convert2value(char inputChar){
        // if 'X', frameScore[0][i]=10
        // if '/', frameScore[0][i]=10
        // if '-', frameScore[0][i]=0
        // if [1..9] frameScore[0][i]=no of pins
        // other return -1
        // use switch statement
        switch (inputChar) {
            case '-':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'X':
                return 10;
            case '/':
                return 10;
            default:
                return 0;
        }
    }
    public int score (String frameStr){
        // create spare Flag store the state
        boolean spareFlag=false;
        // strikeMode = 0 (no previous strike), 1 (add score to previous), 2 (add score to previous 2)
        int strikeMode=0;
        // create a 3 x 10 two dimensions array to store the scores
        int[][] frameScore = new int[3][10];
        // store the total score
        int totalScore = 0;
        // initialize two dimensions array
        for (int i=0; i<3; i++){
            for (int j=0; j<10; j++){
                frameScore[i][j] = 0;
            }
        }
        //use string.split to break a give string around matches of space
        String[] frames = frameStr.split(" ");

        //for each frames check the first and second character
        for (int i=0; i<frames.length; i++){
            // use String.charAt() to get character
            char firstChar = frames[i].charAt(0);

            // if 'X', check first character only
            if (firstChar == 'X') {
                frameScore[0][i] = 10;
            }  else {

                frameScore[0][i] = convert2value(firstChar);
                char secondChar = frames[i].charAt(1);
                frameScore[0][i] += convert2value(secondChar);
            }

            // if strikeMode

            // if spareFlag = true, add score to previous frame

            totalScore += frameScore[0][i] + frameScore[1][i] + frameScore[2][i];
        }

        return totalScore;
    }

}
