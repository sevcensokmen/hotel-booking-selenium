package com.github.sevcensokmen.eehotelbooking.runners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.github.sevcensokmen.eehotelbooking.utils.Constant;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = { "json:target/positive/cucumber.json", "pretty", "html:target/positive/cucumber.html",
		"com.cucumber.listener.ExtentCucumberFormatter" }, features = "src/test/resources/features", glue = "com/github/sevcensokmen/eehotelbooking/steps", tags = {
				"@hotel-booking" })

public class PositiveTest extends AbstractTestNGCucumberTests {
	@BeforeClass
	public static void setup() {
		// Initiates the extent report and generates the output in the
		// output/Run_<unique timestamp>/report.html file by default.
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String fileName = Constant.EXTENT_REPORT_CONFIG + strDate + ".html";
		File newFile = new File(fileName);
		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, false);
		// static report name
		// ExtentCucumberFormatter.initiateExtentCucumberFormatter(new
		// File("F:\\cucumber-testing-master\\ExtenReports\\extentreports.html"),false);
		// Loads the extent config xml to customize on the report.
		ExtentCucumberFormatter.loadConfig(new File(Constant.EXTENT_REPORT_FILE));

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

		// Also you can add system information using a hash map
		Map<String, String> systemInfo = new HashMap<String, String>();
		systemInfo.put("Cucumber version", "v1.2.3");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}

}
