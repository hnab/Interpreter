/**
 * Filename: RepeatExpression.java
 * Expression object for Repeat operation
 *      - public methods:
 *          . Object evaluate(Context context)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Expression;
import Context.Context;
import java.util.ArrayList;

public class RepeatExpression implements Expression{
    //Number of repeats
    private int value;

    //List of expressions to be repeated
    private ArrayList<Expression> expressions;

    public RepeatExpression(int value, ArrayList<Expression> expressions){
        this.value = value;
        this.expressions = expressions;
    }
    public ArrayList<Expression> getExpressions() {
        return expressions;
    }

    //Evaluating all the expressions value times
    @Override
    public Object evaluate(Context context) {
        for(int i = 0; i < value; i++ ){
            for(Expression expression: expressions){
                Object obj = expression.evaluate(context);
            }
        }
        return null;
    }
}
