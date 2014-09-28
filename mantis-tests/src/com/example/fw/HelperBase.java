package com.example.fw;

/**
 * Created by nataliamaslova on 9/19/2014.
 */
public class HelperBase {

    protected ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
