/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-05-28 20:11:24 +0200 (Fr, 28 Mai 2010) $
 */
package uebung14_2;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Vector;

public class PathFinderImpl extends PathFinder {

    public PathFinderImpl(Map m) {
        super(m);
    }

    private ArrayList<Vertex> getVertices() {
        return null;
    }

    public Vector<Point> findPath(int x0, int y0, int x1, int y1) {
        path.clear();
        System.out.println("Test: " + x0 + " " + y0 + " " + x1 + " " + y1);
        ArrayList<Vertex> verices = getVertices();
        byte[][] byteMap = map.getMatrix();

        System.out.println("Initializing VertexPriorityQueue...");
        VertexPriorityQueue q = new VertexPriorityQueue(map);
        Vertex start = new Vertex(x0, y0); // set start point
        Vertex goal = new Vertex(x1, y1); // set goal point
        for (int i = 0; i < byteMap.length; i++) {
            for (int j = 0; j < byteMap[i].length; j++) {
                Vertex vertex;
                if (i == x0 && j == y0) {
                    vertex = start;
                } else if (i == x1 & j == y1) {
                    vertex = goal;
                } else {
                    vertex = new Vertex(i, j);
                }
                //l ← Q.insert(getDistance(v), v)

                if (vertex == start) {
                    vertex.setDistance(0);
                } else {
                    vertex.setDistance(Double.MAX_VALUE);
                }
                q.insert(vertex);
                //setLocator(v,l)
            }
        }
        System.out.println("Done!");

        System.out.println("Adding incident edges...");
        q.addIncidentEdges();
        System.out.println("Done!");
        //System.out.println(q.get(0, 0).getIncidentVertices().size() + "XXXXXXXXXXXXXXXX");


        System.out.println("Calculating path...");
        while (!q.isEmpty()) {
            Vertex u = q.removeMin();
            for (Vertex z : u.getIncidentVertices()) {
                double distance = u.getDistance() + map.calcWeight(u.getX(), u.getY(), z.getX(), z.getY());
                if (distance <= z.getDistance()) {
                    z.setDistance(distance);
                    z.setParent(u);
                    //q.updateVertex(z);
                }
            }
        }
        System.out.println("Done!");

        System.out.println("Drawing path...");
        Vertex current = goal;
        while (current.getParent() != null) {
            System.out.print(current.getX() + "/" + current.getY() + ", ");
            path.add(new Point(current.getX(), current.getY()));
            current = current.getParent();
        }

        System.out.println("Done!");

        System.out.println("Notify observers...");
        setChanged();
        notifyObservers();
        System.out.println("Done!");
        return path;

        /*// TODO Implement here...
        // Just a Test:
        path.add(new Point(2, 2));
        path.add(new Point(150, 50));
        path.add(new Point(198, 198));

        setChanged();
        notifyObservers();
        return path;*/
    }
}
 
