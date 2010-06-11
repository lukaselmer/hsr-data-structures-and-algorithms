/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung14_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import uebung14_2.Vertex;

/**
 *
 * @author Lukas Elmer
 */
public class VertexPriorityQueue {

    private List<Vertex> list = new LinkedList<Vertex>();
    private Vertex[][] vv;
    int size = 0;

    VertexPriorityQueue(Map map) {
        vv = new Vertex[map.getWidth()][map.getHeight()];
        for (Vertex[] v : vv) {
            v = new Vertex[map.getHeight()];
        }
    }

    Vertex get(int x, int y) {
        //if (x < 0 || y < 0 || x > map.getWidth() || y > map.getHeight()) {
        // return null;
        //}
        try {
            return vv[x][y];
        } catch (Exception e) {
            return null;
        }
//        for (Vertex vertex : list) {
//            if (vertex.getX() == x && vertex.getY() == y) {
//                return vertex;
//            }
//        }
//        return null;
    }

    boolean insert(Vertex vertex) {
        size++;
        vv[vertex.getX()][vertex.getY()] = vertex;
        return list.add(vertex);
    }

    boolean isEmpty() {
        return size == 0;
        //return list.isEmpty();
    }

    Vertex removeMin() {
//        Vertex min = list.get(0);
//        for (Vertex vertex : list) {
//            if (vertex.getDistance() < min.getDistance()) {
//                min = vertex;
//            }
//        }
//        list.remove(min);

        Vertex min = null;
        for (int i = 0; i < vv.length; i++) {
            for (int j = 0; j < vv[i].length; j++) {
                Vertex vertex = vv[i][j];
                if (min == null) {
                    min = vertex;
                }
                if (vertex == null) {
                    continue;
                } else if (vertex.getDistance() < min.getDistance()) {
                    min = vertex;
                }
            }
        }
        vv[min.getX()][min.getY()] = null;
        size--;
        return min;
    }

    void updateVertex(Vertex z) {
        // Not used yet...
    }

    void addIncidentEdges() {
        for (Vertex vertex : list) {
            int[][] incidentCoordinates = {
                {vertex.getX() - 1, vertex.getY() - 1}, // top left
                {vertex.getX() - 1, vertex.getY()}, // left
                {vertex.getX() + 1, vertex.getY() - 1}, // top right
                {vertex.getX() + 1, vertex.getY()}, // right
                {vertex.getX(), vertex.getY() - 1}, // top
                {vertex.getX(), vertex.getY() + 1}, // bottom
                {vertex.getX() - 1, vertex.getY() + 1}, // bottom left
                {vertex.getX() + 1, vertex.getY() + 1}, // bottom right
            };
            for (int[] coordinate : incidentCoordinates) {
                Vertex v = get(coordinate[0], coordinate[1]);
                if (v != null) {
                    vertex.addIncidentVertex(v);
                }
            }
        }
    }
}
