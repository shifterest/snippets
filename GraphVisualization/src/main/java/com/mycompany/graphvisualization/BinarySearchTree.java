/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphvisualization;

import java.util.ArrayList;

/**
 *
 * @author Delmoro-Ke
 */
public class BinarySearchTree {

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static int getLevel(Node root) {
        return traverse(root, 0);
    }

    public static int traverse(Node root, int level) {
        if (root == null) {
            return level;
        }

        int left = traverse(root.left, level + 1);
        int right = traverse(root.right, level + 1);
        return Math.max(left, right);
    }

    public static Node findMin(Node root) {
        if (root == null) {
            return root;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static Node findMax(Node root) {
        if (root == null) {
            return root;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }
}
