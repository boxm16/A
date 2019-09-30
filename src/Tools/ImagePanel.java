/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JPanel;

public class ImagePanel extends JPanel implements MouseListener {

    private Image img;
    private Vector<Polygon> polys;
    private int currentMap;
    private Color fill;
    private float alpha;

    public ImagePanel(Image image) {
        this.img = image;
        currentMap = -1;
        addMouseListener(this);
        alpha = 0.9f;//how deep is color
        fill = Color.GREEN;
    }

    public void setPolygons(Vector<Polygon> polygons) {
        this.polys = polygons;
    }

    public void setFill(Color color) {
        this.fill = color;
    }

    public void setFill(Color color, float alpha) {
        this.fill = color;
        this.alpha = alpha;
    }

    public void paint(java.awt.Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.img, 0, 0, this);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.alpha));
        g2.setColor(this.fill);
        if (this.currentMap > -1) {
            g2.fillPolygon(this.polys.get(this.currentMap));
        }
    }

    public void mouseReleased(MouseEvent e) {
   for (int i = 0; i < polys.size(); i++) {
            if (polys.get(i).contains(e.getX(), e.getY())) {
                this.firePropertyChange("CurrentMap", currentMap, i);
                currentMap = i;
                repaint();
                break; // no need to keep checking
            }
        }
    }

    // unused mouse
    public void mouseClicked(MouseEvent e) {
   
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

    }

}
