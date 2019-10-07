package com.jsv.pageObjects;

import com.jsv.sal.Context;
import com.jsv.sal.Element;

import static com.jsv.descriptors.LandingPageDescriptor.*;


public class LandingPage extends Page {

    public String baseUrl = LANDING_PAGE_URI;

    public Context context;

    public LandingPage() {
        super();
        this.webDriver.navigateTo(this.baseUrl);
        context = new Element(this.webDriver,PAGE_BODY_BY);
    }


    public String pageUrl() {
        return this.baseUrl;
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(this.context);
    }

}
