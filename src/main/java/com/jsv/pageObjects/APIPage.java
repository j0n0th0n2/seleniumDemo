package com.jsv.pageObjects;

import com.jsv.descriptors.ApiPageDescriptor;
import com.jsv.sal.Context;
import com.jsv.sal.Element;
import com.jsv.sal.WaitFor;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static com.jsv.descriptors.ApiPageDescriptor.*;

public class APIPage extends Page{

    private Element pageHeadingTitle;
    private Element searchBar;
    private Element navMenu;

    private final Context parent;

    public APIPage(Context context) {
        super();
        this.parent  = context;
        pageHeadingTitle = new Element(this.parent, API_HEADER_BY);
        searchBar = new Element(this.parent, API_PAGE_SEARCH_NAME_BY);
        navMenu = new Element (this.parent, API_ACTION_NAV_MENU_BY);
    }


    public String pageUrl() {
        return ApiPageDescriptor.URI;
    }

    public void waitForSelected() {
        WaitFor.Text waiter = new WaitFor.Text(100, 3000, pageHeadingTitle, API_HEADING_TITLE_TEXT);
        try {
            waiter.waitForCondition();
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterSearchText(String searchText) {
        this.searchBar.type(searchText);
    }

    public List<Element> getNavigationList() {
        return this.navMenu.findElements(NAVIGATION_LINK_BY);
    }
}
