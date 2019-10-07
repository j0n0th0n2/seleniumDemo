package com.jsv.sal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Context {

    /**
     * find a child element from this object
     * @param by By object for finding the element
     * @return the Element found by the By.
     */
    public Element findElement(By by);

    public void refresh();

}
