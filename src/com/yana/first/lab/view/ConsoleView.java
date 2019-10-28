package com.yana.first.lab.view;

import com.yana.first.lab.beans.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
    Map<Integer, Class> menu = new HashMap<>();
    Map<Class, ViewClass> classes = new HashMap<>();
    Scanner scan = new Scanner(System.in);

    public ConsoleView() {
        menu.put(1, FlightAttendant.class);
        menu.put(2, Luggage.class);
        menu.put(3, Passenger.class);
        menu.put(4, Pilot.class);
        menu.put(5, Plane.class);
        menu.put(6, Ticket.class);
        classes.put(FlightAttendant.class, new FlightAttendantView());
        classes.put(Luggage.class, new LuggageView());
        classes.put(Passenger.class, new PassengerView());
        classes.put(Pilot.class, new PilotView());
        classes.put(Plane.class, new PlaneView());
        classes.put(Ticket.class, new TicketView());
    }

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        while (true) {
            System.out.println("Choose class to work with: ");
            final int[] i = {0};
            consoleView.menu.forEach((integer, aClass) ->
            {
                try {
                    for (Annotation annotation : aClass.getAnnotations()) {
                        Class<? extends Annotation> type = annotation.annotationType();
                        for (Method method : type.getDeclaredMethods()) {
                            Object value = method.invoke(annotation, (Object[]) null);
                            if (method.getName().equals("name")) {
                                System.out.println(integer + " - " + value);
                            }
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("0 - exit\n");
            Scanner scan = new Scanner(System.in);
            String s = scan.next();
            int j = Integer.parseInt(s);
            if (j == 0) {
                break;
            } else {
                consoleView.classes.get(consoleView.menu.get(j)).menu();
            }
        }
    }
}
