package com.github.sevcensokmen.eehotelbooking.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.github.sevcensokmen.eehotelbooking.utils.SeleniumDriver;

public class HotelBookingPage {

	private int numberOfBookings;
	private String deletedID;

	public HotelBookingPage() {
		super();
	}

	public void enterFirstName(String firstNameValue) {

		SeleniumDriver.getInstance().getDriver().findElement(By.id("firstname")).sendKeys(firstNameValue);

	}

	public void enterSurname(String lastnameValue) {

		SeleniumDriver.getInstance().getDriver().findElement(By.id("lastname")).sendKeys(lastnameValue);

	}

	public void enterTotalPrice(String totalpriceValue) {

		SeleniumDriver.getInstance().getDriver().findElement(By.id("totalprice")).sendKeys(totalpriceValue);

	}

	public void enterDeposit(String depositValue) {

		Select selectDeposit = new Select(SeleniumDriver.getInstance().getDriver().findElement(By.id("depositpaid")));
		selectDeposit.selectByVisibleText(depositValue);

	}

	public void enterCheckIn(String checkinValue) {

		SeleniumDriver.getInstance().getDriver().findElement(By.id("checkin")).sendKeys(checkinValue);

	}

	public void enterCheckOut(String checkoutValue) {

		SeleniumDriver.getInstance().getDriver().findElement(By.id("checkout")).sendKeys(checkoutValue);

	}

	public void clickSaveBtn() {
		numberOfBookings = bookings().size();
		SeleniumDriver.getInstance().getDriver().findElement(By.xpath("//input[contains(@value,'Save')]")).click();

	}

	public void waitUntilNewBookingPopulates(WebElement bookingTable) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(SeleniumDriver.getInstance().getDriver())
				.withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("foo"));
			}
		});

		new FluentWait<WebElement>(bookingTable).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.MILLISECONDS).until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						return bookings().size() > numberOfBookings;
					}
				});
	}

	private List<WebElement> bookings() {
		return SeleniumDriver.getInstance().getDriver()
				.findElements(By.xpath("//div[@id='bookings']/div[@class='row']"));
	}

	public void deleteCustomer() {
		String lastid;

		List<WebElement> rows = bookings();
		if (rows.size() > 1) {
			lastid = rows.get(rows.size() - 1).getAttribute("id");
			WebElement element2 = SeleniumDriver.getInstance().getDriver()
					.findElement(By.xpath("//div[@id='" + lastid + "']//input[@value='Delete']"));

			element2.click();
			deletedID = lastid;

		}
	}

	public boolean deleteCustomerAssert() {
		String actualID;
		List<WebElement> rows = bookings();
		if (rows.size() > 1) {
			System.out.println(rows.size());
			actualID = rows.get(rows.size() - 1).getAttribute("id");
			if (!actualID.equals(deletedID))
				return true;
		}
		return false;
	}

	public boolean waitUntilNewBookingPopulatesa() {

		WebElement bookingTable = SeleniumDriver.getInstance().getDriver()
				.findElement(By.xpath("//div[@id='bookings']"));

		try {
			new FluentWait<WebElement>(bookingTable).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(10, TimeUnit.MILLISECONDS).until(new Function<WebElement, Boolean>() {
						public Boolean apply(WebElement element) {
							return bookings().size() > numberOfBookings;
						}
					});
			return true;
		} catch (Exception e) {
			System.out.println("WebElement is NOT visible, using locator: ");
			return false;
		}

	}

}
