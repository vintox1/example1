package testsuite1;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

//example of a change to the checkbox class
//and yet another change to compare

public class Checkbox1 extends testsuite1.BaseClass1 {
	
 //   @BeforeMethod
//    public void setUp() throws Exception {
//        wd = new FirefoxDriver();
//        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    }
    
    @Test
    public void checkbox() {
    	wd.navigate().to("http://the-internet.herokuapp.com/");
        wd.findElement(By.linkText("Checkboxes")).click();
    
        //CHECKBOX1
        //check the state of the fist check box and once known, click it to change it's state 
        //using if else statement 
        if (wd.findElement(By.cssSelector("input[type=\"checkbox\"]")).isSelected()) {
        	System.out.println("First box is ticked");
        }
        else {
        	System.out.println("First box is NOT ticked");
        }
 
        //Using two if statement where ! is used for "if not" 
        //if else better where only two states could exist but if you could have 
        //more than two states but just wanted to ensure that a specific state 
        //was not the case you're better with "if not"
        
        if (wd.findElement(By.cssSelector("input[type=\"checkbox\"]")).isSelected()) {
            wd.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
            System.out.println("The first box was selected but I have now clicked it to remove the tick");
        }
        if (!wd.findElement(By.cssSelector("input[type=\"checkbox\"]")).isSelected()) {
            wd.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
            System.out.println("The first box was NOT selected but I have now ticked it");
        }
        
        //CHECKBOX2
        //repeat the above tests on the second tickbox
        
        if (wd.findElement(By.xpath("//div[@class='example']/form/input[2]")).isSelected()) {
        	System.out.println("Second box is ticked");
            wd.findElement(By.xpath("//div[@class='example']/form/input[2]")).click();
            System.out.println("The second box was selected but I have now clicked it to remove the tick");
                 
        }
        else {
        	System.out.println("Second box is NOT ticked");
        	wd.findElement(By.xpath("//div[@class='example']/form/input[2]")).click();
            System.out.println("The second box was NOT selected but I have now ticked it");
        }
    }
}

