/**
 * Filename: Context.java
 * A Context object to store and retrieve variables that Turtle uses
 *      - public methods:
 *          . Object getValue( String variableName )
 *          . Object setValue( String variableName )
 * Authors:
 *     Hatef Nabili <hnabili5386@sdsu.edu>
 *     Arman Shahriari <ashahriari9557@sdsu.edu>
 *     Parisa Zaeri <pzaeri5885@sdsu.edu>
 */
package Context;

import Models.Turtle;

import java.util.HashMap;
public class Context {
    private Turtle turtle;

    public Context(Turtle turtle){
        this.turtle = turtle;
    }
    HashMap<String,Object> values = new HashMap<>();
    public Object getValue( String variableName ) {
        return values.get( variableName );
    }
    public void setValue( String variableName, Object value ) {
        values.put( variableName, value ) ;
    }

    public Turtle getTurtle() {
        return turtle;
    }
}
