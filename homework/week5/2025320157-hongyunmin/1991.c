#include<stdio.h>
#include<stdlib.h>

typedef struct Node{
    int value;
    struct Node* left;
    struct Node* right;
}Node;

Node* init_node(int);
void insert_node(Node*, Node*);
void preorder(Node*);
void inorder(Node*);
void postorder(Node*);

int main(){
    int num_node;
    scanf("%d", &num_node);
    
    char parent, left_c, right_c;
    scanf(" %c %c %c", &parent, &left_c, &right_c);
    Node* root = init_node(parent);
    root->left = init_node(left_c);
    root->right = init_node(right_c);

    for(int i = 1; i < num_node; i++){
        scanf(" %c %c %c", &parent, &left_c, &right_c);
        Node* tmp = init_node(parent);
        tmp->left = init_node(left_c);
        tmp->right = init_node(right_c);

        insert_node(root, tmp);
    }

    preorder(root);
    printf("\n");
    inorder(root);
    printf("\n");
    postorder(root);
    printf("\n");

    return 0;
}

Node* init_node(int value){
    Node* node = (Node*)malloc(sizeof(Node));
    node->value = value;
    node->left = NULL;
    node->right = NULL;
    return node;
}

void insert_node(Node* node, Node* tmp){
    if(node->left == NULL){
        return;
    }
    if(node->right == NULL){
        return;
    }
    if(node->left->value == tmp->value){
        free(node->left);
        node->left = tmp;
    }
    else if(node->right->value == tmp->value){
        free(node->right);
        node->right = tmp;
    }
    insert_node(node->left, tmp);
    insert_node(node->right, tmp);
}

void preorder(Node* node){
    if(node->value != '.'){
        printf("%c", node->value);
    }
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
	if(node->value != '.'){
        printf("%c", node->value);
    }
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
    if(node->value != '.'){
        printf("%c", node->value);
    }
}