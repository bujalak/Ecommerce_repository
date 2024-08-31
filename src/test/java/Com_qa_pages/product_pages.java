package Com_qa_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_components.abtsract_components;

public class product_pages extends abtsract_components{
	
	public WebDriver driver;
	public product_pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List<WebElement> prodlist;
	
	By findby = By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"); 
	By addtocart = By.xpath("//button[@class=\"btn w-10 rounded\"]");
	
	public List<WebElement> getproductlist(){
		
		
		waitelementtoAppear(findby);
		return prodlist;
	}
	
	public WebElement getproductbyname(String productname) {
		WebElement proditem = getproductlist().stream().filter(prod2->prod2.findElement(By.xpath("//h5/b")).getText().equals(productname)).findFirst().orElse(null);
	     return proditem;
	}
	
	public void Addtocart(String productname) {
		WebElement proditem2 = getproductbyname(productname);
		proditem2.findElement(addtocart).click();
		
	}
	


}
