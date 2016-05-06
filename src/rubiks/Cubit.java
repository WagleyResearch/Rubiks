/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubiks;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author benwagley
 */
public class Cubit {

    ArrayList<Color> colors = new ArrayList<Color>();
    Color face;
    boolean isCorner = false;
    boolean isCenter = false;

    public Cubit() {

    }

    public Cubit(Color a) {
        colors.add(a);
        face = a;
        isCenter = true;
    }

    public Cubit(Color a, Color b) {
        colors.add(a);
        colors.add(b);
        face = a;
    }

    public Cubit(Color a, Color b, Color c) {
        colors.add(a);
        colors.add(b);
        colors.add(c);

        face = a;

        isCorner = true;
    }

    public Color getColor(int i) {
        return colors.get(i - 1);
    }

    public Color getFace() {
        return face;
    }

    public boolean isCorner() {
        return isCorner;
    }

    public boolean isCenter() {
        return isCenter;
    }

    public void setFace(Color a) {
        face = a;
    }

    public void turnTop() {
        Color temp = colors.get(0);
        colors.set(0, colors.get(1));
        colors.set(1, temp);
    }

    public void turnLeft() {
        if (colors.size() == 3) {
            Color temp = colors.get(0);
            colors.set(0, colors.get(2));
            colors.set(2, temp);
        } else if (colors.size() == 2) {
            Color temp = colors.get(0);
            colors.set(0, colors.get(1));
            colors.set(1, temp);
        }
    }

    public void turnFront() {
        if (colors.size() == 3) {
            Color temp = colors.get(1);
            colors.set(1, colors.get(2));
            colors.set(2, temp);
        }

    }
}
