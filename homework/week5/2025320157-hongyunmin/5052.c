#include<stdio.h>
#include<stdlib.h>

int is_consistency;

typedef struct Node{
    struct Node* children[10];
    int is_last;
}Node;

Node* init_node(){
    Node* new_node = (Node*)malloc(sizeof(Node));
    for(int i = 0; i < 10; i++){
        new_node->children[i] = NULL;
    }
    new_node->is_last = 0;
    return new_node;
}

int is_leaf(Node* node){
    for(int i = 0; i < 10; i++){
        if(node->children[i] != NULL){
            return 0;
        }
    }
    return 1;
}

void insert(Node* node, char phone_number[]){
    for(int i = 0; phone_number[i] != '\0'; i++){
        if(node->is_last){
            is_consistency = 0;
            break;
        }
        if(node->children[phone_number[i] - '0'] == NULL){
            node->children[phone_number[i] - '0'] = init_node();
        }
        node = node->children[phone_number[i] - '0'];
    }
    if(!is_leaf(node)){
        is_consistency = 0;
    }
    node->is_last = 1;
}

int main(){
    int testcase;
    scanf("%d", &testcase);
    for(int t = 0; t < testcase; t++){
        Node* root = init_node();
        int num_numbers;
        scanf("%d", &num_numbers);

        is_consistency = 1;
        for(int i = 0; i < num_numbers; i++){
            char phone_number[11];
            scanf(" %s", phone_number);
            insert(root, phone_number);
        }
        printf(is_consistency ? "YES\n" : "NO\n");
    }

    return 0;
}