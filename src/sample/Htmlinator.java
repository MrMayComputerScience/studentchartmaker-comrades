package sample;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Htmlinator {

    public static void output(DataStore s) {

        try {
            Scanner sc = new Scanner("<!DOCTYPE html> <html> <head> <title>%header</title> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"> </head> <body style=\"width:90%;margin:auto\"> <div class=\"page-header\"> <h1>%header</h1> </div> <table style=\"width:100%\" class=\"table table-bordered\"> <tr> %columns </tr> %names </table> </body> </html>");

            StringBuilder output = new StringBuilder();
            while (sc.hasNextLine()) output.append(sc.nextLine());

            for (Table t : s.tables) {
                String newOut = output.toString();
                newOut = newOut.replace("%header", t.getHeader());

                String cols = "<th></th>";
                String rows = "";
                for (String col : t.getColumns()) {
                    cols += "<th>" + col + "</th>\n";
                    rows += "<td></td>";
                }

                newOut = newOut.replace("%columns", cols);

                String names = "";
                for (String n : t.getNames()) {
                    names += "<tr><td>" + n + "</td>" + rows + "\n</tr>";
                }

                newOut = newOut.replace("%names", names); 

                //output it
                try {
                    PrintWriter writer = new PrintWriter(t.getHeader().replace(" ", "") + ".html");
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
