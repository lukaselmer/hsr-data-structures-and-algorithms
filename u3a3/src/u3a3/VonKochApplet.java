package u3a3;

import java.applet.*;
import java.awt.*;

public class VonKochApplet extends Applet {

    private static final long serialVersionUID = 1L;
    int level = 1;

    public void init() {
        setBackground(new Color(255, 255, 255));
        setSize(1800, 800);
    }

    public boolean mouseDown(Event ev, int x, int y) {
        if (!ev.metaDown()) {
            level += 1;
        } else if (level > 1) {
            level -= 1;
        }
        repaint();
        return true;
    }

    public void paint(Graphics g) {
        init();
        koch(g, 10, 610, 1750, 610, level); // initial values
    }

    private void koch(Graphics g, double x1, double y1, double x2, double y2, int level) {
        double a1, b1, a2, b2, a3, b3;
        if (level > 1) {
            a1 = (2 * x1 + x2) / 3;
            b1 = (2 * y1 + y2) / 3;
            a2 = ((x1 + x2) / 2) + (y2 - y1) * Math.sqrt(3) / 6;
            b2 = (y1 + y2) / 2 + (x1 - x2) * Math.sqrt(3) / 6;
            a3 = (2 * x2 + x1) / 3;
            b3 = (2 * y2 + y1) / 3;
            koch(g, x1, y1, a1, b1, level - 1);
            koch(g, a1, b1, a2, b2, level - 1);
            koch(g, a2, b2, a3, b3, level - 1);
            koch(g, a3, b3, x2, y2, level - 1);
        } else {
            g.drawLine((int) Math.round(x1), (int) Math.round(y1), (int) Math.round(x2), (int) Math.round(y2));
        }
    }
}
