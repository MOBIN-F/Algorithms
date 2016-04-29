package com.mobin.BinaryTree;

/**
 * Created by Mobin on 2016/4/22.
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    //创建二叉树
    public static Node initBinaryTree(){
        Node node93 = new Node(93);
        Node node37 = new Node(37);
        Node node51 = new Node(51);
        Node node73 = new Node(73);
        Node node6 = new Node(6);
        Node node35 = new Node(35,null,node37);
        Node node99 = new Node(99,node93,null);
        Node node47 = new Node(47,node35,node51);
        Node node88 = new Node(88,node73,node99);
        Node node58 = new Node(58,node47,null);
        Node root = new Node(62,node58,node88);
        return  root;
    }

    //查找
    public static  boolean searchKey(Node node,int key){
              if(node == null){   //没有找到返回false
                  return false;
              }
             else  if(node.getValue() == key)   //成功找到返回true
                  return true;
             else if(key < node.getValue())
                 return searchKey(node.getLeft(),key);   //key小于当前节点，说明key在当前节点的左边
            else
                  return  searchKey(node.getRight(),key);   //key大于于当前节点，说明key在当前节点的右边
    }

    //插入
    public static  boolean insertKey(Node node,int key){
         if(node == null){
             Node node1 = new Node(key);
             node1.setValue(key);
             node1.setLeft(null);
             node1.setRight(null);
             return true;
         }
         else if(key == node.getValue())
             return false;
        else if(key < node.getValue())
             return insertKey(node.getLeft(),key);
        else
             return insertKey(node.getRight(),key);
    }
    /*
    *1.若删除的节点是叶子节点，就直接删除
    *2.若待删除的节点只有左孩子，删除后可将左孩子的根节点直接放在被删除的节点上
    *3.若删除的节点只有右孩子，删除后可将右孩子的根节点直接放在被删除的节点上
    *4.若删除的节点有左孩子又有右孩子，在左孩子中选择最大的节点上移到删除的节点上，上移后其原来的左子树改为上移节点的右子树
    * 或在右子树选择最小节点（最左节点）上移到删除节点的位置上，上移后
    * */
    public Node remove(int t,Node node)
    {
        if(node == null)
            return node;//没有找到,doNothing
        if(t > node.value)
            node.right = remove(t,node.right);
        else if(t < node.value)
            node.left = remove(t,node.left);
        else if(node.left!=null&&node.right!=null)
        {
            node.value = findMin(node.right).value;
            node.right = remove(node.value,node.right);
        }
        else
            node = (node.left!=null)?node.left:node.right;
        return node;

    }

    /**查询出最小元素所在的结点*/
    public Node findMin(Node node)
    {
        if(node==null)
            return null;
        else if(node.left==null)
            return node;
        return findMin(node.left);//递归查找
    }

    public static Node removeLR(Node node, Node r){ //在左孩子中查找最右节点,node是要删除的节点,left
        Node parent = null;
        if(r.getRight() != null) {
            parent = r;
            removeLR(node, r.getRight());//递归最右下节点，找到最右节点
        }
        else{
            node.setValue(r.getValue());  //将最右节点的值赋给要删除的节点，left.getValue()为最右节点的值
           node.setLeft(r.getLeft());
        }
        return  node;
    }


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(initBinaryTree());
//        System.out.println(binarySearchTree.searchKey(binarySearchTree.getRoot(),3));
//        System.out.println(binarySearchTree.insertKey(binarySearchTree.getRoot(),100));
//        System.out.println(binarySearchTree.searchKey(binarySearchTree.getRoot(),100));
        System.out.println(binarySearchTree.remove(35,binarySearchTree.getRoot()));


    }
}
