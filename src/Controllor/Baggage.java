package Controllor;

import Entity.Ticket;
import gui.BagFrame;

import java.util.Scanner;

public class Baggage {
    Ticket t;
    String carryBag;
    String checkBag;
    boolean haveCarry;
    boolean haveCheck;

    public Baggage(Ticket t) {
        this.t = t;
        this.carryBag = t.getCarryonBag();
        this.checkBag = t.getCheckinBag();
        this.haveCarry = true;
        this.haveCheck = true;
    }

    public String getCarryBag() {
        return carryBag;
    }

    public void setCarryBag(String carryBag) {
        this.carryBag = carryBag;
    }

    public String getCheckBag() {
        return checkBag;
    }

    public void setCheckBag(String checkBag) {
        this.checkBag = checkBag;
    }

    public boolean isHaveCarry() {
        return haveCarry;
    }

    public boolean isHaveCheck() {
        return haveCheck;
    }

    public void findBag() {
        int carry = 0;
        int check = 0;
        String carryBag1 = this.carryBag;
        String checkBag1 = this.checkBag;
        System.out.println();
        System.out.println();
        if (carryBag1.equals("0") == false) {
            carry++;
        } else {
            System.out.println("you don't have carry on Baggage.");
            this.haveCarry = false;
        }
        if (checkBag1.equals("0") == false) {
            check++;
        } else {
            System.out.println("you don't have check in Baggage.");
            this.haveCheck = false;
        }

        BagFrame fra1 = new BagFrame(this);

        /*if(carry != 0 && check != 0){
            twoBag(carryBag1, checkBag1);
        }else if(carry != 0){
            printCarry(carryBag1);
        }else if(check != 0){
            printCheck(checkBag1);
        }*/

    }


    void twoBag(String carryBag, String checkBag) {
        System.out.println("you can find some of your detail of Baggage");
        System.out.println("1.print the tag for the carry on Baggage.");
        System.out.println("2.print the wondow for check in Baggage");
        System.out.println("other.exit.");

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        switch (str) {
            case "1":
                System.out.println("You have " + carryBag + " carry on Baggage.");
                break;
            case "2":
                System.out.println("You need to go to " + checkBag + " to send you Baggage.");
                break;
            default:
                System.exit(0);
        }

        System.out.println("print any char to back to previous interface");
        Scanner sc2 = new Scanner(System.in);
        String any = sc2.next();
        System.out.println();
        twoBag(carryBag, checkBag);

    }

    void printCarry(String carryBag) {
        System.out.println("You have " + carryBag + " carry on Baggage.");
        System.out.println("print any char to back to end");
        Scanner sc2 = new Scanner(System.in);
        String any = sc2.next();
        System.exit(1);
    }

    void printCheck(String checkBag) {
        System.out.println("You need to go to " + checkBag + " to send you Baggage.");
        System.out.println("print any char to back to end");
        Scanner sc2 = new Scanner(System.in);
        String any = sc2.next();
        System.exit(1);
    }

}
