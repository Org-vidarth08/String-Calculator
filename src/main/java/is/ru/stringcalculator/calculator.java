package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.regex.*;

public class Calculator {

	public static int add(String text){
		if (text.equals("")){
			return 0;
		}

		//delimiter getur verið "," eða new line
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	} 

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String number){
		//athuga hvort delimiter byrjar á "//"
		if(number.startsWith("//")){
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(number);
			m.matches();
			String delimiter = m.group(1);
			String restOfNumber = m.group(2);
			return restOfNumber.split(delimiter);
		}

		return number.split(",|\n");
	}
     
    private static int sum(String[] numbers){
    	int total = 0;
		for(String number : numbers){
			total += toInt(number);
		}

		return total;
	}

}	