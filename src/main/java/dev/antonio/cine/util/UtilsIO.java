package dev.antonio.cine.util;

import java.util.*;
import dev.antonio.cine.model.*;

public class UtilsIO {

    public void showAnyMessage(String header, String mainText){
        if (mainText == null || mainText.isEmpty()
        || header == null || header.isEmpty()) {
            return;
        }
        System.out.println(Constants.EMPTY_SPACE);
        System.out.println(Constants.SEPARATOR);
        System.out.println(header);
        System.out.println(Constants.SEPARATOR);
        System.out.println(mainText);
        System.out.println(Constants.EMPTY_SPACE);
        
    }

    public void showMenu(String menuText){
        showAnyMessage(Constants.START_MENU_HEADER, menuText);

    }

    public void showError(String menuText){
        showAnyMessage(Constants.START_MENU_HEADER, menuText);
    }

    public void showInfo(String menuText){
        showAnyMessage(Constants.START_MENU_HEADER, menuText);
    }
}
