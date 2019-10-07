package com.jsv.sal;

import java.util.concurrent.TimeoutException;

/**
 * This class is for waiting for a specific event to occur on the page
 */
public abstract class WaitFor {

    private final int timeout;
    private final int delay;

    public WaitFor(int delay, int timeout) {
        this.delay = delay;
        this.timeout = timeout;
    }

    public void waitForCondition() throws TimeoutException {
        long startTime = System.currentTimeMillis();

        while ((startTime - System.currentTimeMillis()) < timeout) {
            if (eventOccurred()) {
                return;
            } else {
                try {
                    Thread.sleep(this.delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        throw new TimeoutException("Event did not occur in the expected amount of time.");
    }

    /**
     * This implement this to represent the event to delay until.
     * @return boolean if the event waiting for occurred
     */
    public abstract boolean eventOccurred();


    /**
     * Wait for the element to be visible.
     */
    public static class Visible extends  WaitFor{

        private final Visibility element;

        public Visible(int delay, int timeout, Visibility element) {
            super(delay, timeout);
            this.element = element;
        }

        public boolean eventOccurred() {
            return this.element.isVisible();
        }
    }

    /**
     * Wait for the element to be visible.
     */
    public static class Text extends  WaitFor {

        private final HasText element;
        private final String text;

        public Text(int delay, int timeout, HasText element, String text) {
            super(delay, timeout);
            this.element = element;
            this.text = text;
        }

        public boolean eventOccurred() {
            return this.element.getText().contentEquals(text);
        }
    }



}
