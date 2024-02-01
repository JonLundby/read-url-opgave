package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        // Deklaration af variabler der holder på en url og navnet til txt fil
        String fileName;
        String s;

        // Hvis programmet kaldes uden args så sættes s & filename til hardcoded værdier.
        // Ellers bruges de argumenter som programmet kaldes med fra kommandoprompt
        if (args.length == 0) {
            s = "https://www.eb.dk";
            fileName = "url.txt";
        } else {
            s = args[0];
            fileName = args[1];
        }

        // kalder createURLFile med argumenter
        createURLFile(s, fileName);
    }

    public static void createURLFile(String s, String fileName) {
        try {
            URL url = new URL(s);
            String lineReciever = "";
            BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));

            File myFile = new File("url.txt");
            FileWriter myWriter = new FileWriter(fileName);

            myWriter.write("#################### START ####################\n");
            while (lineReciever != null) {
                if (!lineReciever.isEmpty()) {
                    myWriter.write(lineReciever + "\n");
                }
                lineReciever = input.readLine();

            }
            myWriter.write("#################### END ####################");
            myWriter.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}

