package BaseClass2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseTest {

	public static WebDriver driver;
	
	public static String getPropValue(String PName) throws IOException{
		Properties Prop=new Properties();
		String dir=System.getProperty("user.dir");
		FileInputStream pi= new FileInputStream(dir+"\\src\\Filehandling\\Config.Properties");
		Prop.load(pi);
		String PValue=Prop.getProperty(PName);
		return PValue;
		}

	public static String getObjValue(String PName) throws IOException{
		Properties Prop=new Properties();
		String dir=System.getProperty("user.dir");
		FileInputStream pi=new FileInputStream(dir+"\\src\\Filehandling\\Obj_path_login.properties");
	    Prop.load(pi);
	    String PValue=Prop.getProperty(PName);
		return PValue;
	}
	
    public static void openbrowser() throws IOException{
    	String BrowserName=getPropValue("BrowserName");
    	if (BrowserName.equals("Chrome")){
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gaman\\Desktop\\Opustime\\Selenium\\chromedriver.exe");	
    	driver =new ChromeDriver();
    	}
    	else if (BrowserName.equals("Firefox")){
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");	
    	driver=new FirefoxDriver();
    	}
    }     
    public static void openBrowser() throws IOException{
	System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
	ChromeOptions chromeOptions = new ChromeOptions();
    //chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
    //chromeOptions.addArguments("--headless");
    //chromeOptions.addArguments("--disable-gpu");
    //chromeOptions.addArguments("--window-size=1366,768");
    //chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.62 Safari/537.36");
    //chromeOptions.addArguments("--user-data-dir=C:\\Users\\softuvo\\Desktop\\profile images\\chromeprofile");
    
    chromeOptions.addArguments("--incognito"); 
    chromeOptions.addArguments("enable-automation"); 
    //chromeOptions.addArguments("--headless");
    chromeOptions.addArguments("--no-sandbox");
    chromeOptions.addArguments("--window-size=1920,1080");
    chromeOptions.addArguments("--disable-gpu"); 
    chromeOptions.addArguments("--disable-extensions");
    chromeOptions.addArguments("--dns-prefetch-disable");
    //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);  
    //WebDriver driver = new ChromeDriver(chromeOptions);
    }
    
	public static void openBrowser1(){
    	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	driver = new ChromeDriver(options);
    }
    
    public static void openBrowser2(){
    	System.setProperty("webdriver.gecko.driver", "D:\\Geckodriver.exe");
    	driver=new FirefoxDriver();
    }
    public static void navigate(String URL) throws IOException{
    	String x=getPropValue(URL);
    	driver.get(x);
    }

    public static void maximize(){
    	driver.manage().window().maximize();
    }
   
    public static void type(String locatorName, String value) throws IOException{
	    String LocatorName= getObjValue(locatorName);
	    driver.findElement(By.xpath(LocatorName)).sendKeys(value);
    }
    public static void click(String locatorName) throws IOException{
    	String LocatorName=getObjValue(locatorName);
    	driver.findElement(By.xpath(LocatorName)).click();
    }
   
    public static void click2(String locatorName) throws IOException{
    	String LocatorName=getObjValue(locatorName);
    	driver.findElement(By.cssSelector(LocatorName)).click();;
    }
        
    public static void multiClick(String locatorName) throws IOException, InterruptedException{
    	String LocatorName=getObjValue(locatorName);
    	for (int i=0;i<2;i++){
    	Thread.sleep(600);
    	driver.findElement(By.xpath(LocatorName)).click();
    	}
    }
    
    public static void ViewlogmultiClick(String locatorName) throws IOException, InterruptedException{
    	String LocatorName=getObjValue(locatorName);
    	for (int i=0;i<2;i++){
    	driver.findElement(By.xpath(LocatorName)).click();
    	Thread.sleep(2000);
    	}
    }
    
    public static void multiClick2(String locatorName) throws IOException, InterruptedException{
    	String LocatorName=getObjValue(locatorName);
    	for (int i=0;i<4;i++){
    	Thread.sleep(600);
    	driver.findElement(By.xpath(LocatorName)).click();
    	}
    }
    public static void multiClick3(String locatorName) throws IOException, InterruptedException{
    	String LocatorName=getObjValue(locatorName);
    	for (int i=0;i<16;i++){
    	Thread.sleep(600);
    	driver.findElement(By.xpath(LocatorName)).click();
    	}
    }
    public static void multiClick4(String locatorName) throws IOException, InterruptedException{
       	String LocatorName=getObjValue(locatorName);
       	for (int i=0;i<7;i++){
       	Thread.sleep(600);
       	driver.findElement(By.xpath(LocatorName)).click();
       }
    }
    public static void wait(int i) throws InterruptedException{
    	Thread.sleep(i*1000);
    }
    
    public static void timeout(int i){
    	driver.manage().timeouts().implicitlyWait(i, TimeUnit.MINUTES);
    }
    
    public static void timeoutpageload(int i){
    driver.manage().timeouts().pageLoadTimeout(i, TimeUnit.SECONDS);
    }
    
    public static void deletecookies(){
        driver.manage().deleteAllCookies();
    }    
    public static void timeoutSec(int i){
    	driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }
    public static void refresh(){
    	driver.navigate().refresh();
    }
    public static void clear(String locatorName) throws IOException{
    	String LocatorName=getObjValue(locatorName);
    	driver.findElement(By.xpath(LocatorName)).clear();
    }
    public static void robot_mousemove() throws AWTException{
    	Robot robot=new Robot();
    	robot.mouseMove(1216, 174);
    	robot.delay(1000);
    	robot.mousePress(InputEvent.BUTTON1_MASK);
    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
    	robot.delay(1000);
    }
    
    public static void TextVerify(String locatorName) throws IOException{
    String LocatorName=getObjValue(locatorName);	
    WebElement element=driver.findElement(By.xpath(LocatorName));
    String text=element.getText();
    System.out.println("TEXT IS OBTAINED:-" +" " +text);
    }

    public static void hoverlistElements(String locatorName) throws IOException, InterruptedException{
    	String LocatorName=getObjValue(locatorName);
    	WebElement elements=driver.findElement(By.xpath(LocatorName));
    	Actions act=new Actions(driver);
    	act.moveToElement(elements).build().perform();
    	Thread.sleep(600);
    }
    
    public static void selectElement() throws IOException{
      	Select Dropdown = new Select(driver.findElement(By.id("ng-view")));
    	Dropdown.selectByVisibleText("Alcatel Lucent");
    }
    
    public static void listElementclicks(String locatorName) throws InterruptedException, IOException{
    	String Locator=getObjValue(locatorName);
    	List<WebElement> schedule=driver.findElements(By.xpath(Locator));
    	for (int i=3;i<schedule.size();i++){
    	  Thread.sleep(1000);
    	  System.out.println(schedule);
    	  schedule.get(i).click();
    }
  }  
    public static void listElements(String locatorName) throws InterruptedException, IOException{
    	String Locator=getObjValue(locatorName);
    	List<WebElement> schedule=driver.findElements(By.xpath(Locator));
    	for (int i=0;i<2;i++){
    	Thread.sleep(1000);
    	System.out.println(schedule);
    	schedule.get(i).click();
    }
  }  
    public static void listElements3(String locatorName) throws InterruptedException, IOException{
    	String Locator=getObjValue(locatorName);
    	List<WebElement> schedule=driver.findElements(By.xpath(Locator));
    	for (int i=0;i<3;i++){
    	  Thread.sleep(1000);
    	  System.out.println(schedule);
    	  schedule.get(i).click();
    }
  }
    public static void listElements4(String locatorName) throws InterruptedException, IOException{
    	String Locator=getObjValue(locatorName);
    	List<WebElement> schedule=driver.findElements(By.xpath(Locator));
    	for (int i=1;i<3;i++){
    	  Thread.sleep(1000);
    	  System.out.println(schedule);
    	  schedule.get(i).click();
    }
  }
    public static void listElementclickss(String locatorName) throws InterruptedException, IOException{
    	String Locator=getObjValue(locatorName);
    	List<WebElement> schedule=driver.findElements(By.xpath(Locator));
    	for (int i=4;i<schedule.size();i++){
    	  Thread.sleep(1000);
    	  System.out.println(schedule);
    	  schedule.get(i).click();
       }
  } 
    public static void listElementclick(String locatorName) throws IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   List<WebElement> elements=driver.findElements(By.xpath(LocatorName));
	   for (int i=0;i<elements.size();i++){
		  elements.get(i).click();
		  Thread.sleep(700);
	  }
   }
    
   public static void listElementbreak(String locatorName) throws IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   List<WebElement> elements=driver.findElements(By.xpath(LocatorName));
	   for (int i=0;i<elements.size();){
		   elements.get(i).click();
		   Thread.sleep(900);
		   break;
	  }
   }
   public static void listElementbreak1(String locatorName) throws IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   List<WebElement> elements=driver.findElements(By.xpath(LocatorName));
	   for (int i=1;i<elements.size();){
		   elements.get(i).click();
		   Thread.sleep(900);
		   break;
	 }
   }
   
   public static void listElementbreak2(String locatorName) throws IOException, InterruptedException{
		   String LocatorName=getObjValue(locatorName);
		   List<WebElement> elements=driver.findElements(By.xpath(LocatorName));
		   for (int i=2;i<elements.size();){
			   elements.get(i).click();
			   Thread.sleep(900);
			   break;
		   }
   }
   
   public static void listElementlimit(String locatorName) throws IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   List<WebElement> elements=driver.findElements(By.xpath(LocatorName));
	   for (int i=3;i<elements.size();i++){
		   elements.get(i).click();
		   Thread.sleep(700);
	   }
   }
   
   public static void countLists(String locatorName) throws IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   List<WebElement> elements=driver.findElements(By.xpath(LocatorName));
       int elementCount=elements.size();
       System.out.println("The count is:"+elementCount);
       Thread.sleep(1000);
   }
  
   public static void scrollDown() throws AWTException, IOException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<4;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   }
}	
   public static void scrollDown1() throws AWTException, IOException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<12;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   }
}
  
   public static void scrollDown2() throws AWTException, IOException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<30;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   }
}
   
   public static void scrollDownless() throws AWTException, IOException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<1;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   }
}
   public static void scrollDown(String locatorName) throws AWTException, IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<7;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
	   }
   }
   public static void scrollDownPage(String locatorName) throws AWTException, IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<1;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
	   }
   }
   public static void scrollDown1(String locatorName) throws AWTException, IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<5;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   }
} 
   public static void spaceBar() throws InterruptedException, AWTException{
	   Robot robot= new Robot();
	   Thread.sleep(500);
       robot.keyPress(KeyEvent.VK_SPACE);
   }
   
   public static void scrollDownFileNotes(String locatorName) throws AWTException, IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<12;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(500);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   }
}
    public static void scrollup(String locatorName) throws IOException, AWTException, InterruptedException{
 	   String LocatorName=getObjValue(locatorName);
 	   Robot robot=new Robot();
 	   driver.findElement(By.xpath(LocatorName)).click();
 	   Thread.sleep(600);
 	   for (int i=0;i<1;i++){
 	   robot.keyPress(KeyEvent.VK_UP);
 	   robot.delay(400);
 	   robot.keyRelease(KeyEvent.VK_UP);       
    }
 }    public static void communicationScrollDown(String locatorName) throws AWTException, IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<25;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(500);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   }
}
   public static void PDFScrollDown() throws AWTException, IOException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<125;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
   } 
}  
   public static void scrollDown2(String locatorName) throws AWTException, IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<15;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
	   Thread.sleep(800); 
   }
}
   public static void scrollDown3(String locatorName) throws AWTException, IOException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<35;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);
	   Thread.sleep(800); 
   }
}
   public static void scrollupFileNotes(String locatorName) throws IOException, AWTException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<12;i++){
	   robot.keyPress(KeyEvent.VK_UP);
	   robot.delay(700);
	   robot.keyRelease(KeyEvent.VK_UP);       
   }
}
   public static void scrollupFileNotes1(String locatorName) throws IOException, AWTException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<8;i++){
	   robot.keyPress(KeyEvent.VK_UP);
	   robot.delay(700);
	   robot.keyRelease(KeyEvent.VK_UP);       
   }
}
   
   public static void scrollup1(String locatorName) throws IOException, AWTException, InterruptedException{
	   String LocatorName=getObjValue(locatorName);
	   Robot robot=new Robot();
	   driver.findElement(By.xpath(LocatorName)).click();
	   Thread.sleep(600);
	   for (int i=0;i<12;i++){
	   robot.keyPress(KeyEvent.VK_UP);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_UP);       
   }
}
   public static void scrollup() throws IOException, AWTException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<7;i++){
	   robot.keyPress(KeyEvent.VK_UP);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_UP);       
   }
}
   public static void scrollup1() throws IOException, AWTException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<7;i++){
	   robot.keyPress(KeyEvent.VK_UP);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_UP);       
   }
}
   public static void scrolldown() throws IOException, AWTException, InterruptedException{
	   Robot robot=new Robot();
	   Thread.sleep(600);
	   for (int i=0;i<8;i++){
	   robot.keyPress(KeyEvent.VK_DOWN);
	   robot.delay(400);
	   robot.keyRelease(KeyEvent.VK_DOWN);       
   }
}   

   public static void scrollupBymouse() throws IOException, AWTException, InterruptedException{
	   
	   Thread.sleep(700);
	   Robot robot1=new Robot();
	   robot1.mouseWheel(-10);      
   }
 
    
   public static void backspaceButton(String locatorName) throws IOException, InterruptedException, AWTException{
	   String LocatorName=getObjValue(locatorName);
	   driver.findElement(By.xpath(LocatorName));
	   Thread.sleep(600);
	   Robot robot=new Robot();
	   for (int i=0;i<13;i++){
	   robot.keyPress(KeyEvent.VK_BACK_SPACE);
	   robot.delay(100);
	   robot.keyRelease(KeyEvent.VK_BACK_SPACE);
   } 
}

   public static void mousemove(int x,int y) throws InterruptedException, AWTException{
	   Thread.sleep(2000);
	   Robot robot=new Robot();
	   //robot.mouseMove(216,474);
      robot.mouseMove(x,y);
   } 
   
   public static void mousemove() throws InterruptedException, AWTException{
	   Thread.sleep(2000);
	   Robot robot=new Robot();
	   robot.mouseMove(216,474);
   }     
   
   public static void scrollbymouse() throws InterruptedException, AWTException{
	   Thread.sleep(700);
	   Robot robot1=new Robot();
	   robot1.mouseWheel(7);
  }
