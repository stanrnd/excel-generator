package com.stanrnd.excel;

public class Main {

	public static void main(String[] args) {
		String str = "??NMMAAgoogggl  legoooggooooggle";
		char[] chars = str.toCharArray();
		int[] temp = new int[255];
		char prevChar = str.charAt(0);
		for(char ch:chars) {
			temp[ch]++;
			if(temp[ch] % 2 != 0 && prevChar != ch && temp[prevChar]%2!=0) {
				temp[prevChar]--;
			}
			prevChar = ch;
		}
		
		for(int i=0;i<temp.length;i++) {
			if(temp[i] > 1) {
				System.out.println((char)(i) + ": " + temp[i]/2);
			}
		}
		
	}

}
