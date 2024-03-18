package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(co);

        String URL = "https://zzzscore.com/1to50/en/";
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(2000);
        for (int i = 1; i <= 50; i++) {
            WebElement element = driver.findElement(By.xpath("//div[.='" + i + "']"));
            element.click();
        }

        Thread.sleep(3000);

        driver.quit();
    }
}