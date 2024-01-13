import Models.Point;
import Models.Turtle;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TurtleTest {

    Turtle turtle = new Turtle();


    @Test
    public void testMove() {
        turtle.move(5);
        assertEquals(turtle.location().getX(),5);
        assertEquals(turtle.location().getY(),0);
    }

    @Test
    public void testTurnPositive() {
        turtle.turn(90);
        assertEquals(turtle.direction(),90, 0.001);
    }

    @Test
    public void testTurnNegative() {
        turtle.turn(-270);
        assertEquals(turtle.direction(),90, 0.001);
    }

    @Test
    public void testTurnOver360() {
        turtle.turn(440);
        assertEquals(turtle.direction(),80, 0.001);
    }

    @Test
    public void testTurnLessThanMinus360() {
        turtle.turn(-440);
        assertEquals(turtle.direction(),280, 0.001);
    }

    @Test
    public void testDistanceTo() {
        float distance = turtle.distanceTo(new Point(4,3));
        assertEquals(distance,5, 0.001);
    }
    @Test
    public void testBearingTo() {
        float bearing = turtle.bearingTo(new Point(4,4));
        assertEquals(bearing,45, 0.001);
    }

    private void addStudents(){

    }
}

