package oj008String2Integer;

public class String2Integer {
	public int myAtoi(String str){
		
		// null or empty string
		if(str.equals(null) || str.length() == 0){
			return 0;
		}
		
		// whitespaces
		str = str.trim();
		
		// '+' or '-'
		boolean positive = true;
		int i = 0;
		if(str.charAt(0) == '+'){
			positive = true;
			i++;
		}
		if(str.charAt(0) == '-'){
			positive = false;
			i++;
		}
		
		// real value
		double value = 0;
		for(; i < str.length(); i++){
			int digit = str.charAt(i) - '0';
			if(digit >= 0 && digit <=9){
				if(positive){
					value = 10 * value + digit;
					if(value > Integer.MAX_VALUE){
						return Integer.MAX_VALUE;
					}
				} else {
					value = 10 * value - digit;
					if(value < Integer.MIN_VALUE){
						return Integer.MIN_VALUE;
					}
				}
				
			} else {
				break;
			}
		}
		return (int)value;
	}

}
