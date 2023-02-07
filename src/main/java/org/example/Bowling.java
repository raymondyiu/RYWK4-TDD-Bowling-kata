package org.example;

public class Bowling {
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
            // if 'X', frameScore[0][i]=10
            // if '/', frameScore[0][i]=10
            // if '-', frameScore[0][i]=0
            // if [1..9] frameScore[0][i]=no of pins
            // use switch method
            switch(firstChar){
                case '1':
                    frameScore[0][i] = 1;
                    break;
            }

            // if strikeMode

            // if spareFlag = true, add score to previous frame

            totalScore += frameScore[0][i] + frameScore[1][i] + frameScore[2][i];
        }

        return totalScore;
    }
}
