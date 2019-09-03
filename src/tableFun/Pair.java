package tableFun;

import java.util.Objects;

public class Pair<X, Y> {
    private X x;
    private Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() { return x; }

    public Y getY() { return y; }

    public void setX(X x) { this.x = x; }

    public void setY(Y y) { this.y = y; }

    public String toString() { return x + ", " + y; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        else if (obj == null || obj.getClass() != this.getClass()) return false;
        Pair objPair = (Pair) obj;
        return getX() == objPair.getX() && getY() == objPair.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}

