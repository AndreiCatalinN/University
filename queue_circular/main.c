/*
Prog description: Implementation of a linear queue.
Date: 15/03/2017
OS: Win 10
Author: Andrei Negura
*/
#include <stdio.h>
#include <stdlib.h>
/* A SIZE of 10 would accept 9 elements into the queue
because the tail always points to the next element.
*/
#define SIZE 10

//Prototypes
void enqueue(int *, int *, int *);
void dequeue(int *,int *);
void menu(char *);

int main()
{
    int i,queue[SIZE], head=0, tail=0;
    char ch[10];
    do
    {

        menu(ch);

        switch(*ch)
        {
            case'1':
            {
                enqueue()
            break;
        }
        case'2':
        {
            break;
        }
        case'3':
        {
            break;
        }
        case'4':
        {
            break;
        }
        default:
        {
            printf("Bad option");
            break;
        }
        }



    }
    while(ch!=4);

    printf("Head: %d Tail: %d\n", head, tail);

    for(i=head; i<tail; i++)
        printf("%d ", *(queue + i ) );

    return 0;
}

void menu(char *ch)
{
    printf("Menu\n"
           "1. Enqueue a element\n"
           "2. Dequeue a element\n"
           "3. Display queue\n"
           "4. Exit\n");
    printf("Enter the option: ");
    scanf("%s" , ch);
}

/*Function to check if the queue is full
And if not, add a element*/

void enqueue(int *a, int *head, int *tail)
{

    if( ( (*tail) +1)%SIZE == *head )
        printf("The queue is full\n");
    else
    {
        printf("Write the element that you want to enqueue: ");
        scanf("%d", &*(a+(*tail)));
        *tail= ( (*tail) +1) %SIZE;
    }
}

/*Function to check if the queue is empty
 And if not, delete a element*/
void dequeue(int *head,int *tail)
{
    if(*head==*tail)
        printf("The queue is empty\n");
    else *head= ( (*head) +1) %SIZE;
}

