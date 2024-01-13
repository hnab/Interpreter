/**
 * Filename: TurnExpression.java
 * Expression object for Turn operation
 *      - public methods:
 *          . Object evaluate(Context context)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Expression;
import Context.Context;

public class TurnExpression implements Expression{
    //Argument to turn can be either a constant or a variable
    private int degrees;
    private Expression expression;

    public TurnExpression(Expression expression){
        this.expression = expression;
    }
    @Override
    public Object evaluate(Context context) {
        //Evaluating the Expression and Getting the degree
        Object o = expression.evaluate(context);
        int angle = Math.round((float) o);
        context.getTurtle().turn(angle);
        return angle;
    }
}
