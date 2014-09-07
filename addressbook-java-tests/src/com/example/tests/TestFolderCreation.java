package com.example.tests;

import com.example.fw.Folders;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by nataliamaslova on 9/6/2014.
 */
public class TestFolderCreation extends TestBase {

    @Test
    public void testFolderCreation() {
        String folder = "newFolder";
        Folders oldFolders = app.getFolderHelper().getFolders();
        app.getFolderHelper().createFolder(folder);
        Folders newFolders = app.getFolderHelper().getFolders();
        assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
    }

    @Test
    public void testVariousFolderCreation() {
        String folder1 = "newFolder1";
        String folder2 = "newFolder2";
        Folders oldFolders = app.getFolderHelper().getFolders();
        assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
        Folders newFolders = app.getFolderHelper().getFolders();
        assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));
        assertThat(app.getFolderHelper().createFolder(folder2), is(nullValue()));
        Folders newFolders2 = app.getFolderHelper().getFolders();
        assertThat(newFolders2, equalTo(newFolders.withAdded(folder2)));
    }

    @Test
    public void testFoldersWithSameNameCreation() {
        String folder1 = "newFolder3";
        String folder2 = "newFolder3";
        Folders oldFolders = app.getFolderHelper().getFolders();
        assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
        Folders newFolders = app.getFolderHelper().getFolders();
        assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));
        assertThat(app.getFolderHelper().createFolder(folder2), containsString("Duplicated folder name"));
        Folders newFolders2 = app.getFolderHelper().getFolders();
        assertThat(newFolders2, equalTo(newFolders));
    }
}
