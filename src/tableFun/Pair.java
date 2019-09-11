package tableFun;

import java.util.Objects;

public class Pair {
    private Double x;
    private Double y;

    public Pair(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    public void setX(double x) { this.x = x; }

    public void setY(double y) { this.y = y; }

    public String toString() { return x + ", " + y; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        else if (obj == null || obj.getClass() != this.getClass()) return false;
        Pair objPair = (Pair) obj;
        return (getX() == objPair.getX() && getY() == objPair.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}

