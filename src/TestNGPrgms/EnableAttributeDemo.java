package TestNGPrgms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableAttributeDemo {
  
  @Test(priority = 1)
  public void loginValidation() {
	  System.out.println("Login");
	  Assert.assertFalse(false);
  }
  
  @Test(priority = 2, enabled = false)
  public void searchProduct() {
	  System.out.println("Search Product");
  }
  
  @Test(priority = 3)
  public void addToCart() {
	  System.out.println("Add to Cart");
  }
}
