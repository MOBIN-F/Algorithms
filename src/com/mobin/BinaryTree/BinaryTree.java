package com.mobin.BinaryTree;

import java.util.Stack;

/**
 * Created by Mobin on 2016/4/21.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    //创建二叉树
    public static Node initBinaryTree(){
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4,node8,null);
        Node node3 = new Node(3,node6,node7);
        Node node2 = new Node(2,node4,node5);
        Node root = new Node(1,node2,node3);
        return  root;
    }

    //非递归的前序遍历
    //先访问根节点，再访问所有左孩子，再访问所有右孩子（根->左孩子->右孩子）
    public static  void preOrder(Node root){
        Stack<Node> stack = new Stack<Node>();
        if(root != null){
            stack.push(root);   //将根节点入栈
            while(!stack.empty()){
                root = stack.pop();
                System.out.print(root.getValue()+" ");
                if(root.getRight() != null)      //判断当前节点是否有右孩子
                    stack.push(root.getRight());

                if (root.getLeft() != null)     //判断当前节点是否有右孩子
                    stack.push(root.getLeft());  //为什么left放在后面呢，因为前序遍历的规则和栈的结构，后入的先栈
            }
        }
    }

    //非递归的中序遍历
    //（左孩子->根->右孩子）
    public static  void inOrder(Node root){
        Stack<Node> stack = new Stack<Node>();
        if (root != null){
            while (!stack.empty() || root != null){ //判断当前栈是否为空否有无根节点
                while(root != null){
                    stack.push(root);   //第一次将根节点入栈。之后将左孩子入栈
                    root = root.getLeft();
                }
                //到此这里的所有左孩子都已入栈

                if (!stack.empty()){
                    root = stack.pop();
                    System.out.println(root.getValue());
                    root = root.getRight();
                }
            }//-----------------------------------
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(initBinaryTree());
        System.out.println("非递归的前序遍历");
        preOrder(binaryTree.getRoot());

        System.out.println("非递归的中序遍历");
        inOrder(binaryTree.getRoot());

    }
}
