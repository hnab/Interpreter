/**
 * Filename: AssignmentExpression.java
 * Expression object for assignment operation
 *      - public methods:
 *          . Object evaluate(Context context)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Expression;

import Context.Context;

public class AssignmentExpression implements Expression{

    //Left hand side is always going to be a variable
    private VariableExpression lhs;
    private Expression rhs;

    public AssignmentExpression(VariableExpression lhs, Expression rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }
    @Override
    public Object evaluate(Context context) {

        //Get the name of the variable on left hand side
        String varName = lhs.getName();

        //Evaluate the right hand side
        Object r = rhs.evaluate(context);

        //Set the value of the variable in the context
        context.setValue( varName, r);
        return null;
    }
}
