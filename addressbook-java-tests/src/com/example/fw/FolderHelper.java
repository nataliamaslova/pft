package com.example.fw;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nataliamaslova on 9/6/2014.
 */
public class FolderHelper extends HelpersBase {

    public FolderHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public Folders getFolders() {
        List<String> list = new ArrayList<String>();
        JTreeOperator tree = new JTreeOperator(mainFrame);
        Object[] children = tree.getChildren(tree.getRoot());
        for (Object child: children) {
            list.add("" + child);
        }
        return new Folders(list);
    }

    public String createFolder(String folderName) {
        manager.getMenuHelper().pushCreateFolder();
        JDialogOperator dialog = new JDialogOperator(mainFrame);
        new JTextFieldOperator(dialog).setText(folderName);
        new JButtonOperator(dialog, "OK").push();
        return waitMessageDialog("Warning", 3000);
    }

}
