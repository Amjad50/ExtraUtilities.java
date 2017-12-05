package ExtraUtilities;

public class OutStream {

    /**
     * allows multiple printing using one statement.
     *
     * @param items <code>Objects</code> to be printed.
     *
     */
    public static void  print ( Object ... items ){
        for (Object item : items) {
            System.out.print(item + " ");
        }
    }

    /**
     * allows multiple printing using one statement<br>
     * and printing new line in the end.
     *
     * @param items <code>Objects</code> to be printed.
     *    */
    public static void  println ( Object ... items ){
        for (Object item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}
