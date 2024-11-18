/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.graphvisualization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

/**
 *
 * @author Delmoro-Ke
 */
public class GraphVisualization extends JPanel {

    private Node root;
    private final Font nodeFont = new Font("Segoe UI", Font.BOLD, 12);
    private final int levelSpacing = 80;
    private final int baseOffset = 15;
    
    JTextField txtAdd;
    JButton btnAdd;

    public GraphVisualization(Node root) {
        this.root = root;
        setPreferredSize(new Dimension(800, 600));
        
        txtAdd = new JTextField();
        txtAdd.setPreferredSize(new Dimension (60, 30));
        btnAdd = new JButton ("Add");
        btnAdd.setPreferredSize(new Dimension (60, 30));
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnAddAction(evt);
            }
        });
        
        this.add(txtAdd);
        this.add(btnAdd);
    }
    
    private void btnAddAction (ActionEvent evt) {
        insert(Integer.parseInt(txtAdd.getText()));
    }

    public void insert(int val) {
        root = BinarySearchTree.insert(root, val);
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int level = BinarySearchTree.getLevel(root);
        drawTree(g2, root, getWidth() / 2, 100, level);
    }

    private void drawTree(Graphics2D g, Node node, int x, int y, int height) {
        if (node == null) {
            return;
        }
        
        switch (height % 7) {
            case 0 -> g.setColor(Color.red);
            case 1 -> g.setColor(Color.orange);
            case 2 -> g.setColor(Color.yellow);
            case 3 -> g.setColor(Color.green);
            case 4 -> g.setColor(Color.cyan);
            case 5 -> g.setColor(Color.magenta);
            case 6 -> g.setColor(Color.pink);
            default -> g.setColor(Color.white);
        }
        g.fillOval(x - 10, y - 10, 20, 20);
        g.setColor(Color.black);
        g.drawOval(x - 10, y - 10, 20, 20);

        g.setFont(nodeFont);
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(String.valueOf(node.val));
        g.drawString(String.valueOf(node.val), x - textWidth / 2, y + 5);

        int yOffset = levelSpacing;
        int xOffset = baseOffset * (int) Math.pow(2, height - 1);

        g.setColor(Color.black);
        if (node.left != null) {
            int xLeft = x - xOffset;
            g.drawLine(x, y + 10, xLeft, y + yOffset - 10);
            drawTree(g, node.left, xLeft, y + yOffset, height - 1);
        }
        if (node.right != null) {
            int xRight = x + xOffset;
            g.drawLine(x, y + 10, xRight, y + yOffset - 10);
            drawTree(g, node.right, xRight, y + yOffset, height - 1);
        }
    }

    public static void main(String[] args) {
        GraphVisualization tree = new GraphVisualization(null);
        JFrame frame = new JFrame("BST Graph Visualization - CSCC 104: Data Structures and Algorithms by: Kenji A. Delmoro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tree);
        frame.pack();
        frame.repaint();
        frame.setVisible(true);

        try (Scanner scan = new Scanner(System.in)) {
            int choice = 0;

            while (choice != 3) {
                System.out.println("Menu:");
                System.out.println("1. Insert Node to BST");
                System.out.println("2. Toggle display BST Graph");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                choice = scan.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter the data to insert: ");
                        int val = scan.nextInt();
                        tree.insert(val);
                    }
                    case 2 -> {
                        frame.repaint();
                        frame.setVisible(!frame.isVisible());
                        break;
                    }
                    case 3 ->
                        System.out.println("Exiting...");
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println();
            }
        }
    }
}
