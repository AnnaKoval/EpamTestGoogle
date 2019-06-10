package com.epam.selenium1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        File file = new File(".\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com");
        System.out.print("Enter ");

        driver.findElement(By.xpath(".//*[@id=\"identifierId\"]"))
                .sendKeys("anykoval1356@gmail.com");
        System.out.print("Input name ");
        driver.findElement(By.xpath(".//*[@id=\"identifierNext\"]")).click();


        WebElement explicitWait = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("password")));

        driver.findElement(By.xpath(".//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("epam1356");
        System.out.print("Input password ");
        driver.findElement(By.xpath(".//*[@id=\"passwordNext\"]")).click();

        driver.findElement(By.xpath(".//*[@id=\"yDmH0d\"]")).click();


        String expectedStr = "Вітаємо, Анна Коваль!";


        WebElement waiting = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/c-wiz/div/div[4]/div/div/header/h1")));
        WebElement Welcome = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/c-wiz/div/div[4]/div/div/header/h1"));
        String strOnPage = Welcome.getText();
        System.out.println("");
        System.out.println("Actual result: " + strOnPage);
        System.out.println("Expected result: " + expectedStr);
        Assert.assertEquals(expectedStr, strOnPage);
        driver.close();


    }
}
