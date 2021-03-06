package org.sape.tesco.perfectnumber;

public class NumberChecker {
	
	private static final int NUMBER_TWO=2;
	
	public static boolean checkNumber(int numberToBeChecked){
		boolean result=false;
		if(numberToBeChecked>1){			
			int accumulator = accumulateDivisor(numberToBeChecked, getHalfNumber(numberToBeChecked));
			if(numberToBeChecked==accumulator){
				result=true;
			}
		}
		return result;
	}

	private static int accumulateDivisor(int numberToBeChecked, int halfNumber) {
		int counter;
		int accumulator = 1;
		for(counter=NUMBER_TWO;counter<=halfNumber;counter++){
			if(numberToBeChecked%counter==0){
				accumulator+=counter;
			}
		}
		return accumulator;
	}

	private static int getHalfNumber(int numberToBeChecked) {
		int halfNumber;
		if(numberToBeChecked%NUMBER_TWO==0){
			halfNumber = (int)numberToBeChecked/NUMBER_TWO;
		}else{
			halfNumber = (int)(numberToBeChecked/NUMBER_TWO)+1;
		}
		return halfNumber;
	}

}
