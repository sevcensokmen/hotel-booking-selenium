package com.github.sevcensokmen.eehotelbooking.utils;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    
    //initialize timeouts
    private static WebDriverWait waitDriver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    private SeleniumDriver() {
    	   Properties config = new Properties();
    	   FileInputStream fis = null;
    	   String osName;
    	   String browser;
    	   String gecko_driver_directory="";;
    	   String chrome_driver_directory="";
    	   
 			try {
				fis = new FileInputStream(Constant.CONFIG_PROPERTIES_DIRECTORY);
				config.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			browser = config.getProperty("browser");
 			osName = config.getProperty("OS");
 			
 			if(osName.equals("Windows")) {
				
 				gecko_driver_directory = Constant.GECKO_DRIVER_DIRECTORY_WINDOWS;
				chrome_driver_directory = Constant.CHROME_DRIVER_DIRECTORY_WINDOWS;
				
 			}else if(osName.equals("Mac")) {

 				gecko_driver_directory = Constant.GECKO_DRIVER_DIRECTORY; 
 				chrome_driver_directory = Constant.CHROME_DRIVER_DIRECTORY; 
				
 			}

 			
			if (browser.equals("firefox")) {

				System.setProperty("webdriver.gecko.driver", gecko_driver_directory);
				driver = new FirefoxDriver();
			} else if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver", chrome_driver_directory);
				driver = new ChromeDriver();

			} 
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			waitDriver = new WebDriverWait(driver, 10);
			String window=driver.getWindowHandle();
		    System.out.println("Window ->"+window);
		       

	}


    public static void openPage(String url) {
    	System.out.println(url);
    	System.out.println(driver);
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
       if (seleniumDriver == null)
            seleniumDriver = new SeleniumDriver();
      
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }
    public static void waitForPageToLoad()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
