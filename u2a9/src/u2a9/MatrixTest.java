package u2a9;

public class MatrixTest {

    static public void main(String argv[]) {
        System.out.println("Matrix:");
        Matrix m = new MatrixImpl(2, 2);
        m.set(0, 0, 1);
        m.set(0, 1, 2);
        m.set(1, 0, 3);
        m.set(1, 1, 4);
        m.print();
        System.out.println("Vector:");
        Vector v = new VectorImpl(2);
        v.set(0, 1);
        v.set(1, 2);
        v.print();
        System.out.println("Matrix transposed:");
        Matrix m2 = m.copy();
        m2.transpose();
        m2.print();
        System.out.println("Vector transposed:");
        Vector v2 = v.copy();
        v2.transpose();
        v2.print();
        System.out.println("Matrix multiplied:");
        m2 = m.mult(m); // = m*m
        m2.print();
        System.out.println("Vector multiplied:");
        double i = v.mult(v2); // = v*v2
        System.out.println(i);
        System.out.println("Matrix times Vector:");
        v2 = v2.mult(m); // = m*v2
        v2.print();
    }
}

/* Session-Log: 

Matrix:
[ 1.0 3.0 ]
[ 2.0 4.0 ]
Vector:
[ 1.0 2.0 ]
Matrix transposed:
[ 1.0 2.0 ]
[ 3.0 4.0 ]
Vector transposed:
[ 1.0 ]
[ 2.0 ]
Matrix multiplied:
[ 7.0 15.0 ]
[ 10.0 22.0 ]
Vector multiplied:
5.0
Matrix times Vector:
[ 7.0 ]
[ 10.0 ]

 */

