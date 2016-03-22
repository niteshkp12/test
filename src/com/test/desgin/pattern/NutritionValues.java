package com.test.desgin.pattern;

import com.test.desgin.pattern.NutritionValues.Builder;

public class NutritionValues {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;

	public static class Builder {
		private int servingSize;
		private int servings;
		private int calories;
		private int fat;

		public Builder(int servingSize, int servings) {
			super();
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			this.calories = val;
			return this;
		}

		public Builder fat(int val) {
			this.fat = val;
			System.out.println(this.toString());
			return this;
		}

		public NutritionValues build() {
			return new NutritionValues(this);
		}

	}

	private NutritionValues(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
	}

	@Override
	public String toString() {
		return "NutritionValues [servingSize=" + servingSize + ", servings="
				+ servings + ", calories=" + calories + ", fat=" + fat + "]";
	}

}

class Test {
	public static void main(String[] args) {
		System.out.println("Test.main()");
		Builder builder = new Builder(10, 20);
		builder.calories(11);
		builder.fat(12);

		NutritionValues nutritionValues = builder.build();

		System.out.println(nutritionValues);
	}
}