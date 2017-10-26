package sample;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Htmlinator {

    public static void output(DataStore s) {

        try {
            Scanner sc = new Scanner(new File("output.html"));

            StringBuilder output = new StringBuilder();
            while (sc.hasNextLine()) output.append(sc.nextLine());

            for (Table t : s.tables) {
                String newOut = output.toString();
                newOut = newOut.replace("%header", t.getHeader());

                String cols = "";
                for (String col : t.getColumns()) {
                    cols += "<th>" + col + "</th>\n";
                }

                newOut = newOut.replace("%columns", cols);

                String names = "";
                for (String n : t.getNames()) {
                    names += "<tr><td>" + n + "</td>\n</tr>";
                }

                newOut = newOut.replace("%names", names);

                //output it
                try {
                    PrintWriter writer = new PrintWriter(t.getHeader() + ".html");
                    writer.print(newOut);
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
