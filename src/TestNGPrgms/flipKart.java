package TestNGPrgms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class flipKart {
  @Test(priority = 1, groups = "smokeTest")
  public void floginTest() {
	  System.out.println("Flipkart Login Test");
	  Assert.assertFalse(false);
  }
  @Test(priority = 1, groups = "RegressionTest")
  public void fsearchProductTest() {
	  System.out.println("Flipkart Search Product Test");
	  
	 
}
  @Test(priority = 1, groups = "RegressionTest")
  public void faddToCartTest() {
	  System.out.println("Flipkart add to cart test");
  }}
