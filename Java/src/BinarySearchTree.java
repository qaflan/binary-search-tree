/**
 * Ulu Tanrýnýn Adi il?
 * Created by IntelliJ IDEA.
 * User: Javad Nouri
 * Date: Jun 4, 2007
 * Time: 6:08:22 PM
 * E-mail: javad.xp@gmail.com
 */

//import commands:
import java.awt.*;

//This is the heart of our application:
public class BinarySearchTree {
    private BSTNode root;       //The root node of the tree
    BinarySearchTree(){}        //Default constructor
    BinarySearchTree(int d){    //Constructor
        root=new BSTNode();         //Create a Tree with root value 'd'
        root.data = d;
    }
    public int size(){          //returns the number of nodes in the tree
        return sizeOfSubTree(root); //uses the private recursive function sizeOfSubTree
    }
    private int sizeOfSubTree(BSTNode node){
        //Recursion is very helpful here, in most methods for binary trees I have used a recursive solution
        if(node==null)  return 0;       //Base Case: an empty tree has size 0
        return sizeOfSubTree(node.left)+1+sizeOfSubTree(node.right);    //otherwise calculate the size of its childs and                                                                     //return the result+1 (1 for thr current node to be counted;
    }
    public int maxDepth(){          //Returns the number of nodes along the longest path from the root to the leaves
        return depthOfSubTree(root);    //This also uses a recursive helper method
    }
    private int depthOfSubTree(BSTNode Node){
        //yenid?n Recursion
        if(Node==null)  return 0;       //Base case: the depth of anempty tree is 0
        else{
            int lDepth,rDepth;
            lDepth=depthOfSubTree(Node.left);   //the maximum depth along the left child
            rDepth=depthOfSubTree(Node.right);  //the maximum depth along the right child
            return (rDepth>lDepth ? rDepth+1 : lDepth+1);   //return the maximum of lDepth and rDepth +1 (again 1 for the sake of current node
        }
    }
    public void Insert(int value){  //Insert a new integer into its right position in the tree
        BSTNode temp=new BSTNode(); //Create a new Node
        temp.data = value;          //set the value for the node
        root=insertInto(root,temp); //use a recursive method
    }

    private BSTNode insertInto(BSTNode Node, BSTNode newNode ){
        if(Node==null)  return newNode;     //Base case: if the tree is empty set newNode to be the root for this [sub]tree
        if(newNode.data<=Node.data){        //Otherwise if the new value is less than the current node's data
            Node.left = insertInto(Node.left, newNode);     //add it to the leftern subtree
        }
        else{
            Node.right = insertInto(Node.right, newNode);   //Otherwise, add it to the rightern subtree
        }
        return Node; //return the unchanged reference
    }
    public int[] InOrderTrace(){        //Trace the tree using Inorder trace method(Depth First Search, Left , Self , Right)
        int temp[]=new int[this.size()];    //create a new int array of size this.size();
        intHolder count=new intHolder();    //Create a counter of type intHolder, this reference is used in the next method
                                            //  to locate where the visited node is going to be saved in the array
        LSR(root, temp, count);             //Use the recursive function LSR to trace the tree starting rom node LSR: Left Self Right
        return temp;                        //Return a reference to the array of results
    }
    private void LSR(BSTNode Node, int theArray[],intHolder count){
        if(Node==null)  return;             //if the node is null then the Tracing is over
        LSR(Node.left, theArray, count);    //else trace the left subtree
        theArray[count.Addpp()]=Node.data;  //visit the current node and increase count one unit
        LSR(Node.right, theArray, count);   //Trace the right subtree
    }
    public void drawTree(Graphics g, int x1, int y1, int x2, int y2 )
    {
        //This method also uses a recursive helper method
        draw(g, root,x1,y1,x2, y2);
    }
    public void drawTree(Graphics g)        //Ovwerloaded method
    {
        drawTree(g ,0,40,800, 20);
    }
    private void draw(Graphics g,BSTNode Node,int x1,int y1,int x2,int y2){
        //This function draws each node recursively, I'll fully explain it in the pdf file
        //and I'll also tell you about the way I calculate the location for the nodes
        if(Node==null) return;  //Base case: if Node is null, the drawing process is over

        //These parts will be explained later
        int c=700/this.maxDepth();
        g.setColor(new Color(0,0,0));
        if(Node.left!=null) g.drawLine((x1+x2)/2,(root==Node ?  50 : y2),(x2+3*x1)/4, y2+c);
        if(Node.right!=null) g.drawLine((x1+x2)/2,(root==Node ?  50 : y2),(3*x2+x1)/4, y2+c);
        g.setColor(new Color(0,0,255));
        g.drawString(Integer.toString(Node.data), (x1+x2)/2,(root==Node ?  50 : y2));
        draw(g,Node.left,x1,y1, (x2+x1)/2,y2+c);
        draw(g, Node.right, (x2+x1)/2, y1, x2, y2+c);

    }
}
