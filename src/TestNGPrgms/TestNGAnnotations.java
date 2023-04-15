package TestNGPrgms;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAnnotations {
  @Test
  public void TestA() {
	  System.out.println("Test A");
  }
  
  public void TestB() {
	  System.out.println("Test B");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BeforeTest");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");

  }

}
