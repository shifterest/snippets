import java.util.ArrayList;

public class BinarySearchTree {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val <= val) {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                root.right = insertIntoBST(root.right, val);
        } else {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    public static SearchResult searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return new SearchResult(true, null, "root");

        String position = "";

        while (root != null) {
            TreeNode child = null;

            if (root.val < val) {
                position = "right";
                child = root.right;
            } else if (root.val > val) {
                position = "left";
                child = root.left;
            }

            if (child == null)
                break;
            if (child.val == val)
                return new SearchResult(true, root, position);
            else
                root = child;
        }

        return new SearchResult(false, null, "None");
    }

    public static TreeNode findMin(TreeNode root) {
        if (root == null)
            return null;

        while (root.left != null)
            root = root.left;

        return root;
    }

    public static TreeNode findMax(TreeNode root) {
        if (root == null)
            return null;

        while (root.right != null)
            root = root.right;

        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key, boolean useSuccessor) {
        // one of the most annoying algorithms i've made from scratch (which tells me
        // that i still got a long way to go). is it optimized? probably not. does it
        // work? it better does.

        // find node to delete
        SearchResult resultDel = searchBST(root, key);

        // if not found, return the original tree
        if (!resultDel.getFound())
            return root;

        // assign the node to delete to del
        TreeNode del = null;
        switch (resultDel.getPosition()) {
            case "left":
                del = resultDel.getParent().left;
                break;
            case "right":
                del = resultDel.getParent().right;
                break;
            default:
                del = root;
        }

        // if del doesn't have any subtrees, just delete it
        if (del.left == null && del.right == null) {
            switch (resultDel.getPosition()) {
                case "left":
                    resultDel.getParent().left = null;
                    break;
                case "right":
                    resultDel.getParent().right = null;
                    break;
                default:
                    root = null;
            }
            return root;
        }

        // prepare to look for the node to replace the deleted node.
        // since findMin and findMax doesn't keep track of the parent
        // node, we have to re-implement it
        TreeNode parent = null, child = null;
        String position = null;

        if (useSuccessor) {
            // check if del's right subtree even exists
            if (del.right != null) {
                parent = del;
                child = del.right;
                position = "right";
                // findMin
                while (child.left != null) {
                    parent = child;
                    child = child.left;
                    position = "left";
                }
            }
        } else {
            // check if del's left subtree even exists
            if (del.left != null) {
                parent = del;
                child = del.left;
                position = "left";
                // findMax
                while (child.right != null) {
                    parent = child;
                    child = child.right;
                    position = "right";
                }
            }
        }

        if (child != null) {
            switch (position) {
                // 1. replace del's value with child's value
                // 2. replace the parent's children with the child's... children
                // i assume that child can never have more than one child (lol)
                // because child is either the smallest or largest of its subtree
                case "left":
                    del.val = child.val;
                    parent.left = child.left == null ? child.right : child.left;
                    break;
                case "right":
                    del.val = child.val;
                    parent.right = child.left == null ? child.right : child.left;
                    break;
            }
        }

        // if there's no successor or predecessor, return the original tree
        return root;
    }

    public static ArrayList<Integer> inOrderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> traversal = new ArrayList<Integer>();
        ArrayList<Integer> left = inOrderTraversal(root.left);
        ArrayList<Integer> right = inOrderTraversal(root.right);

        traversal.addAll(left);
        traversal.add(Integer.valueOf(root.val));
        traversal.addAll(right);
        return traversal;
    }

    public static ArrayList<Integer> preOrderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> traversal = new ArrayList<Integer>();
        ArrayList<Integer> left = preOrderTraversal(root.left);
        ArrayList<Integer> right = preOrderTraversal(root.right);

        traversal.add(Integer.valueOf(root.val));
        traversal.addAll(left);
        traversal.addAll(right);
        return traversal;
    }

    public static ArrayList<Integer> postOrderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        ArrayList<Integer> traversal = new ArrayList<Integer>();
        ArrayList<Integer> left = postOrderTraversal(root.left);
        ArrayList<Integer> right = postOrderTraversal(root.right);

        traversal.addAll(left);
        traversal.addAll(right);
        traversal.add(Integer.valueOf(root.val));
        return traversal;
    }

    public static boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    private static boolean validateBST(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;

        boolean l = false, r = false;

        if (min != null)
            if (node.val <= min)
                l = true;

        if (max != null)
            if (node.val > max)
                r = true;

        if (l || r)
            return false;

        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }

    public static Integer findLCA(TreeNode root, int first, int second) {
        ArrayList<Integer> firstTraversal = new ArrayList<Integer>();
        TreeNode temp = root;
        while (temp != null) {
            firstTraversal.add(Integer.valueOf(temp.val));
            if (temp.val == first)
                break;
            else if (temp.val < first)
                temp = temp.right;
            else
                temp = temp.left;
        }

        ArrayList<Integer> secondTraversal = new ArrayList<Integer>();
        temp = root;
        while (temp != null) {
            secondTraversal.add(Integer.valueOf(temp.val));
            if (temp.val == second)
                break;
            else if (temp.val < second)
                temp = temp.right;
            else
                temp = temp.left;
        }

        for (int i = firstTraversal.size() - 2; i >= 0; i--) {
            for (int j = secondTraversal.size() - 2; j >= 0; j--) {
                if (firstTraversal.get(i) == secondTraversal.get(j))
                    return firstTraversal.get(i);
            }
        }

        return null;
    }
}

class SearchResult {
    boolean found;
    TreeNode parent;
    String position;

    public SearchResult(boolean found, TreeNode parent, String position) {
        this.found = found;
        this.parent = parent;
        this.position = position;
    }

    public boolean getFound() {
        return found;
    }

    public TreeNode getParent() {
        return parent;
    }

    public String getPosition() {
        return position;
    }
}