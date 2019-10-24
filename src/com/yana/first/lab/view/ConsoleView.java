package com.yana.first.lab.view;

import com.yana.first.lab.beans.FlightAttendant;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
    Map<Integer,Class> menu = new HashMap<>();
    Map<Class,View> classes = new HashMap<>();
    Scanner scan = new Scanner(System.in);

    public ConsoleView() {
        menu.put(1,FlightAttendant.class);
        classes.put(FlightAttendant.class, new FlightAttendantView());
    }

    public static void main(String[] args){
        ConsoleView consoleView = new ConsoleView();
        while (true){
            System.out.println("Choose class to work with: ");
            consoleView.menu.forEach((integer, aClass) -> System.out.println(integer + " - " + aClass.getAnnotations()[0].));
            System.out.println("0 - exit");
            Scanner scan = new Scanner(System.in);
            String s = scan.next();
            int i = Integer.parseInt(s);
            if (i == 0){
                break;
            }else {
                consoleView.classes.get(consoleView.menu.get(i)).menu();
            }
        }


    }
}
