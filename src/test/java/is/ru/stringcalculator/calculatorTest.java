package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testOneTwoNumber() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(15, Calculator.add("1,2,3,4,5"));
	}

	@Test
	public void testNewLineNumbers(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNewDelimitter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testNegatives(){
	try{ 
    		Calculator.add("1,2,-3,-4"); 
    	}
    	catch (RuntimeException ex){
    		assertEquals("Negatives not allowed: -3,-4", ex.getMessage());
    	}
    }	

    @Test 
	public void testNumberOverThousand(){
		assertEquals(3, Calculator.add("1,2,1010"));
		assertEquals(190, Calculator.add("//;\n10;80;90;2020;10;3456"));
	}	

	@Test 
	public void testMultipleDelimiterLength(){
		assertEquals(7, Calculator.add("//[**]\n2**2**3"));
	}

	@Test
	public void testDiffTypesInOne(){
		assertEquals(8, Calculator.add("//&\n2&2&1900&2&2"));
	}

	//@Test
	//public void testNegativeAgain(){
	//	assertEquals("Negatives not allowed: -1, -5", Calculator.add("-1,1,2,3,-5"));
	//}									
}



