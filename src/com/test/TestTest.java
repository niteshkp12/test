package com.test;

public class TestTest {
	static int[][] array;

	public static void main(String[] args) throws Exception {
		
		Box box = new Box(6, 6);
		findPosition(box, 10);
	}

	private static void createArray(Box box) {
		int even = 0;
		int position = 0;
		int x = box.getX();
		int y = box.getY();
		if (box != null) {
			array = new int[x][y];
			for (int i = x-1; i >= 0; i--) {
				even = even + 1;

				if (!(even % 2 == 0)) {
					for (int j = 0; j < y; j++) {
						position++;
						array[i][j] = position;
					}

				} else {
					for (int j = y-1; j >= 0; j--) {
						position++;
						array[i][j] = position;
					}
				}
			}
		}

	}

	private static void findPosition(Box box, int n) {
		createArray(box);

		for (int i = 0; i < box.getX(); i++) {
			for (int j = 0; j < box.getY(); j++) {
				if (array[i][j] == n) {
					System.out.println((i + 1) + "X" + (j + 1));
				}

			}

		}
		for (int i = 0; i < box.getX(); i++) {
			for (int j = 0; j < box.getY(); j++) {
					System.out.print(array[i][j] + " ");

			}
			System.out.println(" ");

		}
	}

}

class Box {
	int x;
	int y;

	public Box(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}