/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import GUI.RoutPlanningFrame;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JPanel;

public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener {

    private Image img;
    private Vector<Polygon> polys;
    private int currentMap;
    private Color fill;
    private float alpha;
    private HashSet<Integer> choosenMaps;
    private RoutPlanningFrame routPlanningFrame;
    private ArrayList<Integer> lotIndex;

    public ImagePanel(Image image) {
        this.img = image;
        currentMap = -1;
        addMouseListener(this);
        alpha = 0.9f;//how deep is color
        fill = Color.GREEN;
        choosenMaps = new HashSet<>();

    }

    public ImagePanel(Image image, RoutPlanningFrame routPlanningFrame) {
        this.img = image;
        this.routPlanningFrame = routPlanningFrame;
        currentMap = -1;
        addMouseListener(this);
        addMouseMotionListener(this);
        alpha = 0.9f;//how deep is color
        fill = Color.GREEN;
        choosenMaps = new HashSet<>();
        lotIndex = new ArrayList<>();
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
            for (Integer choosenMap : choosenMaps) {
                g2.fillPolygon(this.polys.get(choosenMap));
            }
        }
    }
    //delete
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();

    public ArrayList<Integer> getXo() {
        return x;
    }
    public ArrayList<Integer> getYo() {
        return x;
    }
//---

    @Override
    public void mouseClicked(MouseEvent e) {
        // this is to be deleted from here
        x.add(e.getX());
        y.add(e.getY());
        // till here

        for (int i = 0; i < polys.size(); i++) {
            if (polys.get(i).contains(e.getX(), e.getY())) {

                if (e.getButton() == MouseEvent.BUTTON1) {

                    if (!choosenMaps.contains(i)) {
                        currentMap = i;
                        choosenMaps.add(currentMap);

                        lotIndex.add(currentMap);
                        routPlanningFrame.showDistricts(lotIndex);
                    }
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (choosenMaps.contains(i)) {

                        currentMap = i;
                        choosenMaps.remove(currentMap);

                        int x = lotIndex.indexOf(currentMap);
                        if (x > -1) {
                            lotIndex.remove(x);
                        }

                        routPlanningFrame.showDistricts(lotIndex);
                    }
                }
                repaint();
                break; // no need to keep checking
            } else {

                routPlanningFrame.showDistricts(lotIndex);
            }
        }

    }

    // unused mouse
    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        int x = e.getX();
        routPlanningFrame.showX(x);
        int y = e.getY();
        routPlanningFrame.showY(y);
    }
}
