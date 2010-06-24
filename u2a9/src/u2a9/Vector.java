/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2009-12-03 13:59:02 +0100 (Do, 03 Dez 2009) $
 */
package u2a9;

public interface Vector {

    int get_size();

    double get(int x);

    void set(int x, double val);

    double mult(Vector right);

    Vector mult(Matrix left);

    void transpose();

    Matrix as_matrix();

    Vector copy();

    void print();
}
