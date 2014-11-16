package testsuite1;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;

//some further changes on V2.1 to fix issues which I will later merge into trunk

public class TwoUsers extends testsuite1.BaseClass1 {
	
//  @Test (priority=0)

	
  //Give data provider method name as data provider.
  //Passed 2 string parameters as LoginCredentials() returns 2 parameters In object.
  @Test(dataProvider="LoginCredentials")
  public void LogIn_Test(String Usedid, String Pass){
    
	  wd.navigate().to("http://the-internet.herokuapp.com/login");
	  
	  wd.findElement(By.id("username")).clear();
	  wd.findElement(By.id("password")).clear();
	  wd.findElement(By.id("username")).sendKeys(Usedid);
	  wd.findElement(By.id("password")).sendKeys(Pass);
	  wd.findElement(By.cssSelector("button.radius")).click();
    
	  String url = wd.getCurrentUrl();
	  System.out.println("My Current URL Is  : "+url);
	  
  	  if (url.contentEquals("http://the-internet.herokuapp.com/login")){
  		  System.out.println("Invalid User Account");
  	  }
  	  
	  if (url.contentEquals("http://the-internet.herokuapp.com/secure")){
		  System.out.println("Valid User Account");	  
	  }
   }
}
