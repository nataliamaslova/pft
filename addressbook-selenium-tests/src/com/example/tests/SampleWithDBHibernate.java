package com.example.tests;

import com.example.fw.ApplicationManager;
import com.example.fw.JdbcHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by nataliamaslova on 9/19/2014.
 */
public class SampleWithDBHibernate {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("application.properties")));
        ApplicationManager app = new ApplicationManager(properties);
        System.out.println(app.getHibernateHelper().listGroups());
    }
}
