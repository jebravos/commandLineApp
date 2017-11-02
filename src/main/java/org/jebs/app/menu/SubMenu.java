package org.jebs.app.menu;

import java.io.IOException;

public abstract class SubMenu extends Menu {

    protected Menu previousMenu;

    public SubMenu(Menu previousMenu) {
        this.previousMenu = previousMenu;
    }

    protected void printPreviousMenu() throws IOException {
        previousMenu.printMenu();
    }
}
