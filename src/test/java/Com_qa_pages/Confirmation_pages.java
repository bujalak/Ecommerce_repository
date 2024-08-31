package Com_qa_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_components.abtsract_components;

public class Confirmation_pages extends abtsract_components{

	public Confirmation_pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
  @FindBy(tagName = "h1")
  WebElement confirmmsg;
  
  public String get_confirm() {
	  return confirmmsg.getText();
  }

}
