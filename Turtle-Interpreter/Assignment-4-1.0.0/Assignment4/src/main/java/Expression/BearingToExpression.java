/**
 * Filename: DistanceToExpression.java
 * Expression object for BearingTo Operation
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

public class BearingToExpression implements Expression{
    private Expression expression;

    public BearingToExpression(Expression expression){
        this.expression = expression;
    }
    @Override
    public Object evaluate(Context context) {
        Object o = expression.evaluate(context);
        //Returns the angle in degrees to the point o
        return context.getTurtle().bearingTo((Point) o);
    }
}
