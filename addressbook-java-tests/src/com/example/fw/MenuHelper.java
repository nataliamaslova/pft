package com.example.fw;

import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JMenuBarOperator;

/**
 * Created by nataliamaslova on 9/7/2014.
 */
public class MenuHelper extends HelpersBase {

    public MenuHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void pushCreateFolder() {
        JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
        menu.pushMenuNoBlock("File|New folder...");
    }
}
