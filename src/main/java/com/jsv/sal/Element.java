package com.jsv.sal;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the majority of the interfaces into Selenium.
 * <p>
 * The refresh parent relationship implemented here sets up a tree of
 * objects and lazy loading of Selenium WebElements. This enhances the performance
 * and allows for the definition of Page objects at compile time.
 * <p>
 * This class manages all of the Stale Element Exceptions.
 */
public class Element implements Context, Clickable, HasText, Typeable, Visibility {

    private static final String ERROR_REFRESHING = "Error refreshing %s";
    public static final String ELEMENT_USING_S_FROM_ELEMENT_S = "Element [Using:[%s] from Element: [%s] pointing to [%s]]";

    private final Context parent;
    private final By by;

    private WebElement element;

    /**
     * This is used to statically define object at complie time.
     *
     * @param parent - Search Context to find the element from.
     * @param by     - By object to refined this element
     */
    public Element(Context parent, By by) {
        this.parent = parent;
        this.by = by;
    }

    /**
     * This constructor is used to dynamically define objects by the fineElement method.
     *
     * @param parent     - Search Context to find the element from.
     * @param by         - By object to refined this element
     * @param webElement - the backing Selenium Object
     */
    protected  Element(Context parent, By by, WebElement webElement) {
        this.parent = parent;
        this.by = by;
        this.element = webElement;
    }

    //basic to string
    public String toString() {
        return String.format(ELEMENT_USING_S_FROM_ELEMENT_S, this.parent, this.by, this.element);
    }

    //Basic getter
    protected WebElement getWebElement() {
        if (this.element == null) {
            this.refresh();
        }
        return this.element;
    }

    /*
     * @see Context#refresh()
     */
    public void refresh() {
        if (parent != null) {
            try {
                this.element = this.parent.findElement(this.by).getWebElement();
            } catch (StaleElementReferenceException see) {
                parent.refresh();
                try {
                    this.element = this.parent.findElement(this.by).getWebElement();
                } catch (Exception e) {
                    throw new RuntimeException(String.format(ERROR_REFRESHING, this.toString()));
                }
            }
        }
    }

    /*
     * @see Context#findElement(By by)
     */
    public Element findElement(By by) {
        try {
            return new Element(this, by, this.getWebElement().findElement(by));
        } catch (StaleElementReferenceException e) {
            this.refresh();
            return new Element(this, by, this.getWebElement().findElement(by));
        }
    }

    public List<Element> findElements(By by) {
        List<WebElement> firstList = this.getWebElement().findElements(by);
        List<Element> responseList = new ArrayList<Element>();

        for(WebElement we : firstList) {
            responseList.add(new Element(this, by, we));
        }

        return responseList;
    }


    /*
     * @see Clickable#click()
     */
    public void click() {
        try {
            this.getWebElement().click();
        } catch (StaleElementReferenceException see) {
            try {
                this.refresh();
                this.getWebElement().click();
            } catch (Exception e) {
                throw new RuntimeException(String.format(ERROR_REFRESHING, this.toString()));
            }
        }
    }

    /*
     * @see Clickable#click()
     */
    public void type(String value) {
        try {
            this.getWebElement().clear();
            this.getWebElement().sendKeys(value);
        } catch (StaleElementReferenceException see) {
            try {
                this.refresh();
                this.getWebElement().clear();
                this.getWebElement().sendKeys(value);
            } catch (Exception e) {
                throw new RuntimeException(String.format(ERROR_REFRESHING, this.toString()));
            }
        }
    }

    /*
     * @see HasText#getText()
     */
    public String getText() {
        try {
            return this.getWebElement().getText();
        } catch (StaleElementReferenceException see) {
            try {
                this.refresh();
                return this.getWebElement().getText();
            } catch (Exception e) {
                throw new RuntimeException(String.format(ERROR_REFRESHING, this.toString()));
            }
        }
    }

    /*
     * @see Visibility#isVisible()
     */
    public boolean isVisible() {
        try {
            return this.getWebElement().isDisplayed();
        } catch (StaleElementReferenceException see) {
            try {
                this.refresh();
                return this.getWebElement().isDisplayed();
            } catch (Exception e) {
                throw new RuntimeException(String.format(ERROR_REFRESHING, this.toString()));
            }

        }
    }

}
