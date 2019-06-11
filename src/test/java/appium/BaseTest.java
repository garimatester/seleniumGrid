
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
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     *
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {
    log.info("INSIDE BEFORE SUITE---APPIUM CONFIG");
        if (driver == null) {

            // AppiumServerJava.startAppium();
          	//ReadBashScript.readBashScript();
              //String deviceName = "0815f8aacb270504";
            String deviceName = "iPhone SE";

              if (System.getProperty("deviceName") != null) {
            	  log.info("setting device name:");
            	  deviceName = System.getProperty("deviceName");
            	  log.info("setting device name:"+ deviceName);
              }

              String platformVersion = "12.3.1";
              if (System.getProperty("platformVersion") != null) {
                  platformVersion = System.getProperty("platformVersion");
              }

           String appPackage = "";
              //String appPackage = "com.eliasnogueira.workshop";
              if (System.getProperty("appPackage") != null) {
            	  appPackage = System.getProperty("appPackage");
              }

              String appDir = "";


             // String appDir = "src/test/resources/AppAPK";
              if (System.getProperty("appDir") != null) {
            	  appPackage = System.getProperty("appDir");
              }

              String appiumUrl = "http://127.0.0.1:4723/wd/hub";
              if (System.getProperty("appiumUrl") != null) {
            	  appPackage = System.getProperty("appiumUrl");
              }


              //String platformName = "Android";
              String platformName = "iOS";

              String browserName = "Safari";


              if (System.getProperty("platformName") != null) {
            	  appPackage = System.getProperty("platformName");
              }


              /*String appFileName = "pessoas.apk";
              if (System.getProperty("appFileName") != null) {
            	  appPackage = System.getProperty("appFileName");
              }
*/



              log.info("Appium Driver Config");
              log.info("+++++++++++++++++++++++++++++++++++++++++++++");
              log.info("appiumUrl       : " + appiumUrl);
              log.info("appDir          : " + appDir);
              //log.info("app             : " + appFileName);
              log.info("deviceName      : " + deviceName);
              log.info("platformName    : " + platformName);
              log.info("platformVersion : " + platformVersion);
              log.info("appPackage      : " + appPackage);
              log.info("++++++++++++++++++++++++++++++++++++++++++++++");

              /*final File appDirParam = new File(appDir);
              final File app = new File(appDirParam, appFileName);*/

              final DesiredCapabilities capabilities = new DesiredCapabilities();

           // capabilities.setCapability("automationName", "Appium");
             // capabilities.setCapability("deviceName", deviceName);
              capabilities.setCapability("platformName", platformName);
              //capabilities.setCapability("platformVersion", platformVersion);
              capabilities.setCapability("browserName", browserName);

              //capabilities.setCapability("app", app.getAbsolutePath());
              //capabilities.setCapability("appPackage", appPackage);
              //capabilities.setCapability("noReset", "true");
             // capabilities.setCapability("fullReset", "false");

              //for browserstack

              capabilities.setCapability("browserstack.debug", true);
              capabilities.setCapability("device", "iPhone SE");

              capabilities.setCapability("realMobile", true);
              capabilities.setCapability("os_version", "11");
              capabilities.setCapability("build", "01");
              capabilities.setCapability("project", "samplemMulti");
              capabilities.setCapability("acceptSslCerts", true);

              capabilities.setCapability( "browserstack.safari.enablePopups", true);
              capabilities.setCapability( "browserstack.console", "info");


              //selenium android browser through grid

      /*  case "windows-android-chrome":
		case "windows-android_chrome":
		case "mac-android-chrome":
		case "mac-android_chrome":*/
			DesiredCapabilities objCapabilities = null;
			objCapabilities = DesiredCapabilities.chrome();
			//ChromeOptions chromeoptions = new ChromeOptions();
			//chromeoptions.setExperimentalOption("androidPackage", "com.android.chrome");
			//objCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);
			objCapabilities.setCapability("platform", "WINDOWS");
			objCapabilities.setCapability("platformName", "WINDOWS");
			objCapabilities.setCapability("seleniumProtocol", "WebDriver");


			objCapabilities.setCapability("browserName", "chrome");





			objCapabilities.setCapability("version", "android");

			//if(osname.toLowerCase().contains("mac")){
				//ChromeDriverPath = System.getProperty("user.dir") + "/Tool/chromedriver.exe";
			//}else{
				//String ChromeDriverPath = System.getProperty("user.dir") + "/chromedriver"+ "/win32" + File.separator + "chromedriver.exe";

			//}

				//System.out.println("chromedriver reading"+ ChromeDriverPath);

		    	//ChromeOptions chromeOptions = new ChromeOptions();
	            //chromeOptions.setBinary("C:\\Users\\ankit.sharma\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");

	           // objCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			//System.setProperty("webdriver.chrome.driver", ChromeDriverPath);


			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.setExperimentalOption("androidPackage", "com.android.chrome");
			objCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);










              try {
                  log.info("Setting up Appium driver");
                 // driver = new AppiumDriver<MobileElement>(new URL(appiumUrl), capabilities);
                  //driver = new AndroidDriver<MobileElement>(new URL(appiumUrl), capabilities);
      			//System.setProperty("webdriver.chrome.driver", ChromeDriverPath);


                  driver =  new RemoteWebDriver(objCapabilities);

                  //driver =  new RemoteWebDriver(new URL("http://"+ "garimachauhan2" +":"+"5c9pxpGzT3x3puyWbbW4"+"@"+"hub-cloud.browserstack.com" +"/wd/hub"), capabilities);
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