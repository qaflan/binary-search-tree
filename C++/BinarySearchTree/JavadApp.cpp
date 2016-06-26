//Ulu Tanrýnýn Adi ile
//Javad Nouri

#include "BinarySearchTree.h"
#include <iostream>
using namespace std;
int main(){
	BinarySearchTree bst;
	int* a;
	cout<<"Enter integers and press Enter:\n";
	for(int i=0 ; i<10 ; i++)
	{
		int x;
		cin>>x;
		bst.Insert(x);
	}
	cout<<"\nSize: "<<bst.size()<<endl;
    a=bst.InOrderTrace();
    for(int i=0 ; i<10 ; i++)
		cout<<a[i]<<"\t";
	delete[] a;
	return 0;
}