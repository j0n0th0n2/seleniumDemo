package com.jsv.sal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver implements Context {

    WebDriver driver;

    public Driver() {
        System.setProperty("webdriver.chrome.driver",".\\src\\main\\resources\\selenium\\chrome-driver-win-77\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public Element findElement(By by) {
        return new Element(this, by, driver.findElement(by));
    }

    public void refresh() {
        //no-op
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void close() {
        this.driver.close();
    }

    public void quit() {
        this.driver.quit();
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public void navigateTo(String uri) {
        this.driver.get(uri);
    }
}
