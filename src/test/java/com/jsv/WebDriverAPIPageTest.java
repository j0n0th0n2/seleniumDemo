package com.jsv;

import com.jsv.pageObjects.APIPage;
import com.jsv.pageObjects.LandingPage;
import com.jsv.pageObjects.NavigationBar;
import com.jsv.sal.Element;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WebDriverAPIPageTest {


    private static APIPage apiPage;

    @Before
    public void setup() {
        if(apiPage==null || !apiPage.isSelected()) {
            LandingPage landingPage = new LandingPage();
            NavigationBar navBar = landingPage.getNavigationBar();
            apiPage = navBar.selectAPI();
        }
    }


    @AfterClass
    public static void cleanup() {
        apiPage.close();
    }

    @Test
    public void testAPIPageSearchReducedLists() {

        List<Element> list = apiPage.getNavigationList();
        apiPage.enterSearchText("CLICK");
        List<Element> secondList = apiPage.getNavigationList();

        assertTrue(String.format("the number of elements [%s] should be less then before [%s]",secondList.size(),list.size()),
                list.size() > secondList.size());


    }


    @Test
    public void testAPIPageSearch() {
        apiPage.enterSearchText("CLICK");

        List<Element> displayedLinks = apiPage.getNavigationList();
        assertEquals("the number of items [5] was not as expected: " + displayedLinks.size(), 5, displayedLinks.size());

        List<String> expectedList = Arrays.asList("click", "doubleClick", "leftClick", "middleClick", "rightClick");
        for(Element link : displayedLinks) {
            String text = link.getText();
            assertTrue(String.format("The value [%s] was not in the expected list[%s]", text, expectedList),
                    expectedList.contains(text));
        }

    }
}
