/**
 * Filename: PointExpression.java
 * Expression object for Constant
 *      - public methods:
 *          . Object evaluate(Context context)
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Expression;
import Context.Context;

public class ConstantExpression implements Expression{
    private float value;

    public ConstantExpression(float value) {
        this.value = value;
    }
    @Override
    public Object evaluate(Context context) {
        return this.value;
    }
}
