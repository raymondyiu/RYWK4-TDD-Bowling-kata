# Bowling Game Kata

## Problem Description
https://codingdojo.org/kata/Bowling/


## TDD Approaches
1. Solve the simple cases which exclude all strike and spare, 
add all the characters [1..9] and '-'=0 to produce the total score. <br>

    `<total score>, <score of each frame>`<br>
    `10,1- 1- 1- 1- 1- 1- 1- 1- 1- 1-`<br>

| 1st frame | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 1         | 1   | 1   | 1   | 1   | 1   | 1   | 1   | 1   | 1    |

Total score is 10

    `20,11 11 11 11 11 11 11 11 11 11`<br>

| 1st frame | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 2         | 2   | 2   | 2   | 2   | 2   | 2   | 2   | 2   | 2    |

Total score is 20


2. handle spare cases<br>
       take below test case for example:<br>
       `116,1/ 1/ 1/ 1/ 1/ 2/ 2/ 2/ 2/ 2/2`<br>
- frist frame<br>
      Score of 1st frame 10 and other are zero<br>
      
| 1st score | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 10        |     |     |     |     |     |     |     |     |      |

- second frame <br>
if previous frame is spare, add current 1st number of knock down pins. <br>
Set the current score = 10<br>

| 1st score | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 11        | 10  |     |     |     |     |     |     |     |      |

- 10th frame<br>
if 10th frame is a spare, add the third roll<br>

| 1st score | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 11        | 11  | 11  | 11  | 12  | 12  | 12  | 12  | 12  | 12   |

Total score is 116

3. handle strike cases<br>
    take below case for example<br>
    `300,X X X X X X X X X X X X`<br>

- First frame

| 1st frame | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 10        |     |     |     |     |     |     |     |     |      |

- Second frame<br>
    check previous strike frame, add current 1st number of knock down pins.<br>
    set current score to 10 <br>

| 1st frame | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 20        |10   |     |     |     |     |     |     |     |      |

- third frame<br>
  check previous two strike frame, add 10<br>
  check previous one strike frame, add 10<br>
  set current score to 10 <br>

| 1st frame | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|
| 30        | 20  | 10  |     |     |     |     |     |     |      |

- 10th frame, 11th frame and 12th frame<br>
    Logic is the same as third frame which make up the total 10th frame's score to 30.<br>
    However the total score only count to the 10th frame. So the frame score for 11th and 12th frame will be ignored.<br>
    Therefore the total score is 300 for all strike case.

| 1st frame | 2nd | 3rd | 4th | 5th | 6th | 7th | 8th | 9th | 10th | 11th(ignored) | 12th(ignored) |
|-----------|-----|-----|-----|-----|-----|-----|-----|-----|------|---------------|---------------|
| 30        | 30  | 30  | 30  | 30  | 30  | 30  | 30  | 30  | 30   | 20            | 10            |

Total score is 300.