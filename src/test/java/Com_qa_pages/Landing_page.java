package Com_qa_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_components.abtsract_components;

public class Landing_page extends abtsract_components {
	
	public WebDriver driver;
	
	public Landing_page(WebDriver driver) {
		super(driver);
		
	
		
		this.driver = driver;
	
		PageFactory.initElements(driver, this);
	}
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	
	@FindBy(id = "userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	public product_pages getlogin(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbtn.click();
	 product_pages page = new product_pages(driver);
	 return page;
		
	}
	
	@FindBy(id="login")
	WebElement loginbtn;
	public WebElement getloginbtn() {
		return loginbtn;
	}
	
	@FindBy(xpath ="//div[contains(text(),'Incorrect email or password.')]")
	WebElement errormessage;
	
	By error = By.xpath("//div[contains(text(),'Incorrect email or password.')]");
	
	public String errormessage() {
		//waitelementtoAppear(error);
		return errormessage.getText();
		
		
	}
	
	
	
	

}
