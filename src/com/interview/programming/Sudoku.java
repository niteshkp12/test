package com.interview.programming;

import java.util.List;
import java.util.Scanner;

/**
 * Soduku solving class
 * @author nitesh
 *
 */
public class Sudoku {
    public final static int[] samplePuzzle = new int [] {
        0,0,2,5,0,0,0,0,3,
        0,4,0,0,6,7,0,0,0,
        1,5,0,0,0,3,0,0,0,
        0,0,8,0,0,0,0,0,4,
        5,6,0,0,0,0,0,1,7,
        4,0,0,0,0,0,8,0,0,
        0,0,0,6,0,0,0,8,1,
        0,0,0,1,8,0,0,2,0,
        2,0,0,0,0,5,7,0,0 };
    
    public static List<Integer> locations = null;
    public static void main(String[] args) {
    	printSoduku();
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Please enter the number of times to check value(0-9) at position(1-81):");
    	int times = sc.nextInt();
    	for (int i = 0; i < times; i++) {
			System.out.print("Please enter the position (1-81) :");
			int position = sc.nextInt();
			System.out.print("Please enter the value (1-9) :");
    		int value = sc.nextInt();
    		boolean checkValue = checkValueAtPosition(position, value);
    		System.out.printf("Value can be a match at position: %b \n\n", checkValue);
		}    	
    	sc.close();
    }

	public static boolean checkValueAtPosition(int position, int value) {
		boolean checkValue = false;
		if (position > 0 && position <= 81 && value > 0 && value <=90 ) {
			boolean row = checkInRow(position - 1, value);
			boolean column = checkInColumn(position - 1, value);
			boolean square = checkInSquare(position - 1, value);			
			checkValue = (row && column && square);
		} else {
			System.err.println("Please enter position between 1 to 81 and value between 1 to 9");
		}
		return checkValue;
	}

	/**
	 * Check value in the square box 3X3
	 * @param position
	 * @param value
	 * @return
	 */
	public static boolean checkInSquare(int position, int value) {
		int row = position / 27;
		int column = position % 9;
		column = column / 3;
		for (int i = 0, firstRow = row * 27; i < 3; i++) {
			for (int j = 0, k = column * 3; j < 3; j++) {
				int location = firstRow + (i) * 9 + k + j;
				locations.add(location);
				if (samplePuzzle[location] == value)
					return false;
			}
		}
		return true;
	}

	/**
	 * Check value in the column
	 * @param position
	 * @param value
	 * @return
	 */
	public static boolean checkInColumn(int position, int value) {
		int column = position % 9;
		for (; column < samplePuzzle.length; column = column + 9) {
			if (samplePuzzle[column] == value) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check value in the rows
	 * @param position
	 * @param value
	 * @return
	 */
	public static boolean checkInRow(int position, int value) {
		int column = position / 9;
		for (int i = column * 9; i < (column + 1)*9; i++) {
			if (samplePuzzle[i] == value) {
				return false;
			}
		}
		return true;
	}

	/**
	 * print soduku
	 */
	public static void printSoduku() {
		for (int i = 0; i < samplePuzzle.length; i++) {
			if ((i)%27 == 0){
				System.out.printf("\n_______________\n");
			}else
			if ((i ) % 9 == 0) {
				System.out.println("");
			} else if ((i ) % 3 == 0) {
				System.out.print(" | ");
			}
			
			if(samplePuzzle[i] > 0 ){
				System.out.print(samplePuzzle[i]);
			}else{
				System.out.print("_");
			}

		}
		System.out.printf("\n_______________\n");

	}
}
