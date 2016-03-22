package com.interview.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SudokuTest {

	private Sudoku sudoku;

	@Before
	public void setup() {
		
	}

	@Test
	public void TestFirstSquare() {
		List<Integer> values = new ArrayList<>(Arrays.asList(0, 1, 2, 9, 10, 11, 18, 19, 20));
		sudoku.checkInSquare(0, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(11, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(20, 33);
		assertEquals(sudoku.locations, values);
	}

	@Test
	public void TestSecondSquare() {
		List<Integer> values = new ArrayList<>(Arrays.asList(3,4,5,12,13,14,21,22,23));
		sudoku.checkInSquare(3, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(13, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(23, 33);
		assertEquals(sudoku.locations, values);
	}

	@Test
	public void TestThirdSquare() {
		List<Integer> values = new ArrayList<>(Arrays.asList(6,7,8,15,16,17,24,25,26));
		sudoku.checkInSquare(6, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(17, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(26, 33);
		assertEquals(sudoku.locations, values);
	}

	@Test
	public void TestFourthSquare() {
		List<Integer> values = new ArrayList<>(Arrays.asList(27,28,29,36,37,38,45,46,47));
		sudoku.checkInSquare(28, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(38, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(47, 33);
		assertEquals(sudoku.locations, values);
	}

	@Test
	public void TestFifthSquare() {
		List<Integer> values = new ArrayList<>(Arrays.asList(30,31,32,39,40,41,48,49,50));
		sudoku.checkInSquare(30, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(39, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(50, 33);
		assertEquals(sudoku.locations, values);
	}

	@Test
	public void TestSixthSquare() {
		List<Integer> values = new ArrayList<>(Arrays.asList(33,34,35,42,43,44,51,52,53));
		sudoku.checkInSquare(42, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(51, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(53, 33);
		assertEquals(sudoku.locations, values);
	}


	@Test
	public void TestNinethSquare() {
		List<Integer> values = new ArrayList<>(Arrays.asList(60,61,62,69,70,71,78,79,80));
		sudoku.checkInSquare(60, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(71, 33);
		assertEquals(sudoku.locations, values);
		sudoku.checkInSquare(80, 33);
		assertEquals(sudoku.locations, values);
	}

	

}
