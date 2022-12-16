package Examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateLoginpage2 {
@Test

public void validateLoginpageTest() {
	//SOFTASSERT
	
	SoftAssert softAssertion=new SoftAssert();
	System.out.println("Test started............. ");
	softAssertion.assertEquals(5, 5,"Number arnot same");
	System.out.println("Soft assert1 is done...");
	softAssertion.assertTrue("hello".endsWith("Hello"), "String are not equal");
	System.out.println("Soft assert2 is done...");
	System.out.println("Test ended successfully.........");
}
}
