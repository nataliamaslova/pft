package com.example.fw;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

import java.util.Properties;

/**
 * Created by nataliamaslova on 8/2/2014.
 */
public class ApplicationManager {

    private static ApplicationManager singleton;

    private Properties properties;
    private JFrameOperator mainFrame;
    private FolderHelper folderHelper;
    private MenuHelper menuHelper;

    public static ApplicationManager getInstance() {
        if (singleton == null) {
            singleton = new ApplicationManager();
        }
        return singleton;
    }

    public void stop() {
        getApplication().requestClose();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultVakue) {
        return properties.getProperty(key, defaultVakue);
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public FolderHelper getFolderHelper() {
        if (folderHelper == null) {
            folderHelper = new FolderHelper(this);
        }
        return folderHelper;
    }

    public JFrameOperator getApplication() {
        if (mainFrame == null) {
            try {
                new ClassReference("addressbook.AddressBookFrame").startApplication();
                mainFrame = new JFrameOperator("jAddressBook");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mainFrame;
    }

    public MenuHelper getMenuHelper() {
        if (menuHelper == null) {
            menuHelper = new MenuHelper(this);
        }
        return menuHelper;
    }
}
