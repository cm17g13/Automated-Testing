package com.qa.quickstart.blackjack;


public class Blackjack {

	public static void main(String[] args) {

		int int1 = 19;
		int int2 = 18;
		int int3 = 18;
		
		System.out.println(blackjack(int1, int2));
		System.out.println(uniqueSum(int1, int2, int3));

		int temperature = 95;
		boolean isSummer = true;
		
		System.out.println(tooHot(temperature, isSummer));
		
	}

	public static int blackjack(int int1, int int2) {		
		if (int1 >= int2 && int1 < 22) {
			return int1;
		} else if (int2 < 22) {
			return int2;
		} else if (int1 < 22){
			return int1;
		} else {
			return 0;
		}
		
	}
	
	public static int uniqueSum(int int1, int int2, int int3) {
		
		int result = 0;
		if (int1 != int2 && int1 != int3) {
			result += int1;
		} 
		if (int2 != int1 && int2 != int3) {
			result += int2;
		} 
		if (int3 != int1 && int3 != int2) {
			result += int3;
		} 
		return result;
	}
	
	public static boolean tooHot(int temperature, boolean isSummer) {
		int limit = 90;
		if (isSummer) {
			limit = 100;
		}
		if (temperature >= 60 && temperature <= limit) {
			return true;
		} else {
			return false;
		}
	}
}