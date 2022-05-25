package Controllor;

import Entity.Ticket;
import Entity.User;
import gui.BagFrame;

import java.util.Scanner;

public class baggage {
    Ticket t;
    String carrybag;
    String checkbag;
    boolean havecarry;
    boolean havecheck;

    public baggage(Ticket t){
        this.t = t;
        this.carrybag = t.getCarryonBag();
        this.checkbag = t.getCheckinBag();
        this.havecarry = true;
        this.havecheck = true;
    }

    public void setCarrybag(String carrybag) {
        this.carrybag = carrybag;
    }

    public void setCheckbag(String checkbag) {
        this.checkbag = checkbag;
    }

    public String getCarrybag() {
        return carrybag;
    }

    public String getCheckbag() {
        return checkbag;
    }

    public boolean isHavecarry() {
        return havecarry;
    }

    public boolean isHavecheck() {
        return havecheck;
    }

   public void findBag(){
        int carry = 0;
        int check = 0;
        String carrybag = this.carrybag;
        String checkbag = this.checkbag;
        System.out.println();
        System.out.println();
        if(carrybag.equals("0") == false){ carry++; }
        else {
            System.out.println("you don't have carry on baggage.");
            this.havecarry = false;
        }
        if(checkbag.equals("0") == false){ check++; }
        else{
            System.out.println("you don't have check in baggage.");
            this.havecheck = false;
        }

        BagFrame fra1 = new BagFrame(this);

        /*if(carry != 0 && check != 0){
            twoBag(carrybag, checkbag);
        }else if(carry != 0){
            printCarry(carrybag);
        }else if(check != 0){
            printCheck(checkbag);
        }*/

    }


    void twoBag(String carrybag, String checkbag) {
        System.out.println("you can find some of your detail of baggage");
        System.out.println("1.print the tag for the carry on baggage.");
        System.out.println("2.print the wondow for check in baggage");
        System.out.println("other.exit.");

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        switch (str) {
            case "1":
                System.out.println("You have " + carrybag + " carry on baggage.");
                break;
            case "2":
                System.out.println("You need to go to " + checkbag + " to send you baggage.");
                break;
            default:
                System.exit(0);
        }

        System.out.println("print any char to back to previous interface");
        Scanner sc2 = new Scanner(System.in);
        String any = sc2.next();
        System.out.println();
        twoBag(carrybag, checkbag);

    }

    void printCarry(String carrybag){
        System.out.println("You have " + carrybag + " carry on baggage.");
        System.out.println("print any char to back to end");
        Scanner sc2 = new Scanner(System.in);
        String any = sc2.next();
        System.exit(1);
    }

    void printCheck(String checkbag){
        System.out.println("You need to go to " + checkbag + " to send you baggage.");
        System.out.println("print any char to back to end");
        Scanner sc2 = new Scanner(System.in);
        String any = sc2.next();
        System.exit(1);
    }

}
