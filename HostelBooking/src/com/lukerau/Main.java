package com.lukerau;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final LocalDate TODAY = LocalDate.now();
    private static final Scanner scanner = new Scanner(System.in);
    public static final Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        User admin = new User("admin", "admin123");
        users.put(admin.getName(), admin.getPassword());

        System.out.println("[Today: " + TODAY + "]");
        logInMenu();

    }

    private static void logInMenu() {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("1. LOG IN" +
                    "\n2. EXIT");
            String a = scanner.nextLine();
            switch (a) {
                case "1":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    if (users.containsKey(name)) {
                        System.out.println("Enter password:");
                        String password = scanner.nextLine();
                        if (users.get(name)) {
                            System.out.println("Logged in.");
                            loggedIn = true;
                        } else {
                            System.out.println("Wrong password.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case "2":
                    System.out.println("Exit.");
                    System.exit(0);
                default:
                    System.out.println("Type either 1 or 2.");
            }
        }

        while (loggedIn) {
            //mainMenu();
        }
    }

    public static void logOutMenu(){

    }
}
/*
MENU:
    A. LOG IN
        A1. LOG OUT (AUTO-SAVE)
            1. RESERVATIONS
                1.1 MAKE NEW RESERVATION
                1.2 CONFIRM RESERVATION (unconfirmed reservations will be canceled automatically -> 4.3.1)
                1.3 SEARCH BY ROOM (shows available dates)
                1.4 SEARCH BY DATE (shows available rooms)
                1.5 EDIT RESERVATION
                1.6 CANCEL RESERVATION (and "Add a new one?")
                1.7 GO BACK
            2. CHECK-IN / CHECK-OUT
                2.1 CHECK-IN
                2.2 CHECK-OUT
                    2.2.1 PRINT BILL
                    2.2.2 GO BACK
                2.3 SEARCH BY NAME
                2.4 SEARCH BY ROOM
                2.5 SEARCH BY RESERVATION
                2.6 GO BACK
            3. PRINT
                3.1 DAILY INCOME
                3.2 MONTHLY INCOME
                3.3 GO BACK
            4. OPTIONS
                4.1 ROOMS
                    4.1.1 ADD NEW ROOM
                    4.1.2 EDIT ROOM
                    4.1.3 REMOVE ROOM
                    4.1.4 GO BACK
                4.2 SERVICES
                    4.2.1 ADD NEW SERVICE
                    4.2.2 EDIT SERVICE
                    4.2.3 REMOVE SERVICE
                    4.2.4 GO BACK
                4.3 OTHERS
                    4.3.1 SET AUTO-CANCELLING
                    4.3.2 GO BACK
                4.4 ACCOUNT
                    4.4.1 ADD NEW USER
                    4.4.2 EDIT USER
                    4.4.3 REMOVE USER
                    4.4.4 GO BACK
            5. GO BACK
    B. EXIT (AUTO-LOG OUT WITH AUTO-SAVE)
 */