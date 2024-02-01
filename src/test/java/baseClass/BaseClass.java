package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static protected WebDriver driver;
	protected Logger logger;
	protected Properties prop;
	FileInputStream fs;
	String path;

	@BeforeClass(groups = { "regression", "sanity", "master" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws IOException {

		// Load properties file

		path = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		fs = new FileInputStream(path);
		prop = new Properties();
		prop.load(fs);

		// log4j

		logger = LogManager.getLogger(this.getClass());

		// Selenium Grid set-up

		/*
		 * if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
		 * 
		 * DesiredCapabilities cap = new DesiredCapabilities();
		 * 
		 * // os set-up
		 * 
		 * if (os.equalsIgnoreCase("Windows")) {
		 * 
		 * cap.setPlatform(Platform.WIN10); }
		 * 
		 * else if (os.equalsIgnoreCase("Mac")) {
		 * 
		 * cap.setPlatform(Platform.MAC); }
		 * 
		 * else { System.out.println("No matching os..!!"); return; }
		 * 
		 * // browser set-up
		 * 
		 * switch (br.toLowerCase()) {
		 * 
		 * case "chrome": cap.setBrowserName("chrome"); break; case "edge":
		 * cap.setBrowserName("MicrosoftEdge"); break;
		 * 
		 * default: System.out.println("No matching browser..!!"); return;
		 * 
		 * }
		 * 
		 * driver = new RemoteWebDriver(new URL(" http://localhost:4444/wd/hub"), cap);
		 * }
		 */

		// launching browser based on condition

		String browserName = System.getenv("browser") != null ? System.getenv("browser") : br;
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

	}

	public String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);

		return generatedString;
	}

	public String randomNumber() {

		String randomNum = RandomStringUtils.randomNumeric(10);

		return randomNum;
	}

	public String randomAlphaNumeric() {

		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);

		return (str + "@" + num);

	}

	public String captureScreenShot(String testName) throws IOException {

		String timeStamp = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp
				+ ".png";
		File targetFile = new File(targetFilePath);

		FileUtils.copyFile(sourceFile, targetFile);
		return targetFilePath;

	}

	@AfterClass(groups = { "regression", "sanity", "master" })
	public void tearDown() {

		driver.close();
	}

}
