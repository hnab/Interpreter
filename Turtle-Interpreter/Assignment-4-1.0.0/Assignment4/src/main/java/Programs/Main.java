/**
 * Filename: Demo.java
 * Reads a Turtle program from a file, parses each line and evaluates the turtle
 * commands
 *      - public methods:
 *          . static void runProgram(String fileName)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */

package Programs;
import Context.Context;
import Expression.Expression;
import Models.Turtle;
import Parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    public static void runProgram(String fileName){
        System.out.println("*******running "+fileName+"*******");

        Turtle turtle = new Turtle();
        Context context = new Context(turtle);

        String filePath = new File(fileName).getAbsolutePath();

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith("Repeat ")) {
                    String repeatCommand = line+"\n";

                    line = scanner.nextLine();
                    boolean hashNext = scanner.hasNextLine();
                    while (scanner.hasNextLine() && line.startsWith("\t")) {
                        hashNext = scanner.hasNextLine();
                        repeatCommand += line+"\n";
                        line = scanner.nextLine();
                    }

                    if(line.startsWith("End")){
                        repeatCommand += line+"\n";
                        Expression expression = Parser.parseLine(repeatCommand);
                        expression.evaluate(context);
                    }
                }
                else{
                    Expression expression = Parser.parseLine(line+"\n");
                    expression.evaluate(context);
                }
            }
            System.out.println("Turtle final location is "+turtle.location());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        runProgram("program1.txt");
        runProgram("program2.txt");
    }
}
