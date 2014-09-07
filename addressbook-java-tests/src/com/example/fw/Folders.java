package com.example.fw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliamaslova on 9/6/2014.
 */
public class Folders {
    private List<String> storedFolders = null;

    public Folders(List<String> folders) {
        this.storedFolders = new ArrayList<String>(folders);
    }


    public Folders withAdded(String folder) {
        Folders newList = new Folders(storedFolders);
        newList.storedFolders.add(folder);
        return newList;
    }

    public Folders withDeleted(String folder) {
        Folders newList = new Folders(storedFolders);
        newList.storedFolders.remove(folder);
        return newList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Folders)) return false;

        Folders folders = (Folders) o;

        if (!storedFolders.equals(folders.storedFolders)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return storedFolders.hashCode();
    }

    @Override
    public String toString() {
        return "Folders{" +
                "storedFolders=" + storedFolders +
                '}';
    }


    public Folders getFolders() {
        return null;
    }

    public void createFolder(String newFolder) {
    }
}
