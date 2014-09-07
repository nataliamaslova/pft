package com.example.tests;

import com.example.fw.Folders;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by nataliamaslova on 9/7/2014.
 */
public class TestFolderDeletion extends TestBase {

    @Test
    public void testFolderDeletion() {
        String folder = "Persons";
        Folders oldFolders = app.getFolderHelper().getFolders();
        app.getFolderHelper().deleteFolder(folder);
        Folders newFolders = app.getFolderHelper().getFolders();
        assertThat(newFolders, equalTo(oldFolders.withDeleted(folder)));
    }

    @Test
    public void testFolderCreationAndDeletion() {
        String folder = "123";
        app.getFolderHelper().createFolder(folder);
        Folders oldFolders = app.getFolderHelper().getFolders();
        app.getFolderHelper().deleteFolder(folder);
        Folders newFolders = app.getFolderHelper().getFolders();
        assertThat(newFolders, equalTo(oldFolders.withDeleted(folder)));
    }
}
