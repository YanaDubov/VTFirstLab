package com.yana.first.lab.view;

import com.yana.first.lab.beans.FlightAttendant;
import com.yana.first.lab.service.FlightAttendantService;

import java.util.List;
import java.util.Scanner;

public class FlightAttendantView implements View {

    FlightAttendantService service = new FlightAttendantService();
    String menu = "Press:\n" +
            " 1 - get list of all flight attendants\n"+
            " 2 - get flight attendant by id\n"+
            " 3 - create new flight attendant\n"+
            " 4 - edit flight attendant\n"+
            " 5 - delete flight attendant" +
            " 0 - exit";
    Scanner scan = new Scanner(System.in);

    public void menu(){
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
                    scanObj();
                    System.out.println(menu);
                    break;
                case 5:
                    delete();
                    System.out.println(menu);
                    break;
                case 0:
                    exit = false;
                    break;
            }
        }
    }
    private void getAll(){
        System.out.println("List of all flight attendants:");
        List<FlightAttendant> flightAttendantList = service.getAll();
        flightAttendantList.forEach(this::printObj);
    }

    private void getById(){
        System.out.println("Enter id: ");
        String s = scan.next();
        int i = Integer.parseInt(s);
        printObj(service.getById(i));
    }

    private void delete(){
        System.out.println("Enter id: ");
        String s = scan.next();
        int i = Integer.parseInt(s);
        service.deleteById(i);
    }

    private FlightAttendant scanObj(){
        System.out.println("ID: ");
        int id =Integer.parseInt( scan.next());
        System.out.println( " First name: " );
        String firstName = scan.next();
        System.out.println(" Last name: ");
        String lastName = scan.next();
        System.out.println(" Phone number: " );
        String phonrNumber = scan.next();
        System.out.println(" Address: ");
        String address = scan.next();
        System.out.println(" Contract number: ");
        String contractNumber = scan.next();
        System.out.println(" Years of experience: ");
        int yearsOfExperience = Integer.parseInt(scan.next());
        return new FlightAttendant(id,firstName,lastName,phonrNumber,address,contractNumber,yearsOfExperience);
    }
    private void printObj(FlightAttendant flightAttendant){
        System.out.println("ID: " + flightAttendant.getId() +
                " First name: " + flightAttendant.getFirstName() +
                " Last name: " + flightAttendant.getLastName() +
                " Phone number: " + flightAttendant.getPhoneNumber() +
                " Address: " + flightAttendant.getAddress() +
                " Contract number: " + flightAttendant.getPhoneNumber() +
                " Years of experiance: " + flightAttendant.getYearsOfExperience());
    }
}
