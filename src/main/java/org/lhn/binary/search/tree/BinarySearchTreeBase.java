package org.lhn.binary.search.tree;

/**
 * description:二分搜索树基础（logn）
 * 1.高效：查找、插入、删除都是logn
 * 2.还可以回答很多数据之间的关系问题
 * min max floor ceil rank select
 * 查找表的实现--字典数据结构 key--value
 * @author:LiHaiNan
 * @date:2018/7/19 0019 下午 3:59
 */
/**
 *定义：二分搜索树是二叉树，每个节点的键值大于做孩子，小于右孩子，以左右孩子为
 *根的子树仍为二分搜索树。 二分搜索树不一定是一个完全的二叉树
 */
//二分搜索树要有key--value,因为key需要能够进行比较，所以需要extends comparable<T>接口
public class BinarySearchTreeBase<Key extends Comparable<Key>,Value> {
    //属性
    //根节点
    private Node root;
    //树中的节点个数
    private int count;

    //二分搜索树的构造函数，默认构造一颗空的二分搜索树
    public BinarySearchTreeBase() {
        root=null;
        count=0;
    }

    //返回二分搜索树的节点个数
    public int size(){
        return count;
    }
    //返回二分搜索树是否为空
    public boolean isEmpty(){
        return count==0;
    }
    //二分搜索树的节点为私有的类，外界不需要了解二分搜索树节点的具体实现
    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        public Node() {
        }
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
