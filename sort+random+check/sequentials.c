#include <time.h>
#include <stdio.h>
#include <stdlib.h>
//Borland stuff
#define BORLAND flushall(); \
                printf("\nPress Enter to exit\n"); \
                getchar();
//Prototypes
void sort(int *, int );

int main()
{   
    //Get the seed for random
    srand(time(NULL));
    //Declare the variables
    int m,i,j,ok=0;
    int *ptr, *ptr2;
    double time;
    clock_t begin, end;
    //Start counting
    begin=clock();
    //Ask for space
    printf("How many numbers would you \
like to generate? 10, 100 or 1000: ");
    scanf("%d", &m);
    //Allocate
    ptr =(int*)calloc(m,sizeof(int));
    ptr2=(int*)calloc(m,sizeof(int));
    //Check if it was allocated
    if(!ptr)
    {
        printf("Space could not be allocated");
        return 0;
    }
    if(!ptr2)
    {
        printf("Space could not be allocated");
        return 0;
    }
    // Populate the arrays
    for(i=0;i<m;i++)
    {  
        *(ptr +i)=rand();
        *(ptr2+i)=rand();
        printf(" %d  %d\n",*(ptr+i),*(ptr2+i));
    }
    //Sort the 2 arrays
    sort(ptr,m);
    sort(ptr2,m);
    // Print the sorted arrays
    printf("\n Sorted arrays\n");
    for(i=0;i<m;i++)
        printf(" %d  %d\n",*(ptr+i),*(ptr2+i));
    //Print the common numbers
    for(i=0;i<m;i++)
        for(j=0;j<m;j++)
            if(*(ptr+i)==*(ptr2+j))
            {
                ok=1;
                printf(" Match element %d",*( ptr + i));
            }
    
    if(ok==0)
        printf("No matching elements have been found");
    //End the time count
    end=clock();
    //Count time
    time= (end-begin)/CLOCKS_PER_SEC;
    printf("\nThe program run in %.2f seconds",time);
    BORLAND
    return 0;
}//end main

//Sorting algorithm, searches in array a of b elements
void sort(int *a, int b)
{
    int i,j;
    for( i = 0; i < b-1; i++)
        for(j=i + 1; j <= b-1; j++)
            if(*( a + i ) > *( a + j ))
            {
                //Swaping using xor(^) operator
                *( a + i ) = *( a + i ) ^ *( a + j );
                *( a + j ) = *( a + i ) ^ *( a + j );
                *( a + i ) = *( a + i ) ^ *( a + j );
            }
}