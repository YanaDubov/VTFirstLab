package com.yana.first.lab.view;

import com.yana.first.lab.beans.Pilot;
import com.yana.first.lab.service.PilotService;

import java.util.List;
import java.util.Scanner;

/**
 * Class for reflection CRUD functionality for pilot in console
 */
public class PilotView implements ViewClass {
    private PilotService service = new PilotService();
    private String menu = "Press:\n" +
            " 1 - to get list of all\n" +
            " 2 - to get\n" +
            " 3 - to create new \n" +
            " 4 - to edit \n" +
            " 5 - to delete \n" +
            " 6 - to search\n" +
            " 7 - to sort\n" +
            " 0 - to exit";
    private Scanner scan = new Scanner(System.in);

    public void menu() {
        getAll();
        System.out.println(menu);
        String s = scan.next();
        int i = Integer.parseInt(s);
        boolean exit = true;
        while (exit) {
            switch (i) {
                case 1:
                    getAll();
                    System.out.println(menu);
                    break;
                case 2:
                    getById();
                    System.out.println(menu);
                    break;
                case 3:
                case 4:
                    Pilot pilot = scanObj();
                    if (pilot != null) {
                        service.create(pilot);
                    } else {
                        System.out.println("Invalid data!");
                    }
                    System.out.println(menu);
                    break;
                case 5:
                    delete();
                    System.out.println(menu);
                    break;
                case 6:
                    search();
                    System.out.println(menu);
                    break;
                case 7:
                    sort();
                    System.out.println(menu);
                    break;
                case 0:
                    exit = false;
                    break;
            }
            s = scan.next();
            i = Integer.parseInt(s);
        }


    }

    private void getAll() {
        System.out.println("List of all flight attendants:");
        List<Pilot> pilotList = service.getAll();
        pilotList.forEach(this::printObj);
    }

    private void getById() {
        try {
            System.out.println("Enter id: ");
            String s = scan.next();
            int i = Integer.parseInt(s);
            printObj(service.getById(i));
        } catch (NullPointerException e) {
            System.out.println("Wrong id");
        }
    }

    private void delete() {
        try {
            System.out.println("Enter id: ");
            String s = scan.next();
            int i = Integer.parseInt(s);
            service.deleteById(i);
        } catch (NullPointerException e) {
            System.out.println("Wrong id");
        }
    }

    private Pilot scanObj() {
        boolean data = true;
        System.out.println("ID: ");
        String strId = scan.next();
        Integer id = null;
        if (isNumeric(strId)) {
            id = Integer.parseInt(strId) == -1 ? null : Integer.parseInt(strId);
        } else data = false;
        System.out.println(" First name: ");
        String firstName = scan.next();
        firstName = isNull(firstName);
        System.out.println(" Last name: ");
        String lastName = scan.next();
        lastName = isNull(lastName);
        System.out.println(" Phone number: ");
        String phoneNumber = scan.next();
        phoneNumber = isNull(phoneNumber);
        System.out.println(" Address: ");
        String address = scan.next();
        address = isNull(address);
        System.out.println(" Contract number: ");
        String contractNumber = scan.next();
        contractNumber = isNull(contractNumber);
        System.out.println(" Rank: ");
        String rank = scan.next();
        rank = isNull(rank);
        if (data) {
            return new Pilot(id, firstName, lastName, phoneNumber, address, contractNumber, rank);
        } else return null;
    }

    private void printObj(Pilot pilot) {
        System.out.println("ID: " + pilot.getId() +
                " First name: " + pilot.getFirstName() +
                " Last name: " + pilot.getLastName() +
                " Phone number: " + pilot.getPhoneNumber() +
                " Address: " + pilot.getAddress() +
                " Contract number: " + pilot.getPhoneNumber() +
                " Rank: " + pilot.getRank());
    }

    private void search() {
        service.filter(scanObj()).forEach(this::printObj);
    }

    private void sort() {
        service.sort().forEach(this::printObj);
    }

    private static boolean isNumeric(String strNum) {
        int d;
        try {
            d = Integer.parseInt(strNum);

        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        if (d < -1) {
            return false;
        }
        return true;
    }

    private String isNull(String string) {
        if (string.equals("-1")) {
            return null;
        } else
            return string;
    }
}
