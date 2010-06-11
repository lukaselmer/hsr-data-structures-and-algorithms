/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uebung14_2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lukas Elmer
 */
public class VertexPriorityQueue {

    private Vertex[][] vv;
    int size = 0;

    VertexPriorityQueue(Map map) {
        vv = new Vertex[map.getWidth()][map.getHeight()];
    }

    Vertex get(int x, int y) {
        try {
            return vv[x][y];
        } catch (Exception e) {
            return null;
        }
    }

    boolean insert(Vertex vertex) {
        size++;
        try {
            vv[vertex.getX()][vertex.getY()] = vertex;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean isEmpty() {
        return size == 0;
    }

    Vertex removeMin() {
        if (isEmpty()) {
            return null;
        }
        Vertex min = null;
        for (int i = 0; i < vv.length; i++) {
            for (int j = 0; j < vv[i].length; j++) {
                Vertex vertex = vv[i][j];
                if (min == null && vertex != null) {
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
        for (int i = 0; i < vv.length; i++) {
            for (int j = 0; j < vv[i].length; j++) {
                Vertex vertex = vv[i][j];
                if (vertex == null) {
                    continue;
                }
                int[][] incidentCoordinates = {
                    // Horizontal, vertical
                    {vertex.getX() - 1, vertex.getY()}, // left
                    {vertex.getX() + 1, vertex.getY()}, // right
                    {vertex.getX(), vertex.getY() - 1}, // top
                    {vertex.getX(), vertex.getY() + 1}, // bottom
                    // Diagonal
                    {vertex.getX() - 1, vertex.getY() - 1}, // top left
                    {vertex.getX() + 1, vertex.getY() - 1}, // top right
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
}
