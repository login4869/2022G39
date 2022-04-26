package Controllor;

import Entity.Ticket;
import Entity.User;

import java.util.Scanner;

public class Meal {
    Ticket t1;

    Meal(Ticket t1){
        this.t1=t1;
        mealChose();
    }

    public void mealChose(){
        System.out.println("Meal Selection");
        System.out.println("1.standard");
        System.out.println("2.vegetarian");
        System.out.println("3.halal");
        System.out.println("4.gourmet menu");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        switch (str) {
            case "1":
                t1.setMeal("standard");
                break;
            case "2":
                t1.setMeal("vegetarian");
                break;
            case "3":
                t1.setMeal("halal");
                break;
            case "4":
                gourmet();
                break;
            default:
                System.out.println("Invalid input");
                System.exit(1);
        }

    }
    public void gourmet(){
        System.out.println("Extra payment gourmet selection");
        System.out.println("1.gourmet1,$10");
        System.out.println("2.gourmet2,$20");
        System.out.println("3.gourmet3,$30");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        switch (str) {
            case "1":
                t1.setMeal("gourmet1");
                break;
            case "2":
                t1.setMeal("gourmet2");
                break;
            case "3":
                t1.setMeal("gourmet3");
                break;
            default:
                System.out.println("Invalid input");
                System.exit(1);
        }

    }


}
