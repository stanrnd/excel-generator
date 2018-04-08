package com.stanslab.excel.meta;

public enum FontSize {
	
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11), TWELVE(12), THIRTEEN(13), FOURTEEN(14), FIFTEEN(15), SIXTEEN(16), SEVENTEEN(17), EIGHTEEN(18), NINTEEN(19), TWENTY(20);

	private int size;
	
	private FontSize(int size) {
		this.size = size;
	}
	
	public static FontSize find(int size) {
		for(FontSize fontSize:values()) {
			if(fontSize.size == size) {
				return fontSize;
			}
		}
		throw new RuntimeException("No enum found for the size " + size);
	}
	
}
