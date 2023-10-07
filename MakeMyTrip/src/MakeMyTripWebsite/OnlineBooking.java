package MakeMyTripWebsite;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass2.BaseTest;

public class OnlineBooking extends BaseTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		openbrowser();
		navigate("AppURL");
		maximize();
		timeout(1);

//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("notification-frame-~10cb41b19"));
//		// driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")));
//		driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
//		Thread.sleep(2000);

		// close the mobile number pop-up to get app link
		// driver.findElement(By.xpath("//[@id='root']/div/div[3]/div/div[2]/div/span")).click();

		// add mobile number to get app link
		// wait(1);
		// driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[2]/div[1]/input")).sendKeys("8196004808");
		// wait(1);
		// driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[2]/div/button")).click();
		wait(1);
		driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div[2]/div[1]/span")).click();

		// You need to add the booking the for one-day trip
		wait(1);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]/label")).click();
		wait(1);
        List<WebElement> OneDayTrip = driver.findElements(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
			for (int i = 0; i < OneDayTrip.size(); i++) {
			wait(2);
			//System.out.println(OneDayTrip);
			//OneDayTrip.get(i).click();
			OneDayTrip.get(i).sendKeys("Chandigarh");
            wait(1);
			driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']/div")).click();
		}

			int elementcounts = OneDayTrip.size();
		System.out.println("There are number of the cities:" + elementcounts);

	}
}
