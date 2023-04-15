package TestNGPrgms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExecOrder {
  @Test(priority = 1)
  public void B() {
	  System.out.println("Test2");
	  Assert.assertEquals("selenium", "selenium");
  }
  
  @Test(priority = 3)
  public void a() {
	  System.out.println("Test1");
	  Assert.assertEquals("A", "a1");
  }
  
  @Test(priority = 2)
  public void A() {
	  System.out.println("Test3");
	  Assert.assertTrue(true);
  }
  
  @Test(priority = 4)
  public void d() {
	  System.out.println("Test3");
	  Assert.assertFalse(true);
  }
}


