package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputReader {

    public static String getHeader(String folder) {
        try {
        Scanner s = new Scanner(new File(folder + "\\header.txt"));
        return s.nextLine().trim();
        }
            catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getColumns(String folder) {
        try {
        Scanner s = new Scanner(new File(folder + "\\columns.txt"));
        List<String> list = new ArrayList<>();
        while(s.hasNextLine()) {
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
            catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] getNames(String folder) {
        try {
            Scanner s = new Scanner(new File(folder + "\\names.txt"));
            List<String> list = new ArrayList<>();
            while (s.hasNextLine()) {
                String line = s.nextLine();
                line = line.trim();
                if (!line.equals("")) {
                    list.add(line);
                    System.out.println(line);
                }
            }
            return list.toArray(new String[list.size()]);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
