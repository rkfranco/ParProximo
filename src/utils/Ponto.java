package utils;

public class Ponto implements Comparable<Ponto> {
    private double x;

    private double y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Utils.Ponto{" + "x=" + x + ", y=" + y + '}';
    }

    @Override
    public int compareTo(Ponto o) {
        if (this.getX() == o.getX()) return 0;
        if (this.getX() > o.getX()) return 1;
        return -1;
    }
}
