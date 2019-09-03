package tests;


import tableFun.Pair;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import tableFun.TableFunction;


public class TableFunctionTests {

    @Test
    public void pairEqualsTest() {
        assertEquals(new Pair(1, 2), new Pair(1, 2));
        assertNotEquals(new Pair(10, 245), new Pair(10, 246));
        assertNotEquals(new Pair(1.0, 1.0), new Pair(1, 1));
        assertNotEquals(new Pair(1, 1), 11);
    }

    @Test
    public void getPairTest() {
        assertEquals(new Pair(1.0, 2.0), new TableFunction(1, 2).getPair(0));
    }

    @Test
    public void tableTest() {
        assertEquals( "1.0, 2.0" + "\n" + "3.0, 4.0", new TableFunction(1.0, 2.0, 3.0, 4.0).toString());
        assertNotEquals(null, new TableFunction());
        assertEquals(new TableFunction(1.0, 2.0), new TableFunction(1.0, 2.0));
        assertNotEquals(new TableFunction(1.0, 2.0, 3.0, 4.0), new TableFunction(1, 2, 3, 4));
    }

    public TableFunction putTest() {
    TableFunction array = new TableFunction(3.0, 4.0);
    array.put(1.0, 2.0);
    return array;
    }

    @Test
    public void put() {
        assertEquals(new TableFunction(3.0, 4.0, 1.0, 2.0), putTest());
    }

    public TableFunction removeTest() {
        TableFunction array = new TableFunction(1.0, 2.0, 3.0, 4.0);
        array.remove(1.0);
        return array;
    }
    public TableFunction removeTest2() {
        TableFunction array = new TableFunction(1.0, 2.0);
        array.remove(1.0);
        return array;
    }

    @Test
    public void remove() {
        assertEquals(new TableFunction(), removeTest2());
        assertEquals(new TableFunction(3.0, 4.0), removeTest());
    }

    public String toStringTester() {
        TableFunction array = new TableFunction(1.0, 2.0);
        String ans = array.toString();
        return ans;
    }
    @Test
    public void tableToStringTest() {
        assertEquals("1.0, 2.0", toStringTester());
        assertEquals("2.4, 135.74" + "\n20.0, 29.1", new TableFunction(2.4, 135.74, 20.0, 29.1).toString());
    }

    public Pair searchNearestTest() {
        TableFunction array = new TableFunction(1.0, 2.0, 4.0, 5.0);
        return array.searchNearest(2.0);
    }

    @Test
    public void searchNearest() {
        assertEquals(new Pair(1.0, 2.0), searchNearestTest());
    }

    public double interpTest() {
        TableFunction array = new TableFunction(1.0, 2.0, 2.0, 4.0, 3.0, 6.0);
        return array.interp(4.0);
    }

    @Test
    public void interp() {
        assertEquals(8.0, interpTest(), 0.01);

    }

    @Test
    public void pairToStringTest() {
        assertEquals(new Pair<>(2, 4).toString(), "2, 4");
        assertEquals(new Pair<>(2.4, 81.196).toString(), "2.4, 81.196");
    }

}
