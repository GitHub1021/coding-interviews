package Chap7;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵普通树的两个结点，返回它们的最低公共祖先。
 */
public class LastSameInTree {

    private class Node {
        List<Node> children;
        int val;
    }

    public Node findLastSame(Node root, Node a, Node b) {
        if (root == null || a == null || b == null) return null;

        LinkedList<Node> path1 = new LinkedList<>();
        LinkedList<Node> path2 = new LinkedList<>();
        
         LinkedList<Node> res1 = new LinkedList<>();
         LinkedList<Node> res2 = new LinkedList<>();
        collectNode(root, a, path1, res1);
        collectNode(root, b, path2, res2);
        return getLastSameNode(path1, path2);
    }

    /**
     * 收集含有结点node的路径上的所有结点，形成一条链表
     */
    private void collectNode(Node root, Node node, LinkedList<Node> path, LinkedList<Node> res) {
        if (root == null || node == null) return;
        path.add(root);
        if (root = node) {
            res.addAll(path);
        }
        for (Node child : root.children) {
            if (collectNode(child, node, path));
        }
        // 该条路径上没找到结点node就要从路径中移除
        path.remove(path.size() - 1);
    }

    /**
     * 两个链表前面的结点都是相同的，找到最后一个相同的结点就是最低公共祖先
     */
    private Node getLastSameNode(LinkedList<Node> path1, LinkedList<Node> path2) {
        Node lastSameNode = null;
        while (!path1.isEmpty() && !path2.isEmpty()) {
            if (path1.peekFirst() == path2.removeFirst()) {
                lastSameNode = path1.removeFirst();
            } else {
                return lastSameNode;
            }
        }
        return lastSameNode;
    }
}
