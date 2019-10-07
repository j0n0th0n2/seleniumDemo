package com.jsv.descriptors;

import org.openqa.selenium.By;

import java.util.ResourceBundle;

public class ApiPageDescriptor {

    public static final String URI = "/api.html";

    public static final By API_HEADER_BY = new By.ById("WebdriverIO-API-Docs");
    public static final By API_PAGE_SEARCH_NAME_BY = new By.ByName("search");

    public static final By API_ACTION_NAV_MENU_BY = new By.ByClassName("commands");
    public static final By NAVIGATION_LINK_BY = new By.ByXPath(".//a[not(contains(@style,'display: none'))]");

    public static final String API_HEADING_TITLE_TEXT;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle(ApiPageDescriptor.class.getName());

        API_HEADING_TITLE_TEXT = bundle.getString("headingTitle");
    }
}
