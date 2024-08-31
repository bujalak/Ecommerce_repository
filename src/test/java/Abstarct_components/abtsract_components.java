package Abstarct_components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com_qa_pages.Cart_pages;
import Com_qa_pages.orders_page;

public class abtsract_components {
	public WebDriver driver;
	public abtsract_components(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@routerlink=\"/dashboard/cart\"]")
	WebElement cartbtn;
	
	@FindBy(xpath = "//ul/li/button[@routerlink=\"/dashboard/myorders\"]")
	WebElement ordersbtn;

	public void waitelementtoAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	public  Cart_pages getcartbtn() {
		cartbtn.click();
		Cart_pages cart = new Cart_pages(driver);
		return cart;
		
		
	}
	
	public orders_page getorders() {
		ordersbtn.click();
		orders_page order = new orders_page(driver);
		return order;
	}
	
	


}
