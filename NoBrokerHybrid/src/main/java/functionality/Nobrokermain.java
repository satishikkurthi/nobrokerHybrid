package functionality;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import reusable.Webdriverhelper;
import uistore.Buyui;
import uistore.Homepage;
import uistore.Loginui;
import uistore.Rentui;
import utility.ExcelData;
import utility.Logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Nobrokermain {

	Logs log = new Logs();

	public void logger() {
		log.createLogger(Nobrokermain.class);
	}

	public void validLogin(Webdriverhelper helper, ExcelData data) throws IOException, InterruptedException {

		log.enterInfoLog("clicking the login button");
		helper.click(Loginui.loginbutton);
		log.enterInfoLog("entering the phone number");
		// System.out.println(data.getcorrectphonenumber());
		helper.sendText(Loginui.phonenumberfield, data.getcorrectphonenumber());
		log.enterInfoLog("clicking on i have password");
		helper.click(Loginui.radiopassword);
		log.enterInfoLog("entering the password");
		System.out.println(data.getcorrectpassword());
		helper.sendText(Loginui.passwordfield, data.getcorrectpassword());
		Thread.sleep(2000);
		log.enterInfoLog("clicking on sigin");
		helper.click(Loginui.sigin);
		//Thread.sleep(4000);
		helper.click(Loginui.symbolsign);
		helper.takeSCreenshot("validlogin");
		//Thread.sleep(2000);
		//helper.click(Loginui.profile);
		
		
	}

	public void InvalidLogin(Webdriverhelper helper, ExcelData data) throws IOException, InterruptedException {
		log.enterInfoLog("clicking the login button");
		helper.click(Loginui.loginbutton);
		log.enterInfoLog("entering the phone number");
		// System.out.println(data.getcorrectphonenumber());
		helper.sendText(Loginui.phonenumberfield, data.getcorrectphonenumber());
		log.enterInfoLog("clicking on i have password");
		helper.click(Loginui.radiopassword);

		// System.out.println(data.getcorrectpassword());
		log.enterInfoLog("entering the wrong password");
		helper.sendText(Loginui.passwordfield, data.getincorrectpassword());
		Thread.sleep(2000);
		log.enterInfoLog("clicking on sigin");
		helper.click(Loginui.sigin);
		Thread.sleep(2000);
		helper.takeSCreenshot("Invalidlogin");
		
	}

	public void Hydearbadflats(Webdriverhelper driver, ExcelData data) throws IOException, InterruptedException {

		log.enterInfoLog("clicking on buy");
		driver.click(Buyui.Buyradio);
		log.enterInfoLog("selecting the location dropdown");
		// System.out.println("location select");
		driver.click(Buyui.locationdropdown);
		// System.out.println("selecting location");
		log.enterInfoLog("selecting the location");
		driver.keydown(5);
		driver.Enterkey();
		log.enterInfoLog("clicking on apartment type dropdown");
		driver.click(Buyui.ApartmentTypedropdown);
		log.enterInfoLog("selecting the apartment types");
		driver.keydown(2);
		driver.Enterkey();
		driver.keydown(1);
		driver.Enterkey();
		log.enterInfoLog("clicking on propertystatus type dropdown");
		driver.click(Buyui.propertStatusdropdown);
		driver.keydown(1);
		driver.Enterkey();
		log.enterInfoLog("clicking on search");
		driver.click(Buyui.SearchBox);
		log.enterInfoLog("sending the  information");
		driver.sendText(Buyui.SearchBox, data.gethydloaction());
		Thread.sleep(1000);
		driver.keydown(1);
		driver.Enterkey();
		Thread.sleep(1000);

		log.enterInfoLog("clicking on search");
		driver.click(Buyui.Searchicon);
		Thread.sleep(1000);
		driver.takeSCreenshot("HyderabadflatsBuy");
		

	}

	public void Bangloreflats(Webdriverhelper driver, ExcelData data) throws IOException, InterruptedException {

		log.enterInfoLog("clicking on buy");
		driver.click(Buyui.Buyradio);
		log.enterInfoLog("selecting the location dropdown");
		// System.out.println("location select");
		driver.click(Buyui.locationdropdown);
		// System.out.println("selecting location");
		log.enterInfoLog("selecting the banglore location");
		driver.keydown(1);
		driver.Enterkey();
		log.enterInfoLog("clicking on apartment type dropdown");
		driver.click(Buyui.ApartmentTypedropdown);
		log.enterInfoLog("selecting the apartment types 2BHk 3BHK");
		driver.keydown(2);
		driver.Enterkey();
		driver.keydown(1);
		driver.Enterkey();
		log.enterInfoLog("clicking on propertystatus type dropdown and selecting under construction");
		driver.click(Buyui.propertStatusdropdown);
		driver.keydown(2);
		driver.Enterkey();
		log.enterInfoLog("clicking on search");
		driver.click(Buyui.SearchBox);
		log.enterInfoLog("sending the information");
		driver.sendText(Buyui.SearchBox, data.getbangloaction());
		Thread.sleep(1000);
		driver.keydown(2);
		driver.Enterkey();
		Thread.sleep(1000);

		log.enterInfoLog("clicking on search");
		driver.click(Buyui.Searchicon);
		Thread.sleep(1000);
		driver.takeSCreenshot("BangloreflatsBuy");
		

	}

	public void chennairentflats(Webdriverhelper driver, ExcelData data) throws IOException, InterruptedException {

		log.enterInfoLog("clicking on Rent");

		driver.click(Rentui.Rentclick);
	log.enterInfoLog("selecting the location dropdown");

		driver.click(Buyui.locationdropdown);
	
	log.enterInfoLog("selecting the chennai location");
		driver.keydown(3);
		driver.Enterkey();
   log.enterInfoLog("clicking on availbility");
		driver.click(Rentui.availability);

		Thread.sleep(2000);
		driver.keydown(2);
		driver.Enterkey();
	log.enterInfoLog("clicking on apartment type dropdown");
		driver.click(Buyui.ApartmentTypedropdown);
	log.enterInfoLog("selecting the apartment types 2BHk 3BHK");
		driver.keydown(2);
		driver.Enterkey();
		driver.keydown(1);
		driver.Enterkey();


	log.enterInfoLog("clicking on search");
	driver.click(Buyui.SearchBox);
	log.enterInfoLog("sending the information pondybazar");
	driver.sendText(Buyui.SearchBox, data.getchennailocation1());
	Thread.sleep(1000);
	driver.keydown(2);
	driver.Enterkey();
    Thread.sleep(1000);
    log.enterInfoLog("sending the information velacherry");
	driver.sendText(Buyui.SearchBox,data.getchennailocation2());
	Thread.sleep(1000);
	driver.keydown(2);
	driver.Enterkey();
	Thread.sleep(1000);
	driver.Enterkey();
	Thread.sleep(1000);
	driver.takeSCreenshot("Chennaiflatsrent");
	
	}
	
	
	public void rental(Webdriverhelper helper) throws IOException, InterruptedException
	{
	   log.enterInfoLog("clicking on rental agreement");
	   helper.click(Homepage.menu);
	   Thread.sleep(1000);
	   helper.click(Homepage.rental);
	   Thread.sleep(1000);
	   helper.click(Homepage.location);
	   Thread.sleep(1000);
		helper.takeSCreenshot("rentalagreement");
		
	   
	   
	}
	public void painters(Webdriverhelper helper) throws IOException, InterruptedException
	{
		
		 log.enterInfoLog("clicking on painting details");
	   //helper.scrolldown();
	   helper.click(Homepage.menu);
	   Thread.sleep(1000);
	   helper.click(Homepage.painters);
	   Thread.sleep(1000);
	   helper.click(Homepage.location);
	   Thread.sleep(1000);
		helper.takeSCreenshot("PaintingsandCleaning");
	   
	}
	public void refer(Webdriverhelper helper) throws IOException, InterruptedException
	{
		 log.enterInfoLog("clicking on referal and earn");
		helper.click(Homepage.menu);
		   Thread.sleep(1000);

		helper.click(Homepage.refer);
		 Thread.sleep(1000);
			helper.takeSCreenshot("Refer and Earn");
		   
	}
	public void Ownerplans(Webdriverhelper helper) throws IOException, InterruptedException
	{
		 log.enterInfoLog("clicking on Owner plans");
		helper.click(Homepage.menu);
		   Thread.sleep(1000);

		helper.click(Homepage.owner);
		 Thread.sleep(1000);
			helper.takeSCreenshot("Ownerplans");
		   
	}
	public void Buyerplans(Webdriverhelper helper) throws IOException, InterruptedException
	{
		 log.enterInfoLog("clicking on Buyer plans");
		helper.click(Homepage.menu);
		   Thread.sleep(1000);

		helper.click(Homepage.Buyer);
		 Thread.sleep(1000);
			helper.takeSCreenshot("Buyerplans");
	}
	

}
