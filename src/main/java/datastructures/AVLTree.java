package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AVLTree {
    Node root = null;

    public boolean contains(int key) {
        Node node = root;
        while (node != null) {
            if (node.key == key) {
                return true;
            } else if (node.key < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return false;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(null, key);
            return;
        }
        if (contains(key)) {
            System.err.println("VALUE CONTAINED " + key);
            return;
        }

        Node node = root;
        while (node.key != key) {
            if (key < node.key) {
                if (node.left == null) {
                    node.left = new Node(node, key);
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Node(node, key);
                }
                node = node.right;
            }
        }

        while (node.parent != null) {
            if (node.parent.left == node) {
                if (node.parent.balance == -1) {
                    Node parentNode = node.parent;
                    if (node.balance == 1) {
                        rotateLeft(node);
                        node.balance = 0;
                        node.parent.balance = -1;
                    }
                    rotateRight(parentNode);
                    parentNode.balance = 0;
                    parentNode.parent.balance = 0;
                    break;
                }
                node.parent.balance--;
            } else {
                if (node.parent.balance == 1) {
                    Node parentNode = node.parent;
                    if (node.balance == -1) {
                        rotateRight(node);
                        node.balance = 0;
                        node.parent.balance = 1;
                    }
                    rotateLeft(parentNode);
                    parentNode.balance = 0;
                    parentNode.parent.balance = 0;
                    break;
                }
                node.parent.balance++;
            }

            if (node.parent.balance == 0) {
                break;
            }
            node = node.parent;
        }
    }

    private void rotateRight(Node node) {
        Node leftNode = node.left;
        if (node == root) {
            root = leftNode;
        } else {
            if (node.parent.right == node) {
                node.parent.right = leftNode;
            } else {
                node.parent.left = leftNode;
            }
        }
        leftNode.parent = node.parent;
        node.parent = leftNode;

        if (leftNode.right != null) {
            leftNode.right.parent = node;
        }

        node.left = leftNode.right;
        leftNode.right = node;
    }

    private void rotateLeft(Node node) {
        Node rightNode = node.right;
        if (node == root) {
            root = rightNode;
        } else {
            if (node.parent.right == node) {
                node.parent.right = rightNode;
            } else {
                node.parent.left = rightNode;
            }
        }
        rightNode.parent = node.parent;
        node.parent = rightNode;

        if (rightNode.left != null) {
            rightNode.left.parent = node;
        }

        node.right = rightNode.left;
        rightNode.left = node;
    }

    public Node findNode(int key) {
        Node node = root;
        while (node != null) {
            if (node.key == key) {
                return node;
            } else if (key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }


    public int[] toArray() {
        if (root == null) {
            return new int[0];
        }

        Stack<Node> stack = new Stack<>();
        Node node = root;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.key);
                node = node.right;
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    private static final class Node {
        final int key;
        Node left = null;
        Node right = null;
        Node parent;
        int balance = 0;

        private Node(Node parent, int key) {
            this.parent = parent;
            this.key = key;
        }

        @Override
        public String toString() {
            String parentName = parent == null ? "null" : "" + parent.key;
            String leftName = left == null ? "null" : "" + left.key;
            String rightName = right == null ? "null" : "" + right.key;
            return "Node{" +
                    "key=" + key +
                    ", left=" + leftName +
                    ", right=" + rightName +
                    ", parent=" + parentName +
                    ", balance=" + balance +
                    '}';
        }
    }
}
