/**
 * Filename: Parser.java
 * Class for parsing each program line
 *      - public methods:
 *          . static Expression parseLine(String line)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Parser;

import Expression.*;
import Models.Point;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    /**
     * Parses the line using regex and returns an expression
     *
     * @param line A string representing command or Expression
     * @return Expression object representing the command
     */
    public static Expression parseLine(String line){
        Pattern variablePattern = Pattern.compile("#P*([a-z])\\s*");
        Pattern assignmentPattern = Pattern.compile("(#P*[a-z])\\s*=\\s*(.+)\n");
        Pattern constantPattern = Pattern.compile("(-?\\d+)\\s*");
        Pattern pointPattern = Pattern.compile("(\\d+),(\\d+)\\s*");
        Pattern repeatPattern = Pattern.compile("Repeat\\s+(.*)\\s*\n((?:\t.*\n)*)End\\s*\n");
        Pattern movePattern = Pattern.compile("Move\\s+(.+)\n");
        Pattern turnPattern = Pattern.compile("Turn\\s+(.+)\n");
        Pattern distanceToPattern =  Pattern.compile("distanceTo\\s+(.+)");
        Pattern bearingToPattern =  Pattern.compile("bearingTo\\s+(.+)");



        Matcher matcher;
        if ((matcher = repeatPattern.matcher(line)).matches()) {
            int k = Integer.parseInt(matcher.group(1));
            ArrayList<Expression> expressions = new ArrayList<>();
            String exp = matcher.group(2);
            String[] commands = exp.split("\n");
            for(String command: commands){

                Expression expression = Parser.parseLine(command.substring(1)+"\n");
                expressions.add(expression);
            }
            Expression expression = parseLine(exp);
            Expression repeatExpression = new RepeatExpression(k,expressions);
            return repeatExpression;
        }
        else if ((matcher = bearingToPattern.matcher(line)).matches()) {
            String exp = matcher.group(1);
            Expression expression = parseLine(exp);
            Expression bearingToExpression = new BearingToExpression(expression);
            return bearingToExpression;
        }
        if ((matcher = distanceToPattern.matcher(line)).matches()) {
            String exp = matcher.group(1);
            Expression expression = parseLine(exp);
            Expression disToExpression = new DistanceToExpression(expression);
            return disToExpression;
        }
        else if ((matcher = assignmentPattern.matcher(line)).matches()) {
            String lhs = matcher.group(1);
            String rhs = matcher.group(2);

            Expression rExpression = parseLine(rhs);
            Expression lExpression = parseLine(lhs);
            VariableExpression leftHandSide = (VariableExpression) lExpression;
            Expression assignmentExpression = new AssignmentExpression(
                    leftHandSide, rExpression);

            return assignmentExpression;
        }
        else if ((matcher = constantPattern.matcher(line)).matches()) {
            int constant = Integer.parseInt(matcher.group(1));
            Expression constantExpression = new ConstantExpression(constant);
            return constantExpression;
        }

        else if ((matcher = variablePattern.matcher(line)).matches()) {
            String varName = matcher.group(1);

            Expression variableExpression = new VariableExpression(varName);

            return variableExpression;

        }
        else if ((matcher = pointPattern.matcher(line)).matches()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));

            Point point = new Point(x,y);
            Expression pointExpression = new PointExpression(point);
            return pointExpression;
        }

        else if ((matcher = movePattern.matcher(line)).matches()) {
            String exp = matcher.group(1);
            Expression expression = parseLine(exp);
            Expression moveExpression = new MoveExpression(expression);
            return moveExpression;

        }
        else if ((matcher = turnPattern.matcher(line)).matches()) {
            String exp = matcher.group(1);

            Expression expression = parseLine(exp);
            Expression turnExpression = new TurnExpression(expression);
            return turnExpression;

        }
        return null;
    }
}
