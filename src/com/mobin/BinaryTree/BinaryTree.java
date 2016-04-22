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
//----------------------------------------非递归---------------------------------------------------------
    //非递归的前序遍历
    //先访问根节点，再访问所有左孩子，再访问所有右孩子（根->左孩子->右孩子）
    public static  void preOrder(Node root){
        Stack<Node> stack = new Stack<Node>();
        if(root != null){
            stack.push(root);   //将根节点入栈
            while(!stack.empty()){
                root = stack.pop();
                System.out.print(root.getValue()+"  ");
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
                    System.out.print(root.getValue()+"  ");   //输出当前根节点
                    root = root.getRight();                //将指针指向右孩子
                }
            }
        }
    }

    //非递归的后序遍历
    //左孩子->右孩子->根节点
    //最近一个节点不入栈直接判断，所以在取下一个元素时，得判断栈顶是否还有元素
    public static  void postOrder(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node pre = null;
        if(root != null){
            while (!stack.empty() || root != null){
                while(root.getLeft() != null){
                    stack.push(root);
                    root = root.getLeft();   //将左孩子全部入栈
                }

                //首先判断当前节点是否存在，再判断其有无右孩子，null表示无右孩子，等于pre表示其右孩子已经访问过了
                //进入while循环表示要输出当前节点，因为都没右孩子的事了
                while (root != null && (root.getRight() ==null || root.getRight() == pre) ){
                    System.out.print(root.getValue()+"  ");   //输出当前节点
                    pre = root;    //标记该节点已经访问过，其实是为了下一次不再进入while循环
                    if(stack.empty())   //判断是栈一是否为空，因为结束遍历是在这个while中的，所以要判断，否则输出完结果会报错
                        return;
                    root =stack.pop();   //弹出当前节点
                }
                //此为有右孩子的情况，为什么又要先push呢，因为有右孩子就要先输出右孩子，就要先把父节点保存下来
                stack.push(root);
                root = root.getRight();  //有右孩子，将指针指向右孩子，接着进入第一个while循环，看这个右孩子有无左孩子
            }
        }

    }

    //----------------------------------------递归---------------------------------------------------------
    //前序遍历
    public static  void preOrder1(Node root){
        if(root != null){
            System.out.print(root.getValue()+"  ");
            preOrder1(root.getLeft());
            preOrder1(root.getRight());
        }
    }

    //中序遍历
    public static  void inOrder1(Node root){
        if(root != null){
            inOrder1(root.getLeft());
            System.out.print(root.getValue()+"  ");
            inOrder1(root.getRight());
        }
    }

    //后序遍历
    public static  void postOrder1(Node root){
        if(root != null){
            postOrder1(root.getLeft());
            postOrder1(root.getRight());
            System.out.print(root.getValue()+"  ");
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(initBinaryTree());
        System.out.println("\n-----------非递归-----------------");
        System.out.println("非递归的前序遍历");
        preOrder(binaryTree.getRoot());

        System.out.println("\n非递归的中序遍历");
        inOrder(binaryTree.getRoot());

        System.out.println("\n非递归的后序遍历");
        postOrder(binaryTree.getRoot());

        System.out.println("\n-----------递归-----------------");
        System.out.println("递归的前序遍历");
        preOrder1(binaryTree.getRoot());

        System.out.println("\n递归的中序遍历");
        inOrder1(binaryTree.getRoot());

        System.out.println("\n非递归的后序遍历");
        postOrder1(binaryTree.getRoot());

    }
}
