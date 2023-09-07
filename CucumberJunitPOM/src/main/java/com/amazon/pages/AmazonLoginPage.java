package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonLoginPage {
	private final WebDriver driver;
	

	// 1. By Locators
	private final By usernameField = By.id("ap_email");
	private final By passwordField = By.id("ap_password");
	private final By signInContinueButton = By.xpath("//input[@id='continue']");
	private final By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot Password']");
	private final By signInSubmitButton = By.id("signInSubmit");
	private final By errorMessageForInvalid = By.xpath("//span[@class='a-list-item']");
	private final By errorMessageForEmpty = By.xpath("//div[contains(text(),'Enter your email or mobile phone number')]");

	// 2. Constructor of the page class
	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page actions: features(Behaviors) of the page form of the methods
	public void enterUsername(String username) {
		WebElement usernameInput = driver.findElement(usernameField);
		usernameInput.clear();
		usernameInput.sendKeys(username);
	}

	public void clickSignInContinueButton() {
		driver.findElement(signInContinueButton).click();
	}

	public void enterPassword(String password) {
		WebElement passwordInput = driver.findElement(passwordField);
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickSignInSubmitButton() {
		driver.findElement(signInSubmitButton).click();
	}

	public void waitForElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public String getErrorMessageForInvalid() {
		WebElement errorElement = driver.findElement(errorMessageForInvalid);
		return errorElement.getText();
	}

	public String getErrorMessageForEmpty() {
		WebElement errorElement = driver.findElement(errorMessageForEmpty);
		return errorElement.getText();
	}

	public AmazonPasswordRecoveryPage clickForgotPasswordLink(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement fgtPwdLink = wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));
		fgtPwdLink.click();
		//driver.findElement(forgotPasswordLink).click();
		return new AmazonPasswordRecoveryPage(driver);
	}
}
