package Controllor;

import Entity.Flight;
import Entity.Ticket;
import Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Check {
    public static Ticket IDCheck(String str) {
        int checkNum = 0;
        int getNum = -1;
        int len = Login.ticketlist.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.ticketlist[checkNum][1])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new Ticket(null, null, null, null, null, null, null);
        } else {
            return new Ticket(Login.ticketlist[getNum][0], Login.ticketlist[getNum][1], Login.ticketlist[getNum][2], Login.ticketlist[getNum][3], Login.ticketlist[getNum][4], Login.ticketlist[getNum][5], Login.ticketlist[getNum][6]);
        }
    }
    public static Flight flightCheck(String str) {
        int checkNum = 0;
        int getNum = -1;
        int len = Login.flightlist.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.flightlist[checkNum][0])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new Flight(null, null, null, null, null);
        } else {
            return new Flight(Login.flightlist[getNum][0], Login.flightlist[getNum][1], Login.flightlist[getNum][2], Login.flightlist[getNum][3], Login.flightlist[getNum][4]);
        }
    }
    public static User userCheck(String str) {
        int checkNum = 0;
        int getNum = -1;
        int len = Login.userlist.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.userlist[checkNum][2])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new User(null, null, null);
        } else {
            return new User(Login.userlist[getNum][0], Login.userlist[getNum][1], Login.userlist[getNum][2]);
        }
    }


    public static Ticket reservationCheck(String str) {

        int checkNum = 0;
        int getNum = -1;
        int len = Login.ticketlist.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.ticketlist[checkNum][0])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new Ticket(null, null, null, null, null, null, null);
        } else {
            return new Ticket(Login.ticketlist[getNum][0], Login.ticketlist[getNum][1], Login.ticketlist[getNum][2], Login.ticketlist[getNum][3], Login.ticketlist[getNum][4], Login.ticketlist[getNum][5], Login.ticketlist[getNum][6]);
        }

    }


    public static Ticket ticketForUser(String userid) {
        int checkNum = 0;
        int ticketNum = 0;
        int len = Login.ticketlist.length;
        List<Integer> getNum = new ArrayList<Integer>();
        for (; checkNum < len; checkNum++) {
            if (userid.equals(Login.ticketlist[checkNum][1])) {
                getNum.add(checkNum);
                ticketNum++;
            }
        }

        System.out.println("You have " + ticketNum + " ticket:");
        for (int i = 0; i < ticketNum; i++) {
            System.out.println(i + 1 + ": " + Login.ticketlist[getNum.get(i)][0]);
        }
        System.out.println("Which one you want to choose.");
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        while (true) {
            int check = 0;
            choose = sc.nextInt();
            for (int i = 0; i < ticketNum; i++) {
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

        return new Ticket(Login.ticketlist[getNum.get(choose - 1)][0], Login.ticketlist[getNum.get(choose - 1)][1], Login.ticketlist[getNum.get(choose - 1)][2],
                Login.ticketlist[getNum.get(choose - 1)][3], Login.ticketlist[getNum.get(choose - 1)][4], Login.ticketlist[getNum.get(choose - 1)][5], Login.ticketlist[getNum.get(choose - 1)][6]);
    }



}
