package Boundary;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetData {
    public static String[][] UserRead() {
        String filePath = "src/Resource/User.csv";
        List<String> uList = new ArrayList<String>();
        int b = 0;
        try {
            CsvReader csvReader = new CsvReader(filePath);
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                uList.add(csvReader.get(0));
                uList.add(csvReader.get(1));
                uList.add(csvReader.get(2));
                System.out.println(csvReader.get("mobile"));
                b++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] UserList = new String[b][3];
        int a = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 3; j++) {
                UserList[i][j] = uList.get(a);
                a++;
            }
        }
        return UserList;
    }

    public static String[][] FlightRead() {
        String filePath = "src/Resource/Flight.csv";
        List<String> FList = new ArrayList<String>();
        int b = 0;
        try {
            CsvReader csvReader = new CsvReader(filePath);
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                FList.add(csvReader.get(0));
                FList.add(csvReader.get(1));
                FList.add(csvReader.get(2));
                FList.add(csvReader.get(3));
                FList.add(csvReader.get(4));
                System.out.println(csvReader.get("mobile"));
                b++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] FlightList = new String[b][5];
        int a = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 5; j++) {
                FlightList[i][j] = FList.get(a);
                a++;
            }
        }
        return FlightList;
    }

    public static String[][] TicketRead() {
        String filePath = "src/Resource/Ticket.csv";
        List<String> TList = new ArrayList<String>();
        int b = 0;
        try {
            CsvReader csvReader = new CsvReader(filePath);
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                TList.add(csvReader.get(0));
                TList.add(csvReader.get(1));
                TList.add(csvReader.get(2));
                TList.add(csvReader.get(3));
                TList.add(csvReader.get(4));
                TList.add(csvReader.get(5));
                TList.add(csvReader.get(6));
                TList.add(csvReader.get(7));
//                TList.add(csvReader.get(5));
                System.out.println(csvReader.get("mobile"));
                b++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] TicketList = new String[b][8];
        int a = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 8; j++) {
                TicketList[i][j] = TList.get(a);
                a++;
            }
        }
        return TicketList;
    }

    public static void Read() {
        UserRead();
        FlightRead();
        TicketRead();
    }


    public static void main(String a[]) {
    }
}