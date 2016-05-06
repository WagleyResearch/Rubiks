/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubiks;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author benwagley
 */
public class Cube {

    Cubit[][][] cube = new Cubit[3][3][3];
    JFrame frame = new JFrame("Rubiks");
    GridLayout face = new GridLayout(3, 3, 10, 10);
    GridLayout cubeFace = new GridLayout(2, 4, 40, 40);
    GridLayout controls = new GridLayout(2, 3, 5, 5);
    JButton top = new JButton("Top");
    JButton topP = new JButton("Top Prime");
    JButton bottom = new JButton("Bottom");
    JButton bottomP = new JButton("Bottom Prime");
    JButton left = new JButton("Left");
    JButton leftP = new JButton("Left Prime");
    JButton right = new JButton("Right");
    JButton rightP = new JButton("Right Prime");
    JButton front = new JButton("Front");
    JButton frontP = new JButton("Front Prime");
    JButton back = new JButton("Back");
    JButton backP = new JButton("Back Prime");
    JPanel controls1 = new JPanel();
    JPanel controls2 = new JPanel();
    JPanel blue = new JPanel();
    JPanel white = new JPanel();
    JPanel red = new JPanel();
    JPanel yellow = new JPanel();
    JPanel orange = new JPanel();
    JPanel green = new JPanel();
    ArrayList<JPanel> panels = new ArrayList<JPanel>();

    public Cube() {
        //cube[x][y][z]
        //This builds the cube
        cube[0][0][0] = new Cubit(Color.BLUE, Color.WHITE, Color.ORANGE);
        cube[0][0][1] = new Cubit(Color.WHITE, Color.ORANGE);
        cube[0][0][2] = new Cubit(Color.GREEN, Color.WHITE, Color.ORANGE);
        cube[0][1][0] = new Cubit(Color.BLUE, Color.WHITE);
        cube[0][1][1] = new Cubit(Color.WHITE);
        cube[0][1][2] = new Cubit(Color.GREEN, Color.WHITE);
        cube[0][2][0] = new Cubit(Color.BLUE, Color.WHITE, Color.RED);
        cube[0][2][1] = new Cubit(Color.WHITE, Color.RED);
        cube[0][2][2] = new Cubit(Color.GREEN, Color.WHITE, Color.RED);
        cube[1][0][0] = new Cubit(Color.BLUE, Color.ORANGE);
        cube[1][0][1] = new Cubit(Color.ORANGE);
        cube[1][0][2] = new Cubit(Color.GREEN, Color.ORANGE);
        cube[1][1][0] = new Cubit(Color.BLUE);
        cube[1][1][1] = new Cubit();
        cube[1][1][2] = new Cubit(Color.GREEN);
        cube[1][2][0] = new Cubit(Color.BLUE, Color.RED);
        cube[1][2][1] = new Cubit(Color.RED);
        cube[1][2][2] = new Cubit(Color.GREEN, Color.RED);
        cube[2][0][0] = new Cubit(Color.BLUE, Color.YELLOW, Color.ORANGE);
        cube[2][0][1] = new Cubit(Color.YELLOW, Color.ORANGE);
        cube[2][0][2] = new Cubit(Color.GREEN, Color.YELLOW, Color.ORANGE);
        cube[2][1][0] = new Cubit(Color.BLUE, Color.YELLOW);
        cube[2][1][1] = new Cubit(Color.YELLOW);
        cube[2][1][2] = new Cubit(Color.GREEN, Color.YELLOW);
        cube[2][2][0] = new Cubit(Color.BLUE, Color.YELLOW, Color.RED);
        cube[2][2][1] = new Cubit(Color.YELLOW, Color.RED);
        cube[2][2][2] = new Cubit(Color.GREEN, Color.YELLOW, Color.RED);
    }

