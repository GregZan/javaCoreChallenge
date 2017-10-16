package com.company;

import java.util.Scanner;

public class Main {
            public static void main(String args[]) {
                char[][] sea = inputMatrix();
                printMatrix(sea);

                if (isNemoInThere(sea)) {
                    System.out.println("Nemo found!!!");
                } else {
                    System.out.println("Nemo Not Found! :/");
                }
            }

            public static boolean isNemoInThere(char[][] sea) {
                String nemoFound = "";
                for (int i = 0; i < sea[0].length; i++){
                    for (int j = 0; j < sea[0].length; j++){
                        //Checking upward
                        if (sea[i][j] == 'N' || sea[i][j] == 'n'){
                            if (i > 2) {
                                nemoFound = Character.toString(sea[i][j]) + Character.toString(sea[i-1][j]) + Character.toString(sea[i-2][j]) + Character.toString(sea[i-3][j]);
                            }else if (i < 2) {
                                nemoFound = Character.toString(sea[i][j]) + Character.toString(sea[i+1][j]) + Character.toString(sea[i+2][j]) + Character.toString(sea[i+3][j]);
                            }
                            if (nemoFound.equalsIgnoreCase("nemo")) {
                                return true;
                            } else if (j < 2) {
                                nemoFound = Character.toString(sea[i][j]) + Character.toString(sea[i][j+1]) + Character.toString(sea[i][j+2]) + Character.toString(sea[i][j+3]);
                            } else {
                                nemoFound = Character.toString(sea[i][j]) + Character.toString(sea[i][j-1]) + Character.toString(sea[i][j-2]) + Character.toString(sea[i][j-3]);
                            }
                            if (nemoFound.equalsIgnoreCase("nemo")) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            private static void printMatrix(char[][] matrix) {
                System.out.println();
                for (int m = 0; m < matrix.length; m++) {
                    char[] row = matrix[m];
                    for (int n = 0; n < row.length; n++) {
                        char col = row[n];
                        System.out.print(col + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }

            private static char[][] inputMatrix() {
                Scanner scanner = new Scanner(System.in);
                char[][] matrix = new char[5][];
                for (int i = 0; i < 5; i++) {
                    do {
                        System.out.print("Line #"+(i+1)+": ");
                        matrix[i] = scanner.nextLine().toUpperCase().trim().toCharArray();
                    } while (matrix[i].length != 5); // Ha! Told you do-whiles are useful! :P
                }
                return matrix;
            }
        }


