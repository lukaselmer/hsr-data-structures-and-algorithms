package u2a8;

import java.util.Vector;

public class ObjAdapter extends AbstractBikeStore {

    Vector<Bike> bikes = new Vector<Bike>();

    @Override
    public void addBike(Bike b) {
        bikes.add(b);
    }

    @Override
    public Bike removeBike(int i) {
        return bikes.remove(i);
    }

    @Override
    public void clear() {
        bikes.clear();
    }

    @Override
    public int size() {
        return bikes.size();
    }
}
