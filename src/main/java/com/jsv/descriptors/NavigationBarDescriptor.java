package com.jsv.descriptors;

import org.openqa.selenium.By;

import java.util.ResourceBundle;

/**
 * This class is for describing the By objects on the Navigation Bar.
 */
public class NavigationBarDescriptor {

    private static final String GUIDE_LINK_TEXT;
    private static final String API_LINK_TEXT;
    private static final String HELP_LINK_TEXT;
    private static final String BLOG_LINK_TEXT;
    private static final String GITHUB_LINK_TEXT;
    private static final String MAIN_NAV_CLASS;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("com.jsv.descriptors.NavigationBar");

        GUIDE_LINK_TEXT = bundle.getString("GUIDE_LINK");
        API_LINK_TEXT = bundle.getString("API_LINK");
        HELP_LINK_TEXT = bundle.getString("HELP_LINK");
        BLOG_LINK_TEXT = bundle.getString("BLOG_LINK");
        GITHUB_LINK_TEXT = bundle.getString("GITHUB_LINK");

        MAIN_NAV_CLASS = bundle.getString("mainNavClass");

    }

    public static final By NAVIGATION_PARENT_BY = new By.ByClassName(MAIN_NAV_CLASS);

    public static final By GUIDE_LINK_BY = new By.ByLinkText(GUIDE_LINK_TEXT);
    public static final By API_LINK_BY = new By.ByLinkText(API_LINK_TEXT);
    public static final By HELP_LINK_BY = new By.ByLinkText(HELP_LINK_TEXT);
    public static final By BLOG_LINK_BY = new By.ByLinkText(BLOG_LINK_TEXT);
    public static final By GITHUB_LINK_BY = new By.ByLinkText(GITHUB_LINK_TEXT);

 }
