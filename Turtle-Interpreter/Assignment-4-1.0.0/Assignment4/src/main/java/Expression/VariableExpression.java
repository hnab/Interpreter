/**
 * Filename: VariableExpression.java
 * Expression object for Variable
 *      - public methods:
 *          . Object evaluate(Context context)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Expression;
import Context.Context;

public class VariableExpression implements Expression{

    private String name;

    public VariableExpression(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public Object evaluate(Context context) {
        return  context.getValue(name);
    }
}
