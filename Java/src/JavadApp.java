/**
 * Ulu Tanrýnýn Adi il?
 * Created by IntelliJ IDEA.
 * User: Javad Nouri
 * Date: Jun 4, 2007
 * Time: 8:12:13 PM     Last Edit: Jun 10, 2007   5:58:22 PM
 * E-mail: javad.xp@gmail.com
 */

//Import Commands:
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class JavadApp extends JFrame{   //This is the test class for the application
    JList lstNumbers;           //The list box which shows the values of the nodes
    JButton btnAdd;             //The button to add the number in txtNumber to the list
    JButton btnRemove;          //The button which removes the selected item from the list
    JButton btnClear;           //The button which removes all the items in the list
    JButton btnDraw;            //The button which will draw the Tree on the Frame and will get the sorted sequence
    JTextField txtNumber;       //Input point for the numbers
    JPanel pnl;                 //a Panel
    JTextArea txtSorted;        //Text Area which will present the sorted integers

    Vector<intHolder> x;        //This Vector object holds the data for the nodes

    //Default Constructor:
    JavadApp(){
        super("Binary Search Tree");        //Set the title of the window

        x=new Vector<intHolder>();          //initialize x
        pnl=new JPanel();                   //initialize pnl

        lstNumbers=new JList();             //initialize lstNumbers
        lstNumbers.setLocation(0,0);        //Set the location of lstNumbers on the frame
        lstNumbers.setSize(110,170);        //Set the dimensions of lstNumbers
        JScrollPane tp=new JScrollPane(lstNumbers); //Create a scrollbar and link it to lstNumbers
        tp.setLocation(0,0);
        tp.setSize(110,170);
        add(tp);                            //Add the scrollbar to the frame

        btnAdd=new JButton("Add");          //initialize btnAdd and set its caption to "Add"
        btnAdd.setLocation(120,35);
        btnAdd.setSize(100,30);
        //I have used inner classes to create the event handlers
        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){ //This method will be invoked when btnAdd is pressed
                x.add(new intHolder(Integer.parseInt(txtNumber.getText())));    //Add the integer value of the text box
                                                                                //to the data list vector
                lstNumbers.setListData(x);  //update the list box
                txtNumber.selectAll();      //Select all the characters in the text box
                txtNumber.grabFocus();      //Set focus on txtNumber
            }
        });

        txtSorted=new JTextArea();
        txtSorted.setLocation(0,180);
        txtSorted.setSize(220, 200);
        txtSorted.setText("Click On Draw to draw the Tree\nand see the sorted sequence...");

        txtNumber=new JTextField(5);
        txtNumber.setLocation(120,0);
        txtNumber.setSize(100, 30);


        btnRemove = new JButton("Remove");
        btnRemove.setLocation(120, 70);
        btnRemove.setSize(100, 30);

        //Ýnner class'dan faydalanmaqý yuxarýda izah etmiþ?m
        btnRemove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                int index=lstNumbers.getSelectedIndex();    //Get the selected index in the listbox
                if(index>=0){       //If there is anything selected then
                    x.remove(index);    //remove the selected item from the data list
                    lstNumbers.setListData(x);  //update the list
                    lstNumbers.setSelectedIndex(index-1);   //select the previous item
                }
                lstNumbers.grabFocus();     //Focus on lstNumbers
            }
        }
        );
        btnClear = new JButton("Clear");
        btnClear.setLocation(120, 105);
        btnClear.setSize(100, 30);
        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                x.clear();                  //Empty the data list
                lstNumbers.setListData(x);  //update the lstNumbers
                txtNumber.grabFocus();      //Focus on txtNumber
            }
        }
        );

        btnDraw=new JButton("Draw");
        btnDraw.setLocation(120,140);
        btnDraw.setSize(100,30);

        btnDraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                BinarySearchTree bst=new BinarySearchTree();    //create and initialize a BinarySearchTree object
                for (intHolder aX : x) {
                    bst.Insert(aX.value);   //Insert the integers in the data list one by one
                }

                getGraphics().clearRect(240,0,getWidth(), getHeight());     //Preparing the canvas
                getGraphics().drawRect(240,0,getWidth(), getHeight());      //""""""""""""""""""""
                bst.drawTree(getGraphics(), 240,40,getWidth(),20);          //Draw the tree on the frame
                int sortedArray[]=bst.InOrderTrace();                       //Trace the tree and put the results in sortedArray
                                                                            //the result are sorted by default
                String labelText="Sorted Sequence Using InOrder Trace:\n";
                for (int i=0 ; i<sortedArray.length ; i++) {
                    labelText+=sortedArray[i]+((i+1)%6==0 ? "\n" : "     ");  //output the results
                }
                txtSorted.setText(labelText);

            }
        }
        );
        //Add the GUI elements
        add(txtNumber);
        add(btnAdd);
        add(btnRemove);
        add(btnClear);
        add(btnDraw);
        add(txtSorted);
        add(pnl);
        pnl.setVisible(false);
        //Maximize the window
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        //Show the window
        setVisible(true);
    }

    //This is the starting point for the application
    public static void main(String[] args) {
        JavadApp app=new JavadApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

