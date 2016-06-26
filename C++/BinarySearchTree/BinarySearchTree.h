//Ulu Tanrýnýn Adi ile
//Javad Nouri
// Static Model


#ifndef __BINARYSEARCHTREE__
#define __BINARYSEARCHTREE__


// Include files
#include "BSTNode.h"
class BinarySearchTree
{

private:

	// This is a pointer to the first node in the tree (the root)
	int getSize(BSTNode*);
	BSTNode* Root;

public:

	// Default Constructor
	BinarySearchTree();

	// This constructor creates a BinarySearchTree and sets the data field of its root to "value".
	BinarySearchTree(int value);

	// Returns the number of nodes in the tree.
	int size();

	// Inserts the given value as node into the tree, but still keeps tree a BinarySearchTree.
	void Insert(int data);

	// Performs an InOrder (Left , theNode, Right) and puts the values in an array and returns a pointer to the first element of the array.
	int* InOrderTrace();

private:

	// This method performs the main body of the inorder trace.
	void LSR(BSTNode* Node, int* theArray, int &index);

	BSTNode* insertInto(BSTNode* Node, BSTNode* newNode);

};// END CLASS DEFINITION BinarySearchTree

#endif // __BINARYSEARCHTREE__
