/**
 * Filename: DistanceToExpression.java
 * Expression object for DistanceTo Operation
 *      - public methods:
 *          . Object evaluate(Context context)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Expression;

import Context.Context;
import Models.Point;

public class DistanceToExpression implements Expression{
    private Expression expression;

    public DistanceToExpression(Expression expression){
        this.expression = expression;
    }
    @Override
    public Object evaluate(Context context) {
        Object o = expression.evaluate(context);
        Point point = (Point) o;
        //Distance of the turtle to the given point
        float distance = context.getTurtle().distanceTo(point);
        return distance;
    }
}
