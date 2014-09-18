package com.example.fw;

import java.io.IOException;

/**
 * Created by nataliamaslova on 9/15/2014.
 */
public class ProcessHelper extends HelpersBase {

    private Process process;

    public ProcessHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void startAppUnderTest() throws IOException {
        String command = manager.getProperty("app.path");
        process = Runtime.getRuntime().exec(command);
    }

    public void stopAppUnderTest() {
        process.destroy();
    }
}
