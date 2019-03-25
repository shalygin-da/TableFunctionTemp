package tableFunction;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

public final class TableFunction {

    private Pair<Double, Double>[] array;

    public TableFunction(Double ... arg) {
        if (arg.length % 2 != 0) throw new IllegalArgumentException();
        else {
            array = new Pair[arg.length / 2];
            int count = 0;
            for (int i = 0; i < arg.length; i += 2) {
                array[count] = new Pair(arg[i], arg[i+1]);
                count++;
            }
        }
    }

    private void ensureCapacity(int minCapacity) { //to grow the list dynamically as we put stuff inside
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) array = Arrays.copyOf(array, minCapacity);
    }
    public void put(Double x, Double y){
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

    public void remove(Double x) {
        if (array.length == 1) {
            if (array[0].getX() == x) array[0] = null;
        }
        else {
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

    public Pair searchNearest(Double x0) {
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
        for (int count = 0; count < array.length; count++) {
            double l = 0.0;
            for (int i = 0; i < array.length && i != count; i++)
                l = l * (x - array[i].getX())/(array[count].getX() - array[i].getX());
            polynomial.add(l);
        }
        double y = 0.0;
        for (int j = 0; j < array.length; j++) {
            y = y + array[j].getY() * polynomial.get(j);
        }
        return y;
    }

}