package com.yana.first.lab.view;

import com.yana.first.lab.beans.Plane;
import com.yana.first.lab.service.PlaneService;

import java.util.List;
import java.util.Scanner;

public class PlaneView implements ViewClass {
    PlaneService service = new PlaneService();
    String menu = "Press:\n" +
            " 1 - to get list of all\n" +
            " 2 - to get\n" +
            " 3 - to create new \n" +
            " 4 - to edit \n" +
            " 5 - to delete \n" +
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

    private void getAll() {
        System.out.println("List of all flight attendants:");
        List<Plane> planeList = service.getAll();
        planeList.forEach(this::printObj);
    }

    private void getById() {
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

    private Plane scanObj() {
        System.out.println("ID: ");
        int id = Integer.parseInt(scan.next());
        System.out.println(" Model: ");
        String model = scan.next();
        System.out.println(" Number of seats: ");
        Integer numberOfSeats = Integer.parseInt(scan.next());
        return new Plane(id, model, numberOfSeats);
    }

    private void printObj(Plane plane) {
        System.out.println("ID: " + plane.getId() +
                " Model: " + plane.getModel() +
                " Number of seats: " + plane.getNumberOfSeats());
    }

    private void search() {
        service.filter(scanObj()).forEach(this::printObj);
    }

    private void sort(){
        service.sort().forEach(this::printObj);
    }

}