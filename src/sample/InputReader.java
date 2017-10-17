package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputReader {

    public static String getHeader(String folder) {
        Scanner s = new Scanner(folder + "/header.txt");
        return s.nextLine().trim();
    }

    public static String[] getColumns(String folder) {
        Scanner s = new Scanner(folder + "/columns.txt");
        List<String> list = new ArrayList<>();
        while(s.hasNext()) {
            String line = s.nextLine();
            line = line.trim();
            if(!line.equals("")) {
                list.add(line);
            }
        }
        if(list.size() == 1) {
            int i = -1;
            try {
                i = Integer.parseInt(list.get(0).trim());
            } catch(Exception e) { }

            if(i > -1) {
                return new String[i];
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static String[] getNames(String folder) {
        Scanner s = new Scanner(folder + "/names.txt");
        List<String> list = new ArrayList<>();
        while(s.hasNext()) {
            String line = s.nextLine();
            line = line.trim();
            if(!line.equals("")) {
                list.add(line);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
