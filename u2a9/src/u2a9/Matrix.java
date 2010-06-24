/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2009-12-03 13:59:02 +0100 (Do, 03 Dez 2009) $
 */
package u2a9;

public interface Matrix {

    int get_sizex();

    int get_sizey();

    double get(int x, int y);

    void set(int x, int y, double val);

    void transpose();

    Matrix mult(Matrix right);

    Matrix copy();

    void print();
}
