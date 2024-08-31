package Com_qa_pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_components.abtsract_components;

public class Cart_pages  extends abtsract_components{
  
	
	public WebDriver driver;
	public Cart_pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> cartelements;
	
	
	public boolean verifyporductmatch(String productname) {
		Boolean match = cartelements.stream().anyMatch(card->(productname.contains(card.getText())));
		return match;
		
	}
	
	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutbtn;
	
	public Checkout_pages gotocheckoutbtn() {
		checkoutbtn.click();
		Checkout_pages check  = new Checkout_pages(driver);
		return check;
	}
	

}
