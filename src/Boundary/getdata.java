package Boundary;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getdata {
    public static String[][] UserRead() {
        String filePath = "src/Resource/User.csv";
        List<String> UList = new ArrayList<String>();
        int b = 0;
        try {
            CsvReader csvReader = new CsvReader(filePath);
            csvReader.readHeaders();
            while (csvReader.readRecord()) {
                UList.add(csvReader.get(0));
                UList.add(csvReader.get(1));
                UList.add(csvReader.get(2));
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
                UserList[i][j] = UList.get(a);
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
//                TList.add(csvReader.get(5));
                System.out.println(csvReader.get("mobile"));
                b++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] TicketList = new String[b][5];
        int a = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 5; j++) {
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
        Read();
    }
}
