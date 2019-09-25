package tableFun;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static java.lang.Math.abs;

public final class TableFunction {

    private Pair[] array;

    public TableFunction(double... arg) {
        if (arg.length % 2 != 0) throw new IllegalArgumentException();
        else {
            array = new Pair[arg.length / 2];
            int count = 0;
            for (int i = 0; i < arg.length; i += 2) {
                array[count] = new Pair(arg[i], arg[i + 1]);
                count++;
            }
        }
    }

    private void ensureCapacity(int minCapacity) { //to grow the list dynamically as we put stuff inside
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) array = Arrays.copyOf(array, minCapacity);
    }

    public void put(double x, double y) {
        boolean unique = true;
        for (int i = 0; i < array.length; i++)
            if (array[i].getX() == x) {
                unique = false;
                break;
            }
        if (unique) {
            ensureCapacity(array.length + 1);
            array[array.length - 1] = new Pair(x, y);
        }
    }

    public void remove(double x) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getX() == x) {
                array[i] = null;
                index = i;
                break;
            }
        }
        for (int n = index; n < array.length - 1; n++) {
            array[n] = array[n + 1];
            array = Arrays.copyOf(array, array.length - 1);
        }
    }

    @Override
    public String toString() {
        if (array.length == 0) return null;
        else {
            String arse = array[0].toString();
            for (int i = 1; i < array.length; i++) arse += "\n" + array[i].toString();
            return arse;
        }
    }

    public Pair searchNearest(double x0) {
        Pair ans = array[0];
        double minDist = abs(x0 - array[0].getX());
        for (int i = 0; i < array.length; i++) {
            if (minDist > abs(x0 - array[i].getX())) {
                minDist = abs(x0 - array[i].getX());
                ans = array[i];
            }
        }
        return ans;
    }

    public double interp(double x) {
        ArrayList<Double> polynomial = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            double l = 1.0;
            for (int j = 0; j < array.length; j++)
                if (j != i) {
                    l *= (x - array[j].getX()) / (array[i].getX() - array[j].getX());
                }
            polynomial.add(l);
        }
        double y = 0.0;
        for (int i = 0; i < array.length; i++) {
            y += array[i].getY() * polynomial.get(i);
        }
        return y;
    }

    public Pair getPair(int pos) {
        return array[pos];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        else if (obj == null || obj.getClass() != this.getClass()) return false;
        TableFunction objTableFun = (TableFunction) obj;
        boolean proof = true;
        for (int i = 0; i < array.length; i++) {
            if (!getPair(i).equals(objTableFun.getPair(i))) proof = false;
        }
        return proof;
    }

    @Override
    public int hashCode() {
        return Objects.hash(array.length, array[0].getX(), array[0].getY());
    }
}