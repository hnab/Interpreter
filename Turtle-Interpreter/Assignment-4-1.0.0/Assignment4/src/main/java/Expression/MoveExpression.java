/**
 * Filename: MoveExpression.java
 * Expression object for the Move operation
 *      - public methods:
 *          . Object evaluate(Context context)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */

package Expression;

import Context.Context;

public class MoveExpression implements Expression{

    private Expression expression;
    public MoveExpression(Expression expression){
        this.expression = expression;
    }
    @Override
    public Object evaluate(Context context) {
        Object distance = expression.evaluate(context);
        int d = Math.round((float) distance);
        context.getTurtle().move(d);
        return distance;
    }
}
