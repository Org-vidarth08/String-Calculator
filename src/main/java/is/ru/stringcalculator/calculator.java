package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.regex.*;

public class Calculator {

	public static int add(String text){
		//ef ekkert er í fallinu þá skilar fallið 0
		if (text.equals("")){
			return 0;
		}

		if(text.contains("-")){
			//Fall sem kallar fallið "negativeNumners" 
			//sem höndlar mínus tölur, þ.e. þegar negative 
			//tölur eru teknar inn
			negatives(text);
		}

		//delimiter getur verið "," eða new line
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;

		return toInt(text);
	} 
	//Fall til að höndla neikvæðar tölur, þ.e. hendir þeim út og 
	//listar þær upp í message.
	private static void negatives(String text) throws IllegalArgumentException{
		String[] digits = text.split("-");
		String message = "Negatives not allowed: ";
		for(int i = 1; i < digits.length; i++){
			message += "-" + digits[i].substring(0,1);
			if(i < digits.length - 1){
				message += ",";
			}
		}
		throw new IllegalArgumentException(message);
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