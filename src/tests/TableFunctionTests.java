package tests;


import tableFunction.Pair;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import tableFunction.TableFunction;


public class TableFunctionTests {

    public TableFunction tableFunctionTest() {
        return new TableFunction(1.0, 2.0, 3.0, 4.0);
    }

    public TableFunction tableFunctionTest2() {
        return new TableFunction(1.0, 5.0, 3.0, 4.0);
    }

    @Test
    public void tableTest() {
        assertEquals(tableFunctionTest2(), tableFunctionTest());
    }

    public TableFunction putTest() {
    TableFunction array = new TableFunction(3, 4);
    array.put(new Pair(1, 2));
    return array;
    }

    @Test
    public void put() {
        assertEquals(new TableFunction(3, 4, 1, 2), putTest());
    }

    public TableFunction removeTest() {
        TableFunction array = new TableFunction(1, 2, 3, 4);
        array.remove(new Pair(1, 2));
        return array;
    }

    @Test
    public void remove() {
        assertEquals(new TableFunction(3, 4), removeTest());
    }

    public String toStringTester() {
        TableFunction array = new TableFunction(1, 2);
        String ans = array.toString();
        return ans;
    }
    @Test
    public void toStringTest() {
        assertEquals("1, 2", toStringTester());
    }

    public Pair searchNearestTest() {
        TableFunction array = new TableFunction(1, 2, 4, 5);
        return array.searchNearest(2);
    }

    @Test
    public void searchNearest() {
        assertEquals(new Pair(1, 2), searchNearestTest());
    }

    public double interpTest() {
        TableFunction array = new TableFunction(1.0, 2.0, 2.0, 4.0, 3.0, 6.0);
        return array.interp(4.0);
    }

    @Test
    public void interp() {
        assertEquals(8.0, interpTest(), 0.01);
    }
}
