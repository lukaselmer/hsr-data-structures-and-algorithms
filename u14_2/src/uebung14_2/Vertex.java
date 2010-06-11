/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung14_2;

/**
 *
 * @author Lukas Elmer
 */
class Vertex {

    private int x, y;
    private byte b;
    private double distance;
    private Vertex parent;

    Vertex(int x, int y, byte b) {
        this.x = x;
        this.y = y;
        this.b = b;
        distance = Double.MAX_VALUE;
    }

    void setDistance(double distance) {
        this.distance = distance;
    }

    Vertex[] getIncidentVertices() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    double getDistance() {
        return distance;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setParent(Vertex u) {
        parent = u;
    }

    Vertex getParent() {
        return parent;
    }
}
