package com.app.gfg_potd;

import com.app.dsa.model.gfg.tree.Node;

public class e8_36_14 {
    public static Node getSubtree(int[] inorder, int[] preorder, int start, int end, int preStart) {
        if (start > end) {
            return null;
        }
        Node root = new Node(preorder[preStart]);

        int inorderIndex = getInorderIndex(inorder, preorder, start, end, preStart);
        root.left = getSubtree(inorder, preorder, start, inorderIndex - 1, preStart + 1);
        root.right = getSubtree(inorder, preorder, inorderIndex + 1, end, inorderIndex + 1);

        return root;
    }

    private static int getInorderIndex(int[] inorder, int[] preorder, int start, int end, int preX1) {
        for (int i = start; i < end; i++) {
            if (preorder[preX1] == inorder[i]) {
                return i;
            }
        }
        return end;
    }

    public static Node buildTree(int inorder[], int preorder[]) {
        return getSubtree(inorder, preorder, 0, inorder.length - 1, 0);
    }

    public static void main(String[] args) {
        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};
        buildTree(inorder, preorder);
    }
}
