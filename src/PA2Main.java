import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class PA2Main {
    public static void main(String[] args) {
        Scanner input = null;
        try {
            input = new Scanner(new File(args[0]));
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        String skipfirstline = input.nextLine();
        if (args[1].equals("MAX")) {
            printmax(input);
        } else if (args[1].equals("LIMIT")) {
            Integer maxvalue = Integer.parseInt(args[2]);
            HashMap<String,Integer> maxdata = printlimit(input);
            List<String> airports = new ArrayList<String>(maxdata.keySet());
            for (String airport : airports) {
                if (maxdata.get(airport) > maxvalue) {
                    System.out.println(airport + " - " + maxdata.get(airport));
                }
            }
        } else if (args[1].equals("DEPARTURES")) {
            printdepart(input);
        }
    }

    public static void printmax(Scanner input) {

        HashMap<String, Integer> maxdata = new HashMap<String, Integer>();
        ArrayList<String> airports = new ArrayList<String>();
        while (input.hasNextLine()) {
            String[] line = input.nextLine().split(",");
            airports.add(line[2]);
            airports.add(line[4]);
        }
        for (String airport : airports) {
            if (maxdata.get(airport) != null) {
                maxdata.put(airport, maxdata.get(airport) + 1);
            } else {
                maxdata.put(airport, 1);
            }
        }
        String maxkey = Collections
                .max(maxdata.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out
                .println("MAX FLIGHTS " + maxdata.get(maxkey) + " : " + maxkey);
    }

    public static HashMap<String, Integer> printlimit(Scanner input) {
        HashMap<String, Integer> maxdata = new HashMap<String, Integer>();
        List<String> airports = new ArrayList<String>();
        while (input.hasNextLine()) {
            String[] line = input.nextLine().split(",");
            airports.add(line[2]);
            airports.add(line[4]);
        }
        for (String airport : airports) {
            if (maxdata.get(airport) != null) {
                maxdata.put(airport, maxdata.get(airport) + 1);
            } else {
                maxdata.put(airport, 1);
            }
        }
        return maxdata;
    }

    public static void printdepart(Scanner input) {
        HashMap<String, ArrayList> departdata = new HashMap<String, ArrayList>();

        while (input.hasNextLine()) {
            String[] line = input.nextLine().split(",");
            String destinate = line[4];
            if (departdata.get(line[2]) != null) {
                departdata.get(line[2]).add(destinate);

            } else {
                ArrayList<String> destination = new ArrayList<String>();
                destination.add(destinate);
                departdata.put(line[2], destination);
                ;
            }
        }
        ArrayList<String> airport = new ArrayList<String>(departdata.keySet());
        Collections.sort(airport);
        for (String airports : airport) {
            System.out
                    .println(airports + " flys to " + departdata.get(airports));
        }
    }
}

