package sample;

import java.io.PrintWriter;
import java.util.Scanner;

public class Htmlinator {

    public static void output(DataStore s) {

        Scanner sc = new Scanner("/samples/output.html");

        StringBuilder output = new StringBuilder();
        while(sc.hasNextLine()) output.append(sc.nextLine());

        for(Table t : s.tables) {
            String newOut = output.toString();
            newOut = newOut.replaceAll("%header", t.getHeader());

            String cols = "";
            for(String col : t.getColumns()) {
                cols += "<th>" + col + "</th>\n";
            }

            newOut = newOut.replaceAll("%columns", cols);

            String names = "<tr>";
            for(String n : t.getNames()) {
                names += "<td>" + n + "</td>\n";
            }
            names += "</tr>";

            newOut = newOut.replaceAll("%names", names);

            //output it
            try {
                PrintWriter writer = new PrintWriter(t.getHeader() + ".html");
                writer.print(newOut);
                writer.close();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
