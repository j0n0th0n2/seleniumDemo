package com.jsv.pageObjects;

import com.jsv.sal.Context;
import com.jsv.sal.Element;
import com.jsv.sal.WaitFor;

import static com.jsv.descriptors.NavigationBarDescriptor.*;

public class NavigationBar {

    private final Context parent;
    private final Element baseObject;
    private final Element guideElement;
    private final Element helpElement;
    private final Element githubElement;
    private final Element apiElement;

    public NavigationBar(Context parent) {
        this.parent = parent;
        baseObject = new Element(this.parent,NAVIGATION_PARENT_BY);
        guideElement = new Element(this.baseObject,GUIDE_LINK_BY);
        helpElement = new Element(this.baseObject,HELP_LINK_BY);
        githubElement = new Element(this.baseObject,GITHUB_LINK_BY);
        apiElement = new Element(this.baseObject,API_LINK_BY);
    }

    public APIPage selectAPI() {
        APIPage apiPage = new APIPage(this.parent);
        this.apiElement.click();
        apiPage.waitForSelected();
        return apiPage;
    }

    /* IMPLEMENT OTHER PAGE OBJECT SELECTIONS HERE  */

}
