import java.util.Scanner;

public class Login {
    static User user;
    static Flight flight;
    static Ticket ticket;

    static String[][] userlist;
    static String[][] ticketlist;
    //static String [][] flightlist;

    public void loginOption() {

        userlist = getdata.UserRead();
        ticketlist = getdata.TicketRead();
        //flightlist = getdata.FlightRead();

        System.out.println("select login method");
        System.out.println("1.ticket number login");
        System.out.println("2.ID number login");
        System.out.println("3.ID card scanning login");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        switch (str) {
            case "1":
                ticket = ticketLogin();
                if (ticket.getFlightNum() == null) {
                    System.out.println("wrong number");
                    System.exit(0);
                }
                user = Check.IDCheck(ticket.getUserID());
                break;
            case "2":
                user = IDLogin();
                if (user.getSurname() == null) {
                    System.out.println("wrong number");
                    System.exit(0);
                }
                ticket = Check.ticketForUser(user.getID());
                break;
            case "3":
                user = scanLogin();
                if (user.getSurname() == null) {
                    System.out.println("wrong number");
                    System.exit(0);
                }
                ticket = Check.ticketForUser(user.getID());
                break;
            default:
                System.out.println("Invalid input");
                System.exit(1);
        }
        show();

    }

    private Ticket ticketLogin() {
        System.out.println("please input your ticket number");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        return Check.reservationCheck(str);
    }

    private User IDLogin() {
        System.out.println("please input your ID number");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        return Check.IDCheck(str);
    }

    private User scanLogin() {
        System.out.println("please scan/input your ID card");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        return Check.IDCheck(str);
    }

    private void show() {
        System.out.println("your user num is " + user.getID());
        System.out.println("your given name is " + user.getGivenName());
        System.out.println("your surname is " + user.getSurname());
        System.out.println("your reservation number is " + ticket.getReservationNum());
        System.out.println("your flight number is " + ticket.getFlightNum());
        System.out.println("your seat is " + ticket.getSeat());
        System.out.println("your service is " + ticket.getService());

    }

}
