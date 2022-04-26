package Controllor;

import Entity.Ticket;
import Entity.User;

import java.util.Scanner;

public class Special_Seat {
    Ticket t2;

    Special_Seat(Ticket t2){
        this.t2=t2;
        S_SeatChose();
    }

    public void S_SeatChose(){
        System.out.println("Special seat selection");
        System.out.println("1.first class");
        System.out.println("2.economy class");
        System.out.println("3.business class");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        switch (str) {
            case "1":
                t2.setSseat("standard");
                break;
            case "2":
                t2.setSseat("vegetarian");
                break;
            case "3":
                t2.setSseat("halal");
                break;
            default:
                System.out.println("Invalid input");
                System.exit(1);
        }

    }


}
