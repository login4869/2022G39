package Controllor;

import Entity.Ticket;
import Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Check {
    public static User IDCheck(String str) {
        int checknum = 0;
        int getnum = -1;
        int len = Login.userlist.length;

        for (; checknum < len; checknum++) {
            if (str.equals(Login.userlist[checknum][2])) {
                getnum = checknum;
            }
        }


        if (getnum == -1) {
            return new User(null, null, null);
        } else {
            return new User(Login.userlist[getnum][0], Login.userlist[getnum][1], Login.userlist[getnum][2]);
        }
    }


    public static Ticket reservationCheck(String str) {

        int checknum = 0;
        int getnum = -1;
        int len = Login.ticketlist.length;

        for (; checknum < len; checknum++) {
            if (str.equals(Login.ticketlist[checknum][0])) {
                getnum = checknum;
            }
        }


        if (getnum == -1) {
            return new Ticket(null, null, null, null, null, null, null);
        } else {
            return new Ticket(Login.ticketlist[getnum][0], Login.ticketlist[getnum][1], Login.ticketlist[getnum][2], Login.ticketlist[getnum][3], Login.ticketlist[getnum][4], Login.ticketlist[getnum][5], Login.ticketlist[getnum][6]);
        }

    }


    public static Ticket ticketForUser(String userid) {
        int checknum = 0;
        int ticketnum = 0;
        int len = Login.ticketlist.length;
        List<Integer> getnum = new ArrayList<Integer>();
        for (; checknum < len; checknum++) {
            if (userid.equals(Login.ticketlist[checknum][1])) {
                getnum.add(checknum);
                ticketnum++;
            }
        }

        System.out.println("You have " + ticketnum + " ticket:");
        for (int i = 0; i < ticketnum; i++) {
            System.out.println(i + 1 + ": " + Login.ticketlist[getnum.get(i)][0]);
        }
        System.out.println("Which one you want to choose.");
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        while (true) {
            int check = 0;
            choose = sc.nextInt();
            for (int i = 0; i < ticketnum; i++) {
                if (choose == i + 1) {
                    check = 1;
                    System.out.println(check);
                }
            }
            if (check == 1) {
                break;
            } else {
                System.out.println("you enter the wrong number");
            }
        }

        return new Ticket(Login.ticketlist[getnum.get(choose - 1)][0], Login.ticketlist[getnum.get(choose - 1)][1], Login.ticketlist[getnum.get(choose - 1)][2],
                Login.ticketlist[getnum.get(choose - 1)][3], Login.ticketlist[getnum.get(choose - 1)][4], Login.ticketlist[getnum.get(choose - 1)][5], Login.ticketlist[getnum.get(choose - 1)][6]);
    }



}
