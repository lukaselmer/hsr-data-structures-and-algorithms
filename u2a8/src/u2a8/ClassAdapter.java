package u2a8;

import java.util.Vector;

public class ClassAdapter extends Vector<Bike> implements BikeStoreInterface {

    private static final long serialVersionUID = -1294325841802218964L;

    @Override
    public void addBike(Bike b) {
        add(b);
    }

    @Override
    public Bike removeBike(int i) {
        return remove(i);
    }
}
