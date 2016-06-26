//Ulu Tanrýnýn Adi ile
//Javad Nouri
// Static Model

#include "BinarySearchTree.h"
#define NULL 0
// Default Constructor
BinarySearchTree::BinarySearchTree()
{
	
}

// This constructor creates a BinarySearchTree and sets the data field of its root to "value".
BinarySearchTree::BinarySearchTree(int value)
{
	Root=new BSTNode();
	Root->data=value;
}

// Returns the number of nodes in the tree.
int BinarySearchTree::size()
{
	return getSize(this->Root);
}

int BinarySearchTree::getSize(BSTNode* node){
	if(node==NULL)
		return 0;
	return getSize(node->left)+1+getSize(node->right);
}

// Inserts the given value as node into the tree, but still keeps tree a BinarySearchTree.
void BinarySearchTree::Insert(int data)
{
	BSTNode* newNode=new BSTNode();
	newNode->data=data;
	Root=insertInto(Root, newNode);
}

// Performs an InOrder (Left , theNode, Right) and puts the values in an array and returns a pointer to the first element of the array.
int* BinarySearchTree::InOrderTrace()
{
    int* temp=new int[this->size()];
	int count=0;
	LSR(Root, temp,count);
	return temp;
}

// This method performs the main body of the inorder trace.
void BinarySearchTree::LSR(BSTNode* Node, int* theArray, int &index)
{
	if(Node==NULL)
		return;
	LSR(Node->left,theArray, index);
	theArray[index++]=Node->data;
	LSR(Node->right, theArray, index);
}

BSTNode* BinarySearchTree::insertInto(BSTNode* Node,
									  BSTNode* newNode)
{
	if(Node==NULL)	return newNode;
	if(newNode->data<=Node->data)
		Node->left=insertInto(Node->left, newNode);
	else
        Node->right=insertInto(Node->right,newNode);
	return Node;
}