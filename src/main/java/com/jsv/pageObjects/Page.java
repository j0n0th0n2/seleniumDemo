package com.jsv.pageObjects;

import com.jsv.sal.Driver;

public abstract class Page {

    static Driver webDriver = null;

    public Page () {
        if( this.webDriver==null) {
            this.webDriver = new Driver();
        }
    }

    public boolean isSelected() {
        String current = this.webDriver.getCurrentUrl();
        if(current==null || current.trim().contentEquals("")) {
            return false;
        }
        return current.contains(this.pageUrl()); //XXX need a better way
    }

    public abstract String pageUrl();

    public void close() {
        this.webDriver.close();
    }
}
