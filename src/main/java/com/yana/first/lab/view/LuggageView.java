package com.yana.first.lab.view;

import com.yana.first.lab.beans.Luggage;
import com.yana.first.lab.service.LuggageService;

import java.util.List;
import java.util.Scanner;

/**
 * Class for reflection CRUD functionality for luggage in console
 */
public class LuggageView implements ViewClass {

    private LuggageService service = new LuggageService();
    private String menu = "Press:\n" +
            " 1 - to get list of all\n" +
            " 2 - to get\n" +
            " 3 - to create new \n" +
            " 4 - to edit\n" +
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
                    Luggage luggage = scanObj();
                    if (luggage != null) {
                        service.create(luggage);
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
        List<Luggage> luggageList = service.getAll();
        luggageList.forEach(this::printObj);
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

    private Luggage scanObj() {
        boolean data = true;
        System.out.println("ID: ");
        String strId = scan.next();
        Integer id = null;
        if (isNumeric(strId)) {
            id = Integer.parseInt(strId) == -1 ? null : Integer.parseInt(strId);
        } else data = false;
        System.out.println(" Weight: ");
        String strW = scan.next();
        Integer weight = null;
        if (isNumeric(strW)) {
            weight = Integer.parseInt(strW) == -1 ? null : Integer.parseInt(strW);
        } else data = false;
        if (data) {
            return new Luggage(id, weight);
        } else return null;
    }

    private void printObj(Luggage luggage) {
        System.out.println("ID: " + luggage.getId() +
                " Weight : " + luggage.getWeight());
    }

    private void search() {
        System.out.println("By\n 1 - ID\n 2 - Weight\n 0 - exit");
        String s = scan.next();
        int i = Integer.parseInt(s);
        switch (i){
            case 1:
                System.out.println("ID:");
                String s1 = scan.next();
                if(isNumeric(s)){
                    Integer i1 = Integer.parseInt(s1);
                    service.filter(new Luggage(i1)).forEach(this::printObj);
                }else{
                    System.out.println("Invalid id");
                }
                break;
            case 2:
                System.out.println("Weight:");
                String string = scan.next();
                if(isNumeric(string)){
                    Integer in = Integer.parseInt(string);
                    Luggage luggage  = new Luggage();
                    luggage.setWeight(in);
                    service.filter(luggage).forEach(this::printObj);
                }else{
                    System.out.println("Invalid id");
                }
                break;
            case 0:
                break;

        }
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


}
