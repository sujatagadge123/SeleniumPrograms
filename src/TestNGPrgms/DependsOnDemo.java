package TestNGPrgms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnDemo {
  @Test(priority = 1)
  public void logintest() {
	  System.out.println("Login Test");
	  Assert.assertFalse(false);
  }
  
  @Test(priority = 2, dependsOnMethods = "logintest")
  public void searchProductTest() {
	  System.out.println("Search Product Test");
  }
  
  @Test(priority = 3)
  public void addToCartTest() {
	  System.out.println("Add to Cart Test");
  }
}
