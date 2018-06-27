package com.launchbrowser.test;

import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class LaunchAndType {
	WebDriver driver;

	@Test
	public void LaunchBrowser(){
		//driver= new InternetExplorerDriver();
	
		driver= new ChromeDriver();
		System.out.println("Chrome Browser Launched");
		driver.manage().window().maximize();
		System.out.println(driver.manage().getCookies());
		System.out.println("Cookies get");
		//driver.manage().deleteAllCookies();
		//System.out.println("Cookies deleted");
		driver.get("https://www.gmail.com");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("//test");
		
		driver.getTitle();
		
		
		//31906.33
		//14000
		//21000
		//10000
		
	}
	@AfterMethod
	public void Aftertest()throws EmailException{
		
		System.out.println("Test STarted for email");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		//email.setSSLOnConnect(true);
		email.setFrom("akabhi87@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("snghabhishek89@gmail.com");
 		email.send();
	}
}
