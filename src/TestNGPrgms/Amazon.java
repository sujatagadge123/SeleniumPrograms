package TestNGPrgms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon {
	@Test(priority = 1, groups = "smokeTest")
	  public void floginTest() {
		  System.out.println("Amazon Login Test");
		  Assert.assertFalse(false);
	  }
	  @Test(priority = 1, groups = "RegressionTest")
	  public void fsearchProductTest() {
		  System.out.println("Amazon Search Product Test");
		 
	}
	  @Test(priority = 1, groups = "RegressionTest")
	  public void faddToCartTest() {
		  System.out.println("Amazon add to cart test");
	  }}


