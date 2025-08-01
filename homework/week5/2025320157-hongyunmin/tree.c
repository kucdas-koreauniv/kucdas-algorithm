#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
    int value;
    struct Node* left;
    struct Node* right;
}Node;

Node* init_node(int);
void preorder(Node*);
void inorder(Node*);
void postorder(Node*);

int main(){
    Node* one = init_node(1);
    Node* two = init_node(2);
    Node* three = init_node(3);
    Node* four = init_node(4);

    one->left = two;
    one->right = three;
    two->left = four;

    preorder(one);
    printf("\n");
    inorder(one);
    printf("\n");
    postorder(one);

    return 0;
}

Node* init_node(int value){
    Node* node = (Node*)malloc(sizeof(Node));
    node->value = value;
    node->left = NULL;
    node->right = NULL;
}

void preorder(Node* node){
    printf("%d ", node->value);
    if(node->left != NULL){
		preorder(node->left);
    }
	if (node->right != NULL){
		preorder(node->right);
    }
}

void inorder(Node* node){
    if(node->left != NULL){
		inorder(node->left);
    }
	printf("%d ", node->value);
    if (node->right != NULL){
		inorder(node->right);
    }
}

void postorder(Node* node){
    if(node->left != NULL){
		postorder(node->left);
    }
	if (node->right != NULL){
		postorder(node->right);
    }
    printf("%d ", node->value);
}