import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import components.*;
public class Main {

    public static void main(String[] args) {
        try {
            // Check if the user provided any arguments
            Interpreter interpreter = new Interpreter();
            if (args.length > 0) {


                // Check for the --help argument
                if (args[0].equals("--help")) {
                    // Display the help menu
                    showHelp();
                }

                else {
                    // Proceed with interpreting the provided file
                    String filePath = args[0];
                    String source = new String(Files.readAllBytes(Paths.get(filePath)));
                    vg_langLexer lexer = new vg_langLexer(CharStreams.fromString(source));
                    CommonTokenStream tokens = new CommonTokenStream(lexer);
                    vg_langParser parser = new vg_langParser(tokens);


                    interpreter.visit(parser.program());

                }
            } else {
                System.out.println("Error: No arguments provided. Use --help for more information.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    // Method to display the help menu
    private static void showHelp() {
        System.out.println("Usage: vg lang  <file.vg> [options]");
        System.out.println("Options:");
        System.out.println("  --help          Show this help menu");
        System.out.println("  <file.vg>  The vg source file to interpret");

    }


}