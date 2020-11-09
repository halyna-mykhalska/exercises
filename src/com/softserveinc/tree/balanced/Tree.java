package com.softserveinc.tree.balanced;

public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    private class Result {
        private boolean isBalanced;
        private int height;

        private Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    private Result isBalancedRecursive(Tree tree, int depth) {
        if (tree == null) {
            return new Result(true, -1);
        }

        Result leftSubtreeResult = isBalancedRecursive(tree.left(), depth + 1);
        Result rightSubtreeResult = isBalancedRecursive(tree.right(), depth + 1);

        boolean isBalanced = Math.abs(leftSubtreeResult.height - rightSubtreeResult.height) <= 1;
        boolean subtreesAreBalanced = leftSubtreeResult.isBalanced && rightSubtreeResult.isBalanced;
        int height = Math.max(leftSubtreeResult.height, rightSubtreeResult.height) + 1;

        return new Result(isBalanced && subtreesAreBalanced, height);
    }

    private Tree right() {
        return right;
    }

    private Tree left() {
        return left;
    }

    public boolean isBalanced() {
        return isBalancedRecursive(this, -1).isBalanced;
    }

    /* Function to do preorder traversal of tree */
    void preOrder(Tree node)
    {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    public static void main(String[] args) {
        Tree tree = new Tree(1,
                new Tree(2, new Tree(4, null,null), null),
                new Tree(3,
                        new Tree(5, null, null),
                        new Tree(6, null, null)
                )
        );
        System.out.println(tree.isBalanced());
        tree.preOrder(tree);
    }
}