//   public static void clickbymouse() throws InterruptedException, AWTException{
//	   Thread.sleep(700);
//	   Robot robot1=new Robot();
//	   robot1.m
//  }
   
   public static void scrollbymouse(int i) throws InterruptedException, AWTException{
	   Thread.sleep(700);
	   Robot robot1=new Robot();
	   robot1.mouseWheel(i);
  }
   
   public static void scrollbymouse(String locator) throws IOException, InterruptedException, AWTException{
	   String Locator=getObjValue(locator);
	   Thread.sleep(700);
	   driver.findElement(By.xpath(Locator));
	   Robot robot1=new Robot();
	   robot1.mouseWheel(5);
  }
   public static void scrollbymouseup(String locator) throws IOException, InterruptedException, AWTException{
	   String Locator=getObjValue(locator);
	   Thread.sleep(700);
	   driver.findElement(By.xpath(Locator));
	   Robot robot1=new Robot();
	   robot1.mouseWheel(-5);
  }   
   public static void scrollbymouse1(String locator, int x) throws IOException, InterruptedException, AWTException{
	   String Locator=getObjValue(locator);
	   Thread.sleep(700);
	   driver.findElement(By.xpath(Locator));
	   Robot robot1=new Robot();
	   Thread.sleep(700); 
	   robot1.mouseWheel(x);
	   Thread.sleep(700); 
   }
   public static void scrollbymouse2(String locator, int x) throws IOException, InterruptedException, AWTException{
	   String Locator=getObjValue(locator);
	   Thread.sleep(700);
	   driver.findElement(By.xpath(Locator)).click();
	   Robot robot1=new Robot();
	   Thread.sleep(700); 
	   robot1.mouseWheel(x);
	   Thread.sleep(700); 
   }
   public static void scrollbymouse2(String locator) throws IOException, InterruptedException, AWTException{
	   String Locator=getObjValue(locator);
	   Thread.sleep(700);
	   driver.findElement(By.xpath(Locator)).click();
	   Robot robot1=new Robot();
	   robot1.mouseWheel(10);
   }
   
   public static void longmousemove() throws InterruptedException, AWTException{
	   Thread.sleep(2000);
 	   Robot robot=new Robot();
	   robot.mouseMove(1216,174);
	   robot.delay(1000);
	   robot.mousePress(InputEvent.BUTTON1_MASK);
	   robot.mouseRelease(InputEvent.BUTTON1_MASK);
	   robot.delay(1000);
  }

   public static void clicklimitedcheckbox(String locator) throws IOException, InterruptedException{
	   String Locator=getObjValue(locator);
	   List<WebElement> clickcheckbox=driver.findElements(By.xpath(Locator));
	   for (int i=4;i<clickcheckbox.size();i++){
		clickcheckbox.get(i).click();
		Thread.sleep(2000);
   }
  }
   
   public static void uploadprofileimage(String locator) throws InterruptedException, AWTException, IOException{
	   String Locator=getObjValue(locator);
	   Thread.sleep(500); 	 
       driver.findElement(By.xpath(Locator)).click();
       Thread.sleep(1500);
 		
       StringSelection ss = new StringSelection("C:\\Users\\softuvo\\Desktop\\profile images\\image2.jpg");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
       Robot robot1=new Robot();
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
       robot1.delay(2000);
       robot1.keyPress(KeyEvent.VK_CONTROL);
       robot1.keyPress(KeyEvent.VK_V);
       robot1.keyRelease(KeyEvent.VK_CONTROL);
       robot1.keyRelease(KeyEvent.VK_V);
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
   }
   public static void uploadprofimage(String locator) throws InterruptedException, AWTException, IOException{
	   String Locator=getObjValue(locator);
	   Thread.sleep(500); 	 
       driver.findElement(By.xpath(Locator)).click();
       Thread.sleep(1500);
 		
       StringSelection ss = new StringSelection("C:\\Users\\softuvo\\Desktop\\profile images\\image4.jpg");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
       Robot robot1=new Robot();
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
       robot1.delay(2000);
       robot1.keyPress(KeyEvent.VK_CONTROL);
       robot1.keyPress(KeyEvent.VK_V);
       robot1.keyRelease(KeyEvent.VK_CONTROL);
       robot1.keyRelease(KeyEvent.VK_V);
       robot1.keyPress(KeyEvent.VK_ENTER);
       robot1.keyRelease(KeyEvent.VK_ENTER);
   } 
   
   public static void enter() throws AWTException{
	   Robot robot=new Robot();
	   robot.keyPress(KeyEvent.VK_ENTER);
	   robot.keyRelease(KeyEvent.VK_ENTER);
   }
   
    //take screenshot with declaring the string
   public static void takeScreenshot2(String imagePath) throws IOException{
   	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	FileUtils.copyFile(scrFile, new File(imagePath));
   	}
   
   public static void uploadprofileimage2(String name) throws AWTException{
    	 StringSelection ss = new StringSelection(name);
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
         Robot robot1=new Robot();
         robot1.keyPress(KeyEvent.VK_ENTER);
         robot1.keyRelease(KeyEvent.VK_ENTER);
         robot1.delay(2000);
         robot1.keyPress(KeyEvent.VK_CONTROL);
         robot1.keyPress(KeyEvent.VK_V);
         robot1.keyRelease(KeyEvent.VK_CONTROL);
         robot1.keyRelease(KeyEvent.VK_V);
         robot1.keyPress(KeyEvent.VK_ENTER);
         robot1.keyRelease(KeyEvent.VK_ENTER);
    }
    public static void AddFile1(String Name) throws InterruptedException, AWTException{
        Thread.sleep(2000);
	    StringSelection ss = new StringSelection(Name);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //Select the respected file   
        Robot robot1=new Robot();
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        robot1.delay(2000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_V);
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_V);
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        robot1.delay(1000);
	    robot1.keyPress(KeyEvent.VK_D); //type letter b on text field on dialog box
		robot1.keyRelease(KeyEvent.VK_D);
	    robot1.delay(1000);
	    for (int i=0;i<11;i++){
	    robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
	    }
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.delay(1000); 
	    //move mouse cursor on the pop up dialog box
		robot1.mouseMove(221,174);
		robot1.delay(1000);
		robot1.mousePress(InputEvent.BUTTON1_MASK);
		robot1.mouseRelease(InputEvent.BUTTON1_MASK);
		//select all the files
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_A);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyRelease(KeyEvent.VK_A);
		//press enter
		robot1.delay(1000);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
    }
    
    public static void AddFile(String Name) throws InterruptedException, AWTException{
        Thread.sleep(2000);
	    StringSelection ss = new StringSelection(Name);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        //Select the respected file   
        Robot robot1=new Robot();
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        robot1.delay(2000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_V);
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_V);
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        robot1.delay(1000);
	    robot1.keyPress(KeyEvent.VK_D); //type letter b on text field on dialog box
		robot1.keyRelease(KeyEvent.VK_D);
	    robot1.delay(1000);
	    for (int i=0;i<11;i++){
	    robot1.keyPress(KeyEvent.VK_DOWN);
		robot1.keyRelease(KeyEvent.VK_DOWN);
	    }
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		robot1.delay(1000); 
	    //move mouse cursor on the pop up dialog box
		robot1.mouseMove(221,174);
		robot1.delay(1000);
		robot1.mousePress(InputEvent.BUTTON1_MASK);
		robot1.mouseRelease(InputEvent.BUTTON1_MASK);
		
    }
	public static void boldLetter() throws InterruptedException, AWTException{
		Thread.sleep(2000);
	    //Select the respected file   
        Robot robot1=new Robot();
        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        robot1.delay(2000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_A);
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_A);
        robot1.delay(1000);
        robot1.keyPress(KeyEvent.VK_CONTROL);
        robot1.keyPress(KeyEvent.VK_B);
        robot1.keyRelease(KeyEvent.VK_CONTROL);
        robot1.keyRelease(KeyEvent.VK_B);
        robot1.delay(1000);
  	
	}
	       
    //close the same tab of the browser
    public static void winbrowser(){
    	Set<String>windows=driver.getWindowHandles();
    	System.out.println("Number of windows opens="+" "+windows.size());
    	
    	Iterator<String> Itr=windows.iterator();
    	
    	String win1=Itr.next();
    	String win2=Itr.next();
    	
    	driver.switchTo().window(win1);
    	driver.close();
    	driver.switchTo().window(win2);
     }
    
    //don't close any tab of browser  
    public static void winbrowser1() throws InterruptedException{
    	Set<String>windows=driver.getWindowHandles();
    	System.out.println("Number of windows opens="+" "+windows.size());
    	
    	Iterator<String> Itr=windows.iterator();
    	
    	String win1=Itr.next();
    	String win2=Itr.next();
    	
    	driver.switchTo().window(win1);
    	Thread.sleep(2000);
    	driver.switchTo().window(win2);
     }
    
    
    //close the second/next tab of the browser 
    public static void winbrowser2(){
    	Set<String>windows=driver.getWindowHandles();
    	System.out.println("Number of windows opens="+" "+windows.size());
    	
    	Iterator<String> Itr=windows.iterator();
    	
    	String win1=Itr.next();
        String win2=Itr.next();
        
        driver.switchTo().window(win2);
        driver.close();
        driver.switchTo().window(win1);
    }

   public static void backspace(String locatorName) throws IOException, AWTException{
	   String LocatorName=getObjValue(locatorName);
       driver.findElement(By.xpath(LocatorName)).click();
       Robot robot= new Robot();
       for(int i=0;i<10;i++){
       robot.keyPress(KeyEvent.VK_BACK_SPACE);
       robot.delay(200);
       robot.keyRelease(KeyEvent.VK_BACK_SPACE);
       }
   }

   public static void takeScreenshot() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\softuvo\\Desktop\\profile images\\Screenshot1.png"));
		}
	 

    //Attaching only single document from the folder
    public static void AddFile2(String Name) throws InterruptedException, AWTException{
   Thread.sleep(2000);
   StringSelection ss = new StringSelection(Name);
   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   //Select the respected file   
   Robot robot1=new Robot();
   robot1.keyPress(KeyEvent.VK_ENTER);
   robot1.keyRelease(KeyEvent.VK_ENTER);
   robot1.delay(2000);
   robot1.keyPress(KeyEvent.VK_CONTROL);
   robot1.keyPress(KeyEvent.VK_V);
   robot1.keyRelease(KeyEvent.VK_CONTROL);
   robot1.keyRelease(KeyEvent.VK_V);
   robot1.keyPress(KeyEvent.VK_ENTER);
   robot1.keyRelease(KeyEvent.VK_ENTER);
   robot1.delay(5000);
   robot1.keyPress(KeyEvent.VK_C); //type letter b on text field on dialog box
   robot1.keyRelease(KeyEvent.VK_C);
   robot1.delay(5000);
   for (int i=0;i<11;i++){
   robot1.keyPress(KeyEvent.VK_DOWN);
   robot1.keyRelease(KeyEvent.VK_DOWN);
   }
   robot1.keyPress(KeyEvent.VK_ENTER);
   robot1.keyRelease(KeyEvent.VK_ENTER);
   robot1.delay(3000); 
   //move mouse cursor on the pop up dialog box
   robot1.mouseMove(221,174);
   robot1.delay(3000);
   robot1.mousePress(InputEvent.BUTTON1_MASK);
   robot1.mouseRelease(InputEvent.BUTTON1_MASK);
   //select only single file
   robot1.delay(3000);
   /*robot1.keyPress(KeyEvent.VK_DOWN);
   robot1.keyRelease(KeyEvent.VK_DOWN);*/
   robot1.keyPress(KeyEvent.VK_UP);
   robot1.keyRelease(KeyEvent.VK_UP);
   //press enter
   robot1.delay(1000);
   robot1.keyPress(KeyEvent.VK_ENTER);
   robot1.keyRelease(KeyEvent.VK_ENTER);
  }
}


