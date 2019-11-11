package com.yana.first.lab.view;

import com.yana.first.lab.beans.Passenger;
import com.yana.first.lab.service.PassengerService;

import java.util.List;
import java.util.Scanner;

/**
 * Class for reflection CRUD functionality for passenger in console
 */
public class PassengerView implements ViewClass {

    private PassengerService service = new PassengerService();
    private String menu = "Press:\n" +
            " 1 - to get list of all\n" +
            " 2 - to get\n" +
            " 3 - to create new flight attendant\n" +
            " 4 - to edit flight attendant\n" +
            " 5 - to delete flight attendant\n" +
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
                    Passenger passenger = scanObj();
                    if (passenger != null) {
                        service.create(passenger);
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

    public void getAll() {
        System.out.println("List of all flight attendants:");
        List<Passenger> flightAttendantList = service.getAll();
        flightAttendantList.forEach(this::printObj);
    }

    public void getById() {
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

    private Passenger scanObj() {
        boolean data = true;
        System.out.println("ID: ");
        String strId = scan.next();
        Integer id = null;
        if (isNumeric(strId)) {
            id = Integer.parseInt(strId);
        } else data = false;
        System.out.println(" First name: ");
        String firstName = scan.next();
        firstName = isNull(firstName);
        System.out.println(" Last name: ");
        String lastName = scan.next();
        lastName = isNull(lastName);
        System.out.println(" Date of birth: ");
        String date = scan.next();
        date = isNull(date);
        System.out.println(" Passport number: ");
        String passport = scan.next();
        if (data) {
            return new Passenger(id, firstName, lastName, date, passport);
        } else return null;
    }

    public void printObj(Passenger passenger) {
        System.out.println("ID: " + passenger.getId() +
                " First name: " + passenger.getFirstName() +
                " Last name: " + passenger.getLastName() +
                " Date of birth: " + passenger.getDateOfBirth() +
                " Passport number: " + passenger.getPassportNumber());
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
