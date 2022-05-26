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
        int len = Login.ticketList.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.ticketList[checkNum][1])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new Ticket(null, null, null, null, null, null, null);
        } else {
            return new Ticket(Login.ticketList[getNum][0], Login.ticketList[getNum][1], Login.ticketList[getNum][2], Login.ticketList[getNum][3], Login.ticketList[getNum][4], Login.ticketList[getNum][5], Login.ticketList[getNum][6]);
        }
    }
    public static Flight flightCheck(String str) {
        int checkNum = 0;
        int getNum = -1;
        int len = Login.flightList.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.flightList[checkNum][0])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new Flight(null, null, null, null, null);
        } else {
            return new Flight(Login.flightList[getNum][0], Login.flightList[getNum][1], Login.flightList[getNum][2], Login.flightList[getNum][3], Login.flightList[getNum][4]);
        }
    }
    public static User userCheck(String str) {
        int checkNum = 0;
        int getNum = -1;
        int len = Login.userList.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.userList[checkNum][2])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new User(null, null, null);
        } else {
            return new User(Login.userList[getNum][0], Login.userList[getNum][1], Login.userList[getNum][2]);
        }
    }


    public static Ticket reservationCheck(String str) {

        int checkNum = 0;
        int getNum = -1;
        int len = Login.ticketList.length;

        for (; checkNum < len; checkNum++) {
            if (str.equals(Login.ticketList[checkNum][0])) {
                getNum = checkNum;
            }
        }


        if (getNum == -1) {
            return new Ticket(null, null, null, null, null, null, null);
        } else {
            return new Ticket(Login.ticketList[getNum][0], Login.ticketList[getNum][1], Login.ticketList[getNum][2], Login.ticketList[getNum][3], Login.ticketList[getNum][4], Login.ticketList[getNum][5], Login.ticketList[getNum][6]);
        }

    }


    public static Ticket ticketForUser(String userid) {
        int checkNum = 0;
        int ticketNum = 0;
        int len = Login.ticketList.length;
        List<Integer> getNum = new ArrayList<Integer>();
        for (; checkNum < len; checkNum++) {
            if (userid.equals(Login.ticketList[checkNum][1])) {
                getNum.add(checkNum);
                ticketNum++;
            }
        }

        System.out.println("You have " + ticketNum + " ticket:");
        for (int i = 0; i < ticketNum; i++) {
            System.out.println(i + 1 + ": " + Login.ticketList[getNum.get(i)][0]);
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

        return new Ticket(Login.ticketList[getNum.get(choose - 1)][0], Login.ticketList[getNum.get(choose - 1)][1], Login.ticketList[getNum.get(choose - 1)][2],
                Login.ticketList[getNum.get(choose - 1)][3], Login.ticketList[getNum.get(choose - 1)][4], Login.ticketList[getNum.get(choose - 1)][5], Login.ticketList[getNum.get(choose - 1)][6]);
    }



}
