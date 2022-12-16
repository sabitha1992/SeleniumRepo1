package Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateLoginpage {
@Test

public void validateLoginpageTest() {
	//HardAssert
	System.out.println("Test started............. ");
	Assert.assertEquals(5, 5,"Number arnot same");
	System.out.println("Hard assert1 is done...");
	Assert.assertTrue("hello".endsWith("Hello"), "String are not equal");
	System.out.println("Hard assert2 is done...");
	System.out.println("Test ended successfully.........");
}
}
