/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung14_2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas Elmer
 */
class Vertex {

    private int x, y;
    private double distance;
    private Vertex parent;
    private ArrayList<Vertex> incidentVertices = new ArrayList<Vertex>();

    Vertex(int x, int y) {
        this.x = x;
        this.y = y;
        distance = Double.MAX_VALUE;
    }

    void setDistance(double distance) {
        this.distance = distance;
    }

    void addIncidentVertex(Vertex vertex){
        incidentVertices.add(vertex);
    }

    ArrayList<Vertex> getIncidentVertices() {
        return incidentVertices;
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
