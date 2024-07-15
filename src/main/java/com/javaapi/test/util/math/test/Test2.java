package com.javaapi.test.util.math.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    private static List<List<Node>> result = Lists.newArrayList();

    public static void main(String[] args) {
        Node node5 = new Node(5, null, null);
        Node node3 = new Node(3, null, null);
        Node node2 = new Node(2, null, node5);
        Node node1 = new Node(1, node2, node3);

        List<Node> path = Lists.newArrayList();
        path.add(node1);
        new Test2().scan(path, node1);
        System.out.println("path = " + result);

    }

    public void scan(List<Node> path, Node node) {
        if (node != null && node.getLeft() == null && node.getRight() == null) {
            result.add(path);
            return;
        }
        if (node.getLeft() != null) {
            List<Node> lefts = Lists.newArrayList();
            lefts.addAll(path);
            lefts.add(node.getLeft());
            scan(lefts, node.getLeft());
        }
        if (node.getRight() != null) {
            List<Node> rights = Lists.newArrayList();
            rights.addAll(path);
            rights.add(node.getRight());
            scan(rights, node.getRight());
        }


    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
