package dsalgoPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	
	
    private  By massage = (By.xpath("//p[text()='You are at the right place']"));
    private By getstartedbtn =By.linkText("Get Started");
    private By detaStructures =(By.xpath("//div[@class='nav-item dropdown']"));
    private By arrays =(By.xpath("//*[text()='Arrays']"));
    private By linkedList =(By.xpath("//a[text()='Linked List']"));
    private By stack =(By.xpath("//a[text()='Stack']"));
    private By queue =(By.xpath("//a[text()='Queue']"));
    private By tree =(By.xpath("//a[text()='Tree']"));
    private By graph =(By.xpath("//a[text()='Graph']"));
    private By alart =(By.xpath("//div[@role='alert']"));
    private By dropdown =(By.xpath("//*[@class='nav-item dropdown']"));
    private By dataStructuresIntroduction =(By.xpath("//*[text()='Data Structures-Introduction']"));
    private By alartMassage =(By.xpath("//*[@class='alert alert-primary']"));
    private By register =(By.xpath("//*[text()=' Register ']"));
    private By signin =(By.xpath("//*[text()='Sign in']"));
    private By GetStartedbtn =(By.linkText("Get Started"));
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
    public void openDSAlgoPortalURL() {
    	 driver.get("https://dsportalapp.herokuapp.com/");
    }

    public void getmassage(String msg){
    	String actualmassage=driver.findElement(massage).getText();
    	System.out.println(actualmassage);
    }
    
    public void clickgetstartedbtn() {
    	
    	driver.findElement(getstartedbtn).click();
    }

    public void dataStructureIntroductionPageRegisterSigninLinks() {
    	 driver.findElement( dataStructuresIntroduction);


         driver.findElement(register);

        driver.findElement(signin);	 
    }

    public void DataStucturePage() {
    	 driver.findElement(detaStructures);
    	
    }

    public void clickDropdownDataStructure() {
    	 driver.findElement(dropdown).click();

    }

    public void dropdownMenueItem() {
      
    	driver.findElement(arrays);
    	driver.findElement(linkedList);
    	driver.findElement(stack);
    	driver.findElement(queue);
    	driver.findElement(tree);
    	driver.findElement(graph);
    }

    
    public void clickArrays() throws InterruptedException {

    	Thread.sleep(2000);
    	driver.findElement(arrays).click();
    	 
    }

    
    public String warningMessag()
	{
    	String warningmsg=driver.findElement(alart).getText();
    	return(warningmsg);
	}
    
    public void clickGetStartedbtn() throws InterruptedException  {
    Thread.sleep(3000);
    driver.findElement(GetStartedbtn).click();

    }

    
    public String getwarningMessag()
  	{
    	String warningmassage=driver.findElement(alartMassage).getText();
    	return(warningmassage);
  		
  	}
    }

    		
    

	
	
	

	
	

