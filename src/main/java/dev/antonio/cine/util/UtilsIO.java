package dev.antonio.cine.util;

import java.util.*;
import dev.antonio.cine.model.*;

public class UtilsIO {
    private Scanner scanner = new Scanner(System.in);

    public void showAnyMessage(String header, String mainText) {
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

    public void showMenu(String menuText) {
        showAnyMessage(Constants.START_MENU_HEADER, menuText);

    }

    public void showError(String menuText) {
        showAnyMessage(Constants.START_MENU_HEADER, menuText);
    }

    public void showInfo(String menuText) {
        showAnyMessage(Constants.START_MENU_HEADER, menuText);
    }

    public String askForString(String message, String errorMessage) {
        if (message == null || message.isEmpty()) {
            message = Constants.MESSAGE_DEFAULT_ASK_STRING;
        }

        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = Constants.MESSAGE_DEFAULT_ERROR_STRING;
        }

        String text;
        do {
            System.out.println(message);
            text = scanner.nextLine();
            if (text.isEmpty()) {
                System.out.println(errorMessage);
            }

        } while (text.isEmpty());

        return text;
    }

    public int askForInteger(String message, String errorMessage) {
        if (message == null || message.isEmpty()) {
            message = Constants.MESSAGE_DEFAULT_ASK_STRING;
        }

        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = Constants.MESSAGE_DEFAULT_ERROR_STRING;
        }

        int number;
        boolean correct;
        do {
            System.out.println(message);
            correct = scanner.hasNextInt();
            if (!correct) {
                scanner.next();
                System.out.println(errorMessage);
            }

        } while (!correct);
        number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public double askForDouble(String message, String errorMessage) {
        if (message == null || message.isEmpty()) {
            message = Constants.MESSAGE_DEFAULT_ASK_STRING;
        }

        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = Constants.MESSAGE_DEFAULT_ERROR_STRING;
        }

        double number;
        boolean correct;
        do {
            System.out.println(message);
            correct = scanner.hasNextInt();
            if (!correct) {
                scanner.next();
                System.out.println(errorMessage);
            }

        } while (!correct);
        number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public void showStudios(String studiosList) {
        if (studiosList == null || studiosList.isEmpty()) {
            return;
        }

        System.out.println("\n");
        System.out.println(Constants.LIST_HEADER);
        System.out.println(Constants.TEMP_LIN);
        String[] studios = studiosList.split("\n");
        for (String studio : studios) {
            String[] studioField = studio.split(",");
            if (studioField.length == 4) {
                try {
                    double longitude = Double.parseDouble(studioField[2]);
                    double latitude = Double.parseDouble(studioField[3]);
                    System.out.println(String.format(Constants.STUDIO_BOARD_FORMAT, studioField[0], studioField[1], longitude, latitude));
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }
}
