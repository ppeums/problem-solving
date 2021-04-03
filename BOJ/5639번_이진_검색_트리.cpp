// 시간복잡도 O(N^2) (N: 노드수)

#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

struct node {
	node* left;
	node* right;
	int value;
};

node* root;

node* insert(node* root, int n) {
	if (root == nullptr) {
		root = new node();
		root->left = root->right = nullptr;
		root->value = n;
	}
	else if (n < root->value) {
		root->left = insert(root->left, n);
	}
	else if (n > root->value) {
		root->right = insert(root->right, n);
	}
	return root;
}

void postorder(node* root) {
	if (root != nullptr) {
		postorder(root->left);
		postorder(root->right);
		printf("%d\n", root->value);
	}
}

int main()
{
	int n;

	root = nullptr;

	while (scanf("%d", &n) != EOF) {
		root = insert(root, n);
	}

	postorder(root);

	return 0;
}
