/*
Program description: Program to use a stack
PUSH(insert operation)
POP(delete operation)
Author: Andrei Negura
Os: win 7
Date: 20/02/2017
*/
#include <stdio.h>
#define SIZE 69
#define BORLAND flushall();\
                printf("Press Enter to exit");\
                getchar(); \
                return 0;

//Prototypes

void push(int *, int* );
void pop( int *);
int main()
{
    int element=-1, stack[SIZE],i;
    
    push(stack, &element);
    push(stack, &element);
    push(stack, &element);
    pop( &element);
    printf("\n");
    for(i=0;i<=element;i++)
        printf("%d \n", *(stack+i));
    BORLAND
}

//Function to add a element to the stack
void push(int *s, int *top)
{
    if(*top==SIZE-1)
        printf("Stack is full");
    else
    {
        printf("Enter element to be pushed: ");
        (*top)++;
        scanf("%d", &*(s+(*top)));
    }
}  

void pop(int *top)
{
    if(*top==-1)
        printf("Stack is empty");
    else
        (*top)--;
}



