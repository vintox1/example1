package testsuite1;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseClass1 {
	
	public static WebDriver wd = new FirefoxDriver();
//even more changes happening on master trunk while changes are happening on V2.1 elsewhere 

    @BeforeMethod
    public void setUp() throws Exception {
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.get("http://the-internet.herokuapp.com/");
    }
	
    
    //This method will return two dimensional array.
    //This method behaves as data provider for LogIn_Test method.
    @DataProvider
    public Object[][] LoginCredentials(){
     //Created two dimensional array with 4 rows and 2 columns.
     //4 rows represents test has to run 4 times.
     //2 columns represents 2 data parameters.
     Object[][] Cred = new Object[2][2];
     
     Cred[0][0] = "UserId1";
     Cred[0][1] = "Pass1";
     Cred[1][0] = "tomsmith";
     Cred[1][1] = "SuperSecretPassword!";
     return Cred; //Returned Cred
    }
    
    @AfterTest
        public void tearDown() throws Exception {
    	wd.quit();
    } 

}
