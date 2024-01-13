/**
 * Demo class for running Turtle programs by hardcoding expressions
 */
package Programs;

import Context.Context;
import Expression.*;
import Models.Point;
import Models.Turtle;

import java.util.ArrayList;

public class TurtlePrograms {
    public static void main(String[] args){
        System.out.println("*****************Program 2**********************");
//        Move 10
//        Turn 90
//        Move 20
//        Turn -60
//        Move 15

        Turtle turtle = new Turtle();
        Context context = new Context(turtle);

        //Move 10
//        Expression constantExpression =  new ConstantExpression(10);
        Expression moveExpression  = new MoveExpression(
                new ConstantExpression(10));
        moveExpression.evaluate(context);

        //Turn 90
        Expression turnExpression  = new TurnExpression(
                new ConstantExpression(90));
        turnExpression.evaluate(context);

        //Move 20
        Expression moveExpression2  = new MoveExpression(
                new ConstantExpression(20));
        moveExpression2.evaluate(context);

        //Turn -60
        Expression turnExpression2  = new TurnExpression(
                new ConstantExpression(-60));
        turnExpression2.evaluate(context);

        //Move 15
        Expression moveExpression3  = new MoveExpression(
                new ConstantExpression(15));
        moveExpression3.evaluate(context);

        System.out.println("Turtle final location: " + turtle.location() );

        System.out.println("*****************Program 1**********************");
//        #Ps = 10,10
//        #Pt = 10,20
//        #d = distanceTo #s
//        #a = bearingTo #s
//        Turn  #a
//        Move #d
//        #u = bearingTo #t
//        Move 5
//        Turn 90
//        Move 5
//        Repeat 4
//            Turn 90
//            Move 10
//        End

        Turtle turtle1 = new Turtle();
        Context context1 = new Context(turtle1);

        // #Ps = 10,10
        Expression assignmentExpression = new AssignmentExpression(
                new VariableExpression("s"), new PointExpression(new Point(10,10)));
        assignmentExpression.evaluate(context1);

        //#Pt = 10,20
        Expression assignmentExpression1 = new AssignmentExpression(
                new VariableExpression("t"), new PointExpression(new Point(10,20)));
        assignmentExpression1.evaluate(context1);

        //#d = distanceTo #s
        Expression assignmentExpression2 = new AssignmentExpression(
                new VariableExpression("d"),new DistanceToExpression(
                        new VariableExpression("s")));
        assignmentExpression2.evaluate(context1);

        //#a = bearingTo #s
        Expression assignmentExpression3 = new AssignmentExpression(
                new VariableExpression("a"),new BearingToExpression(
                new VariableExpression("s")));
        assignmentExpression3.evaluate(context1);

        //Turn  #a
        Expression turnExpression3 =  new TurnExpression(new VariableExpression("a"));
        turnExpression3.evaluate(context1);

        //Move #d
        Expression moveExpression4 =  new MoveExpression(new VariableExpression("d"));
        moveExpression4.evaluate(context1);

        //#u = bearingTo #t
        Expression assignmentExpression4 = new AssignmentExpression(
                new VariableExpression("u"),new BearingToExpression(
                new VariableExpression("t")));
        assignmentExpression4.evaluate(context1);

        //Move 5
        Expression moveExpression5 = new MoveExpression(
                new ConstantExpression(5));
        moveExpression5.evaluate(context1);

        //Turn 90
        Expression turnExpression4 = new TurnExpression(
                new ConstantExpression(90));
        turnExpression4.evaluate(context1);

        //Move 5
        Expression moveExpression6 = new MoveExpression(
                new ConstantExpression(5));
        moveExpression6.evaluate(context1);

        //Repeat 4
        //  Turn 90
        //  Move 10
        //End
        Expression turnNinety = new TurnExpression(
                new ConstantExpression(90));
        Expression moveTen = new MoveExpression(
                new ConstantExpression(10));
        ArrayList<Expression> nested = new ArrayList<>();
        nested.add(turnNinety);
        nested.add(moveTen);
        Expression repeatExpression =  new RepeatExpression(4, nested );
        repeatExpression.evaluate(context1);
        System.out.println("Turtle final location: " + turtle1.location() );


    }
}
