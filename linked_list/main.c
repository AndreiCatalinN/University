/*
Prog description:  Given an array a[] of N distinct integers,
finds a local minimum: an index is such that a[i] < a[i+1] < a[i+2].
The program should use ~2lg N compares in the worst case.
*/
#include <stdio.h>
#include <stdlib.h>
#define SIZE 10
#define BORLAND flushall(); \
                printf("Press enter to exit"); \
                getchar(); \
                return 0;

struct link
{
    int val;
    struct link *next;
};
typedef struct link* node;

void add_node(node);
int check(node);

int main()
{
    node head=NULL;
    node go=NULL;

    int n, first=0;
    register int i;

    //Assign the head a value
    //head=(struct link *)malloc(sizeof(struct link ));
    //head->val=0;
    //  Next link is to null

    //Put go at the very beginning


    printf("How many numbers would you like to enter?\n");
    scanf("%d", &n);
    printf("Enter %d elements\n", n);
    for(i=0;i<n;i++)
    {
        go=(node)malloc(sizeof(struct link));
        printf("Enter number %d\n", i+1);
        scanf("%d", &go->val);
        go=go->next;

        if(check(go)==0)
            return 0;
        if(first==0)
        {
            head=go;
            first=1;
        }
    }

    go=head;
    //printf("%d", go->val);
    while(go!=NULL)
    {
        printf("%d ", go->val);
        go=go->next;
    }
    return 0;
}

void add_node(node go)
{
    go=(node)malloc(sizeof(struct link));
    //*go=(*go)->next;
    scanf("%d", &go->val);
    go=go->next;
}
int check(node ptr)
{
    if(ptr==NULL)
    {
        printf("\nMemory could not be allocated\n");
        return 0;
    }
    return 1;
}
/*
void del_node(struct link **go)
{

}*/
