/**
 * Filename: Expression.java
 * Interface for Expression objects
 *      - public methods:
 *          . Object evaluate(Context context);
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Expression;

import Context.Context;

public interface Expression {
    /**
     * Since we can have variables of two types the method returns object that
     * can be cast to the target type
     *
     * @param context Context object carrying the state of the turtle(variables)
     * @return
     */
    Object evaluate(Context context);
}
