package runner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import functionality.Nobrokermain;
import reusable.Webdriverhelper;
import utility.Chromedriver;
import utility.ExcelData;
import utility.Logs;

public class Runer {

	Logs log;
	Chromedriver chrome;
	WebDriver driver;
	ExcelData data;
	Webdriverhelper helper;
	Nobrokermain main;
	ExtentHtmlReporter extent;
	ExtentReports report;
	ExtentTest test;
	SimpleDateFormat formatter;
	Date date;

	@BeforeTest
	public void intialization() throws IOException {
		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		date = new Date();
		String name = "" + date;
		 String name1 = name.substring(11, 13) + "_" + name.substring(14, 16) + "_" + name.substring(17, 19) + "_"
				+ name.substring(4, 7) + name.substring(8, 10) + "report.html";
		extent = new ExtentHtmlReporter("D:\\MIndtreeassign\\NoBrokerHybrid\\reports\\" + name1);
		chrome = new Chromedriver();
		data = new ExcelData();
		main = new Nobrokermain();
		data.getlogindata();
		log = new Logs();
		log.createLogger(Runer.class);
		report = new ExtentReports();
		report.attachReporter(extent);
		main.logger();

	}

	@BeforeMethod
	public void openurl() throws IOException {
		
	   log.enterInfoLog("loading the driver ");
	   log.enterInfoLog("hitting the url");
		driver =chrome.loadDriver();
		helper = new Webdriverhelper(driver);
		

	}

	@Test(priority = 1)
	public void validCredentials() throws IOException, InterruptedException {
		
	    // writing test
		test = report.createTest("validcredentials");
		 main.validLogin(helper, data);
		 report.flush();

	}

	@Test(priority = 2)
	public void InvalidCredentials() throws IOException, InterruptedException {

		// System.out.println(name+" "+name.length()+" "+);
		test = report.createTest("Invalidcredentials");
        main.InvalidLogin(helper, data);
		
	}

	@Test(priority = 3)
	public void HyderabadflatsBuy() throws IOException, InterruptedException {
		test = report.createTest("Hyderabadflatssearch");
	  main.Hydearbadflats(helper, data);
		
	}
	@Test(priority=4)
	public void BangloreflatsBuy() throws IOException, InterruptedException {
		test = report.createTest("Bangloreflatssearch");
	    main.Bangloreflats(helper, data);
		
	}
	@Test(priority = 5)
	public void chennaiflatsRent() throws IOException, InterruptedException {
		test = report.createTest("Chennaiflatssearch");
	    main.chennairentflats(helper, data);
		
	}
	@Test(priority = 6)
	public void rental() throws IOException, InterruptedException
	{
		test = report.createTest("renatl agreement");
		main.rental(helper);
		
	}
	
	@Test(priority = 7)
	public void paintingandcleaning() throws IOException, InterruptedException
	{
		test = report.createTest("painting and cleaing details");
		main.painters(helper);
	}
	
	@Test(priority = 8)
	public void refer() throws IOException, InterruptedException
	{
		test = report.createTest("refer and earn");
		main.refer(helper);
	}

	@Test(priority = 9)
	public void ownerplans() throws IOException, InterruptedException
	{
		test = report.createTest("owner plans");
		main.Ownerplans(helper);
	}
	@Test(priority = 10)
	public void Buyerplans() throws IOException, InterruptedException
	{
		test = report.createTest("Buyer plans");
		main.Buyerplans(helper);
	}
	@AfterMethod
	public void closedriver() throws InterruptedException
	{
	
	   driver.close();	
	}
	@AfterTest
	public void flush()
	
	{
		report.flush();
	}

}
