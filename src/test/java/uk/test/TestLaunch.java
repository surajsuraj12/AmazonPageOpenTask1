package uk.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestLaunch {
    @Test
    public void amazonLaunch() throws InterruptedException {
        ChromeDriver cd = new ChromeDriver();
        cd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        cd.get("https://www.amazon.in/");
        cd.findElement(By.id("twotabsearchtextbox")).sendKeys("chelsea black");
        cd.findElement(By.id("nav-search-submit-button")).click();

        cd.get("https://www.amazon.in/Afrojack-Chelsea-Black-Ankle-Boots/dp/B09ZPK6T5Z/ref=sr_1_1_sspa?crid=3EPKGYYUEZI9Z&keywords=chelsea+black&qid=1680493057&sprefix=%2Caps%2C203&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
        cd.findElement(By.id("add-to-cart-button")).click();

        cd.findElement(By.xpath("//div[@id='nav-cart-text-container']")).click();


        //test
        Assert.assertTrue(cd.getTitle().equals("Amazon.in Shopping Cart"));
        Thread.sleep(5000);
        cd.quit();
    }
}
