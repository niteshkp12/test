package com.interview.programming;

import java.util.Scanner;

public class TestArmstrong {
	public static void main(String[] args) {
	      //input number to check if its Armstrong number
		System.out.println("Please enter a 3 digit number to find if its an Armstrong number:");
        int number = new Scanner(System.in).nextInt();
        //printing result
        if(isArmStrong(number)){
            System.out.println("Number : " + number + " is an Armstrong number");
        }else{
            System.out.println("Number : " + number + " is not an Armstrong number");
        }

    
    }

    /*
     * @return true if number is Armstrong number or return false
     */
    private static boolean isArmStrong(int number) {
        double result = 0;
        int orig = number;
        int len = (number + "").length();
        while(number != 0){
            int remainder = number%10;
            result = result + Math.pow(remainder, len);
            number = number/10;
        }
        //number is Armstrong return true
        if(orig == result){
            return true;
        }
      
        return false;
	}

}