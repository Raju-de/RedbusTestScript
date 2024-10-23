package Program;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Mainjava {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		try {
            
            driver.get("https://www.redbus.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
          
            WebElement sourceCity = driver.findElement(By.id("src"));
            WebElement destinationCity = driver.findElement(By.id("dest"));
            WebElement travelDate = driver.findElement(By.id("onward_cal"));

            sourceCity.sendKeys("Hyderabad, Telangana, India");
            destinationCity.sendKeys("Bangalore, Karnataka, India");
            travelDate.click();
            Thread.sleep(3000);
            travelDate.sendKeys("26-Oct-2024");
            
            
            WebElement searchButton = driver.findElement(By.id("search_btn"));
            searchButton.click();
            Thread.sleep(5000); 

           
            WebElement timeFilter = driver.findElement(By.xpath("//label[@for='dtAfter6am']"));
            timeFilter.click();
            WebElement boardingPointFilter = driver.findElement(By.xpath("//label[contains(text(),'Some Boarding Point')]"));
            boardingPointFilter.click();
            Thread.sleep(3000); 
            WebElement selectBus = driver.findElement(By.xpath("//button[contains(text(), 'Select Seat')]"));
            selectBus.click();

            WebElement seat = driver.findElement(By.xpath("//div[@class='seat available']"));
            seat.click(); 

            WebElement passengerName = driver.findElement(By.id("passengerName"));
            WebElement passengerAge = driver.findElement(By.id("passengerAge"));
            WebElement passengerGender = driver.findElement(By.id("passengerGender"));

            passengerName.sendKeys("Raju");
            passengerAge.sendKeys("28");
            passengerGender.sendKeys("Male");

            
            WebElement proceedToPaymentButton = driver.findElement(By.xpath("//button[contains(text(), 'Proceed to Pay')]"));
            proceedToPaymentButton.click();
            
            WebElement creditCardOption = driver.findElement(By.xpath("//label[contains(text(), 'Credit Card')]"));
            creditCardOption.click();
            WebElement cardNumber = driver.findElement(By.id("card_number"));
            WebElement expiryDate = driver.findElement(By.id("expiry_date"));
            WebElement cvv = driver.findElement(By.id("cvv"));

            cardNumber.sendKeys("4141 4141 4141 4141");
            expiryDate.sendKeys("09/25");
            cvv.sendKeys("123");
            
            String busType = driver.findElement(By.xpath("//div[contains(@class, 'busType')]")).getText();
            String totalFare = driver.findElement(By.xpath("//span[@class='totalFare']")).getText();
            String seatNumber = driver.findElement(By.xpath("//span[@class='seatNumber']")).getText();

            System.out.println("Bus Type: " + busType);
            System.out.println("Total Fare: " + totalFare);
            System.out.println("Seat Number: " + seatNumber);

            if (busType.equals("Volvo AC") && totalFare.equals("₹1500") && seatNumber.equals("A1")) {
                System.out.println("Booking details validated.");
            } else {
                System.out.println("Booking details validation failed.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            
            driver.quit();
        }
    }
}
