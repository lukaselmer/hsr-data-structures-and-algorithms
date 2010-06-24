package u2a9;

public class VectorImpl implements Vector {

    private MatrixImpl matrix;

    public VectorImpl(int i) {
        matrix = new MatrixImpl(i, 1);
    }

    public int get_size() {
        return matrix.get_sizex() * matrix.get_sizey();
    }

    public double get(int x) {
        if (matrix.get_sizex() == 1) {
            return matrix.get(0, x);
        } else {
            return matrix.get(x, 0);
        }
    }

    public void set(int x, double val) {
        if (matrix.get_sizex() == 1) {
            matrix.set(0, x, val);
        } else {
            matrix.set(x, 0, val);
        }
    }

    public double mult(Vector right) {
        Matrix m = matrix.mult(right.as_matrix());
        return m.get(0, 0);
    }

    public Vector mult(Matrix left) {
        Vector v = new VectorImpl(matrix.get_sizey());
        v.transpose();
        Matrix m = left.mult(matrix);
        for (int i = 0; i < matrix.get_sizey(); i++) {
            v.set(i, m.get(0, i));
        }
        return v;
    }

    public void transpose() {
        matrix.transpose();
    }

    public Matrix as_matrix() {
        return matrix.copy();
    }

    public Vector copy() {
        VectorImpl vec;
        vec = new VectorImpl(get_size());
        if (matrix.get_sizex() == 1) {
            vec.transpose();
        }
        for (int i = 0; i < vec.get_size(); i++) {
            vec.set(i, matrix.get(i, 0));
        }
        return vec;
    }

    public void print() {
        matrix.print();
    }
}
