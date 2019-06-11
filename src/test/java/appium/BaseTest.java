
package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */


public abstract class BaseTest  {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
   // public static AppiumDriver<MobileElement> driver;

    public static RemoteWebDriver driver;




     /**
     * A page containing the navigation drawer
     */
    //private NavigationPage navigationPage;

    /**
     * Method to initialize the test's page
     */
    //@BeforeTest
    public abstract void setUpPage();

    /**
     * This method runs before any other method.
        on hub run below commands
     *java -jar selenium-server-standalone-3.141.59.jar -role hub
     *  on node 
     *java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.178.28:4444/grid/register -nodeConfig config.json
     *
     
     
     { "capabilities": [ { "browserName": "chrome", "maxInstances": 5, "platform": "WINDOWS", "webdriver.chrome.driver": "location to chromedriver" ,"version":"android"}]}
     * 
     We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Hub and nodes are setup and running using these commands 
     * .
     *
     * 
     */
    @BeforeSuite
    public void setUp() throws MalformedURLException {
    

             

              final DesiredCapabilities capabilities = new DesiredCapabilities();

         
              
              
              //for browserstack

              //capabilities.setCapability("browserstack.debug", true);
              //capabilities.setCapability("device", "iPhone SE");

              //capabilities.setCapability("realMobile", true);
              //capabilities.setCapability("os_version", "11");
              //capabilities.setCapability("build", "01");
              //capabilities.setCapability("project", "samplemMulti");
             // capabilities.setCapability("acceptSslCerts", true);

             // capabilities.setCapability( "browserstack.safari.enablePopups", true);
            //  capabilities.setCapability( "browserstack.console", "info");


              //selenium android -chrome browser through grid

        case "windows-android-chrome":
		case "windows-android_chrome":
		case "mac-android-chrome":
		case "mac-android_chrome":
			DesiredCapabilities objCapabilities = null;
			objCapabilities = DesiredCapabilities.chrome();
			objCapabilities.setCapability("platform", "WINDOWS");
			objCapabilities.setCapability("platformName", "WINDOWS");
			objCapabilities.setCapability("seleniumProtocol", "WebDriver");
			objCapabilities.setCapability("browserName", "chrome");
			objCapabilities.setCapability("version", "android");
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setExperimentalOption("androidPackage", "com.android.chrome");
			objCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
		 try {
                  log.info("Setting up Chrome driver at Selenium Grid node");
                  driver =  new RemoteWebDriver(objCapabilities);
	           log.info("success");
                  System.out.println("driver"+ driver);
              } catch (Exception e) {
                  e.printStackTrace();
              }



          }

    }

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium() {

        driver.quit();
    }



    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     * commenting for now as running tests in one go
     * have to implement later
     */
  @AfterClass
    public void restartApp() {
       //driver.resetApp();
    }
}
