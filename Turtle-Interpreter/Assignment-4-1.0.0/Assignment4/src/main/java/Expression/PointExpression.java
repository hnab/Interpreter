/**
 * Filename: PointExpression.java
 * Expression object for Point
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

public class PointExpression implements Expression {
    private Point point;

    public PointExpression(Point point){
        this.point = point;

    }
    @Override
    public Object evaluate(Context context) {
        return this.point;
    }
}
