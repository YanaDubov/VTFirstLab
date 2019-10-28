package com.yana.first.lab.view;

import com.yana.first.lab.beans.Passenger;
import com.yana.first.lab.service.PassengerService;

import java.util.List;
import java.util.Scanner;

public class PassengerView implements ViewClass {

    PassengerService service = new PassengerService();
    String menu = "Press:\n" +
            " 1 - to get list of all\n" +
            " 2 - to get\n" +
            " 3 - to create new flight attendant\n" +
            " 4 - to edit flight attendant\n" +
            " 5 - to delete flight attendant\n" +
            " 6 - to search\n" +
            " 7 - to sort\n" +
            " 0 - to exit";
    Scanner scan = new Scanner(System.in);

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
                    service.create(scanObj());
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
        }
    }

    public void getAll() {
        System.out.println("List of all flight attendants:");
        List<Passenger> flightAttendantList = service.getAll();
        flightAttendantList.forEach(this::printObj);
    }

    public void getById() {
        System.out.println("Enter id: ");
        String s = scan.next();
        int i = Integer.parseInt(s);
        printObj(service.getById(i));
    }

    private void delete() {
        System.out.println("Enter id: ");
        String s = scan.next();
        int i = Integer.parseInt(s);
        service.deleteById(i);
    }

    private Passenger scanObj() {
        System.out.println("ID: ");
        int id = Integer.parseInt(scan.next());
        System.out.println(" First name: ");
        String firstName = scan.next();
        System.out.println(" Last name: ");
        String lastName = scan.next();
        System.out.println(" Date of birth: ");
        String date = scan.next();
        System.out.println(" Passport number: ");
        String passport = scan.next();
        return new Passenger(id, firstName, lastName, date, passport);
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

    private void sort(){
        service.sort().forEach(this::printObj);
    }

}
