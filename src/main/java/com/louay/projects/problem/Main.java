package com.louay.projects.problem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfScore = inputNumberOfScore(input);

        Integer [] scoreArray = fillScoreArray(input, numberOfScore);

        String [][] tableResultArray = fillTableResultArray(numberOfScore,scoreArray);

        printResultArray(tableResultArray);

    }

    public static int inputNumberOfScore(Scanner input) {
        System.out.print("please input number of season (number of score) : ");
        int numberOfScore = input.nextInt();
        return numberOfScore;
    }

    public static Integer[] fillScoreArray(Scanner input, int numberOfScore){
        Integer [] scoreArray = new Integer[numberOfScore];
        for (int i = 0; i <scoreArray.length ; i++) {
            System.out.printf("please input %s score",(i+1));
            scoreArray[i] = input.nextInt();
        }
        return scoreArray;
    }

    public static String[][] fillTableResultArray(int numberOfScore, Integer [] scoreArray){
        String [][] tableResultArray = new String[numberOfScore+2][6];

        Integer minimum = Integer.MAX_VALUE;
        Integer maximum = Integer.MIN_VALUE;
        Integer min = 0;
        Integer max = 0;
        Integer current = 0;
        Integer back = 0;
        for (int i = 0; i <tableResultArray.length ; i++) {
            for (int j = 0; j < tableResultArray[i].length; j++) {
                if (i == 0) {
                    if (j == 2) {
                        tableResultArray[i][j] = "Count";
                    } else {
                        tableResultArray[i][j] = " ";
                    }
                } else if (i == 1) {
                    if (j == 0) {
                        tableResultArray[i][j] = "Game";
                    } else if (j == 1) {
                        tableResultArray[i][j] = "Score";
                    } else if (j == 2) {
                        tableResultArray[i][j] = "Minimum";
                    } else if (j == 3) {
                        tableResultArray[i][j] = "Maximum";
                    } else if (j == 4) {
                        tableResultArray[i][j] = "Min";
                    } else if (j == 5) {
                        tableResultArray[i][j] = "Max";
                    }
                } else if (i > 1){
                    if (j == 0) {
                        tableResultArray[i][j] = Integer.toString(i - 2);
                    } else if (j == 1) {
                        tableResultArray[i][j] = scoreArray[i-2].toString();
                    } else if (j == 2) {
                        if (scoreArray[i-2] <= minimum) {
                            minimum = scoreArray[i-2];
                            tableResultArray[i][j] = scoreArray[i-2].toString();
                        }else {
                            tableResultArray[i][j] = minimum.toString();
                        }
                    } else {
                        if (j == 3) {
                            if (scoreArray[i-2] >= maximum) {
                                maximum = scoreArray[i-2];
                                tableResultArray[i][j] = scoreArray[i-2].toString();
                            }else {
                                tableResultArray[i][j] = maximum.toString();
                            }
                        } else if (j == 4) {
                            if (i == 2) {
                                tableResultArray[i][j] = Integer.toString(0);
                            } else {
                                current = Integer.parseInt(tableResultArray[i][2]);
                                back = Integer.parseInt(tableResultArray[i - 1][2]);
                                if (current < back) {
                                    ++min;
                                    tableResultArray[i][j] = min.toString();
                                } else {
                                    tableResultArray[i][j] = min.toString();
                                }
                            }
                        } else if (j == 5) {
                            if (i == 2) {
                                tableResultArray[i][j] = Integer.toString(0);
                            } else {
                                current = Integer.parseInt(tableResultArray[i][3]);
                                back = Integer.parseInt(tableResultArray[i - 1][3]);
                                if (current > back) {
                                    ++max;
                                    tableResultArray[i][j] = max.toString();
                                } else {
                                    tableResultArray[i][j] = max.toString();
                                }
                            }
                        }
                    }
                }
            }
        }
        return tableResultArray;
    }

    public static void printResultArray(String [][] tableResultArray){
        System.out.println();
        for (int i = 0; i < tableResultArray.length ; i++) {
            for (int j = 0; j < tableResultArray[i].length ; j++) {
                if (i == 0){
                    System.out.print("     "+tableResultArray[i][j]);
                }else if (i < 2){
                    System.out.print(tableResultArray[i][j]+"   ");
                }else {
                    System.out.print(tableResultArray[i][j]+"       ");
                }
            }
            System.out.println();
        }
    }
}