    public void display() {
        JLabel test = new JLabel("[0][0][0]");
        frame.setBackground(Color.BLACK);
        frame.setLayout(cubeFace);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 900);
        blue.setLayout(face);
        white.setLayout(face);
        orange.setLayout(face);
        red.setLayout(face);
        yellow.setLayout(face);
        green.setLayout(face);
        controls1.setLayout(controls);
        controls2.setLayout(controls);
        class Listener extends JPanel implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == top) {
                    turnTop();
                } else if (event.getSource() == topP) {
                    turnTopP();
                } else if (event.getSource() == left) {
                    turnLeft();
                } else if (event.getSource() == leftP) {
                    turnLeftP();
                } else if (event.getSource() == right) {
                    turnRight();
                } else if (event.getSource() == rightP) {
                    turnRightP();
                } else if (event.getSource() == bottom) {
                    turnBottom();
                } else if (event.getSource() == bottomP) {
                    turnBottomP();
                } else if (event.getSource() == front) {
                    turnFront();
                } else if (event.getSource() == frontP) {
                    turnFrontP();
                } else if (event.getSource() == back) {
                    turnBack();
                } else if (event.getSource() == backP) {
                    turnBackP();
                } else {

                }
                blue.removeAll();
                green.removeAll();
                white.removeAll();
                yellow.removeAll();
                orange.removeAll();
                red.removeAll();
                int l = 0;
                for (int i = 0; i < 3; i++) {

                    for (int k = 0; k < 3; k++) {

                        panels.get(l).setBackground(cube[k][i][0].getColor(1));
                        blue.add(panels.get(l));
                        l++;

                    }

                }
                for (int i = 0; i < 3; i++) {
                    for (int k = 0; k < 3; k++) {

                        panels.get(l).setBackground(cube[k][i][2].getColor(1));
                        green.add(panels.get(l));
                        l++;
                    }

                }
                for (int i = 0; i < 3; i++) {
                    for (int k = 2; k >= 0; k--) {
                        if (cube[0][i][k].getFace() == Color.BLUE || cube[0][i][k].getFace() == Color.GREEN) {
                            panels.get(l).setBackground(cube[0][i][k].getColor(2));
                        } else {
                            panels.get(l).setBackground(cube[0][i][k].getColor(1));
                        }
                        white.add(panels.get(l));

                        l++;
                    }

                }
                for (int k = 0; k < 3; k++) {
                    for (int i = 0; i < 3; i++) {

                        if (cube[2][k][i].getFace() == Color.BLUE || cube[2][k][i].getFace() == Color.GREEN) {
                            panels.get(l).setBackground(cube[2][k][i].getColor(2));
                        } else {
                            panels.get(l).setBackground(cube[2][k][i].getColor(1));
                        }
                        yellow.add(panels.get(l));

                        l++;
                    }

                }
                for (int i = 2; i >= 0; i--) {
                    for (int k = 0; k < 3; k++) {

                        if (cube[k][0][i].isCorner()) {
                            panels.get(l).setBackground(cube[k][0][i].getColor(3));
                        } else if (cube[k][0][i].isCenter()) {
                            panels.get(l).setBackground(cube[k][0][i].getColor(1));
                        } else {
                            panels.get(l).setBackground(cube[k][0][i].getColor(2));
                        }
                        orange.add(panels.get(l));

                        l++;
                    }

                }
                for (int i = 2; i >= 0; i--) {
                    for (int k = 0; k < 3; k++) {

                        if (cube[k][2][i].isCorner()) {
                            panels.get(l).setBackground(cube[k][2][i].getColor(3));
                        } else if (cube[k][2][i].isCenter()) {
                            panels.get(l).setBackground(cube[k][2][i].getColor(1));
                        } else {
                            panels.get(l).setBackground(cube[k][2][i].getColor(2));
                        }
                        red.add(panels.get(l));

                        l++;
                    }

                }
                blue.revalidate();
                blue.repaint();
                green.revalidate();
                green.repaint();
                yellow.revalidate();
                yellow.repaint();
                red.revalidate();
                red.repaint();
                orange.revalidate();
                orange.repaint();
                white.revalidate();
                white.repaint();

            }
        }
        top.addActionListener(new Listener());
        topP.addActionListener(new Listener());
        left.addActionListener(new Listener());
        leftP.addActionListener(new Listener());
        right.addActionListener(new Listener());
        rightP.addActionListener(new Listener());
        bottom.addActionListener(new Listener());
        bottomP.addActionListener(new Listener());
        front.addActionListener(new Listener());
        frontP.addActionListener(new Listener());
        back.addActionListener(new Listener());
        backP.addActionListener(new Listener());
        controls1.add(top);
        controls1.add(topP);
        controls1.add(bottom);
        controls1.add(bottomP);
        controls1.add(front);
        controls1.add(frontP);
        controls2.add(back);
        controls2.add(backP);
        controls2.add(left);
        controls2.add(leftP);
        controls2.add(right);
        controls2.add(rightP);
        int j = 0;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                JPanel temp = new JPanel();
                temp.setBackground(cube[k][i][0].getColor(1));
                panels.add(temp);
                blue.add(panels.get(j));

                j++;
            }
        }
        for (int i = 2; i >= 0; i--) {
            for (int k = 2; k >= 0; k--) {
                JPanel temp = new JPanel();
                temp.setBackground(cube[k][i][2].getColor(1));
                panels.add(temp);
                green.add(panels.get(j));
                j++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int k = 2; k >= 0; k--) {
                JPanel temp = new JPanel();
                if (cube[0][i][k].getFace() == Color.BLUE || cube[0][i][k].getFace() == Color.GREEN) {
                    temp.setBackground(cube[0][i][k].getColor(2));
                } else {
                    temp.setBackground(cube[0][i][k].getColor(1));
                }
                panels.add(temp);
                white.add(panels.get(j));

                j++;
            }
        }
        for (int i = 2; i >= 0; i--) {
            for (int k = 0; k < 3; k++) {
                JPanel temp = new JPanel();
                if (cube[2][i][k].getFace() == Color.BLUE || cube[2][i][k].getFace() == Color.GREEN) {
                    temp.setBackground(cube[2][i][k].getColor(2));
                } else {
                    temp.setBackground(cube[2][i][k].getColor(1));
                }
                panels.add(temp);
                yellow.add(panels.get(j));

                j++;
            }
        }
        for (int i = 2; i >= 0; i--) {
            for (int k = 0; k < 3; k++) {
                JPanel temp = new JPanel();
                if (cube[k][0][i].isCorner()) {
                    temp.setBackground(cube[k][0][i].getColor(3));
                } else if (cube[k][0][i].isCenter()) {
                    temp.setBackground(cube[k][0][i].getColor(1));
                } else {
                    temp.setBackground(cube[k][0][i].getColor(2));
                }
                panels.add(temp);
                orange.add(panels.get(j));

                j++;
            }
        }
        for (int i = 2; i >= 0; i--) {
            for (int k = 0; k < 3; k++) {
                JPanel temp = new JPanel();
                if (cube[k][2][i].isCorner()) {
                    temp.setBackground(cube[k][2][i].getColor(3));
                } else if (cube[k][2][i].isCenter()) {
                    temp.setBackground(cube[k][2][i].getColor(1));
                } else {
                    temp.setBackground(cube[k][2][i].getColor(2));
                }
                panels.add(temp);
                red.add(panels.get(j));

                j++;
            }
        }
        frame.add(white);
        frame.add(blue);
        frame.add(yellow);
        frame.add(controls1);
        frame.add(orange);
        frame.add(green);
        frame.add(red);
        frame.add(controls2);
        frame.setVisible(true);

    }

    public void turnTop(int n) {

        for (int j = 0; j < n; j++) {
            Cubit[][][] tempCube = new Cubit[3][3][3];
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(cube[i][k], 0, tempCube[i][k], 0, 3);
                }
            }
            cube[2][0][0] = tempCube[2][0][2];
            cube[2][0][0].setFace(Color.BLUE);
            cube[2][0][0].turnTop();
            cube[2][0][1] = tempCube[1][0][2];
            cube[2][0][1].setFace(Color.YELLOW);
            cube[2][0][2] = tempCube[0][0][2];
            cube[2][0][2].setFace(Color.GREEN);
            cube[2][0][2].turnTop();
            cube[1][0][2] = tempCube[0][0][1];
            cube[1][0][2].setFace(Color.GREEN);
            cube[0][0][2] = tempCube[0][0][0];
            cube[0][0][2].setFace(Color.GREEN);
            cube[0][0][2].turnTop();
            cube[0][0][1] = tempCube[1][0][0];
            cube[0][0][1].setFace(Color.WHITE);
            cube[0][0][0] = tempCube[2][0][0];
            cube[0][0][0].setFace(Color.BLUE);
            cube[0][0][0].turnTop();
            cube[1][0][0] = tempCube[2][0][1];
            cube[1][0][0].setFace(Color.BLUE);
        }
    }

    public void turnTop() {
        turnTop(1);
    }

    public void turnTopP(int i) {
        turnTop(4 - (i % 4));
    }

    public void turnTopP() {
        turnTop(3);
    }

    public void turnBottom(int n) {
        for (int j = 0; j < n; j++) {
            Cubit[][][] tempCube = new Cubit[3][3][3];
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(cube[i][k], 0, tempCube[i][k], 0, 3);
                }
            }
            cube[2][2][0] = tempCube[2][2][2];
            cube[2][2][0].setFace(Color.BLUE);
            cube[2][2][0].turnTop();
            cube[2][2][1] = tempCube[1][2][2];
            cube[2][2][1].setFace(Color.YELLOW);
            cube[2][2][2] = tempCube[0][2][2];
            cube[2][2][2].setFace(Color.GREEN);
            cube[2][2][2].turnTop();
            cube[1][2][2] = tempCube[0][2][1];
            cube[1][2][2].setFace(Color.GREEN);
            cube[0][2][2] = tempCube[0][2][0];
            cube[0][2][2].setFace(Color.GREEN);
            cube[0][2][2].turnTop();
            cube[0][2][1] = tempCube[1][2][0];
            cube[0][2][1].setFace(Color.WHITE);
            cube[0][2][0] = tempCube[2][2][0];
            cube[0][2][0].setFace(Color.BLUE);
            cube[0][2][0].turnTop();
            cube[1][2][0] = tempCube[2][2][1];
            cube[1][2][0].setFace(Color.BLUE);
        }

    }

    public void turnBottom() {
        turnBottom(1);
    }

    public void turnBottomP(int i) {
        turnBottom(4 - (i % 4));
    }

    public void turnBottomP() {
        turnBottom(3);
    }

    public void turnLeft(int n) {
        for (int j = 0; j < n; j++) {
            Cubit[][][] tempCube = new Cubit[3][3][3];
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(cube[i][k], 0, tempCube[i][k], 0, 3);
                }
            }
            cube[0][2][0] = tempCube[0][0][0];
            cube[0][2][0].setFace(Color.BLUE);
            cube[0][2][0].turnLeft();
            cube[0][2][1] = tempCube[0][1][0];
            cube[0][2][1].setFace(Color.WHITE);
            cube[0][2][1].turnLeft();
            cube[0][2][2] = tempCube[0][2][0];
            cube[0][2][2].setFace(Color.GREEN);
            cube[0][2][2].turnLeft();
            cube[0][1][2] = tempCube[0][2][1];
            cube[0][1][2].setFace(Color.GREEN);
            cube[0][1][2].turnLeft();
            cube[0][0][2] = tempCube[0][2][2];
            cube[0][0][2].setFace(Color.GREEN);
            cube[0][0][2].turnLeft();
            cube[0][0][1] = tempCube[0][1][2];
            cube[0][0][1].setFace(Color.WHITE);
            cube[0][0][1].turnLeft();
            cube[0][0][0] = tempCube[0][0][2];
            cube[0][0][0].setFace(Color.BLUE);
            cube[0][0][0].turnLeft();
            cube[0][1][0] = tempCube[0][0][1];
            cube[0][1][0].setFace(Color.BLUE);
            cube[0][1][0].turnLeft();
        }

    }

    public void turnLeft() {
        turnLeft(1);
    }

    public void turnLeftP(int i) {
        turnLeft(4 - (i % 4));
    }

    public void turnLeftP() {
        turnLeft(3);
    }

    public void turnRight(int n) {
        for (int j = 0; j < n; j++) {
            Cubit[][][] tempCube = new Cubit[3][3][3];
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(cube[i][k], 0, tempCube[i][k], 0, 3);
                }
            }
            cube[2][2][0] = tempCube[2][0][0];
            cube[2][2][0].setFace(Color.BLUE);
            cube[2][2][0].turnLeft();
            cube[2][2][1] = tempCube[2][1][0];
            cube[2][2][1].setFace(Color.WHITE);
            cube[2][2][1].turnLeft();
            cube[2][2][2] = tempCube[2][2][0];
            cube[2][2][2].setFace(Color.GREEN);
            cube[2][2][2].turnLeft();
            cube[2][1][2] = tempCube[2][2][1];
            cube[2][1][2].setFace(Color.GREEN);
            cube[2][1][2].turnLeft();
            cube[2][0][2] = tempCube[2][2][2];
            cube[2][0][2].setFace(Color.GREEN);
            cube[2][0][2].turnLeft();
            cube[2][0][1] = tempCube[2][1][2];
            cube[2][0][1].setFace(Color.WHITE);
            cube[2][0][1].turnLeft();
            cube[2][0][0] = tempCube[2][0][2];
            cube[2][0][0].setFace(Color.BLUE);
            cube[2][0][0].turnLeft();
            cube[2][1][0] = tempCube[2][0][1];
            cube[2][1][0].setFace(Color.BLUE);
            cube[2][1][0].turnLeft();
        }

    }

    public void turnRight() {
        turnRight(1);
    }

    public void turnRightP(int i) {
        turnRight(4 - (i % 4));
    }

    public void turnRightP() {
        turnRight(3);
    }

    public void turnFront(int n) {
        for (int j = 0; j < n; j++) {
            Cubit[][][] tempCube = new Cubit[3][3][3];
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(cube[i][k], 0, tempCube[i][k], 0, 3);
                }
            }
            cube[0][2][0] = tempCube[2][2][0];
            cube[0][2][0].turnFront();
            cube[1][2][0] = tempCube[2][1][0];
            cube[2][2][0] = tempCube[2][0][0];
            cube[2][2][0].turnFront();
            cube[2][1][0] = tempCube[1][0][0];
            cube[2][0][0] = tempCube[0][0][0];
            cube[2][0][0].turnFront();
            cube[1][0][0] = tempCube[0][1][0];
            cube[0][0][0] = tempCube[0][2][0];
            cube[0][0][0].turnFront();
            cube[0][1][0] = tempCube[1][2][0];

        }

    }

    public void turnFront() {
        turnFront(1);
    }

    public void turnFrontP(int i) {
        turnFront(4 - (i % 4));
    }

    public void turnFrontP() {
        turnFront(3);
    }

    public void turnBack(int n) {
        for (int j = 0; j < n; j++) {
            Cubit[][][] tempCube = new Cubit[3][3][3];
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(cube[i][k], 0, tempCube[i][k], 0, 3);
                }
            }
            cube[0][2][2] = tempCube[2][2][2];
            cube[0][2][2].turnFront();
            cube[1][2][2] = tempCube[2][1][2];
            cube[2][2][2] = tempCube[2][0][2];
            cube[2][2][2].turnFront();
            cube[2][1][2] = tempCube[1][0][2];
            cube[2][0][2] = tempCube[0][0][2];
            cube[2][0][2].turnFront();
            cube[1][0][2] = tempCube[0][1][2];
            cube[0][0][2] = tempCube[0][2][2];
            cube[0][0][2].turnFront();
            cube[0][1][2] = tempCube[1][2][2];

        }

    }

    public void turnBack() {
        turnBack(1);
    }

    public void turnBackP(int i) {
        turnBack(4 - (i % 4));
    }

    public void turnBackP() {
        turnBack(3);
    }

}
