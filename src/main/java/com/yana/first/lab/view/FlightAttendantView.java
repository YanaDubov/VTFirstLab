package com.yana.first.lab.view;

import com.yana.first.lab.beans.FlightAttendant;
import com.yana.first.lab.service.FlightAttendantService;

import java.util.List;
import java.util.Scanner;

/**
 * Class for reflection CRUD functionality for flight attendant in console
 */
public class FlightAttendantView implements ViewClass {

    private FlightAttendantService service = new FlightAttendantService();
    private String menu = "Press:\n" +
            " 1 - to get list of all\n" +
            " 2 - to get\n" +
            " 3 - to create new \n" +
            " 4 - to edit \n" +
            " 5 - to delete by id\n" +
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
                    FlightAttendant flightAttendant = scanObj();
                    if (flightAttendant != null) {
                        service.create(flightAttendant);
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
        List<FlightAttendant> flightAttendantList = service.getAll();
        flightAttendantList.forEach(this::printObj);
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

    private FlightAttendant scanObj() {
        boolean validData = true;
        System.out.println("ID: ");
        String id = scan.next();
        Integer intId = null;
        if (isNumeric(id)) {
            intId = Integer.parseInt(id) == -1 ? null : Integer.parseInt(id);
        } else validData = false;
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
        System.out.println(" Years of experience: ");
        String years = scan.next();
        Integer yearsOfExperience = null;
        if (isNumeric(years)) {
            yearsOfExperience = Integer.parseInt(years) == -1 ? null : Integer.parseInt(years);
        } else validData = false;
        if (validData) {
            return new FlightAttendant(intId, firstName, lastName, phoneNumber, address, contractNumber, yearsOfExperience);
        } else return null;
    }

    private void printObj(FlightAttendant flightAttendant) {
        System.out.println("ID: " + flightAttendant.getId() +
                " First name: " + flightAttendant.getFirstName() +
                " Last name: " + flightAttendant.getLastName() +
                " Phone number: " + flightAttendant.getPhoneNumber() +
                " Address: " + flightAttendant.getAddress() +
                " Contract number: " + flightAttendant.getPhoneNumber() +
                " Years of experiance: " + flightAttendant.getYearsOfExperience());
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
