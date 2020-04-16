/**
Program description: initializes a 2 dimensions array with values of 5
Then initializes the diagonals values with values of 0
After that initializes the center rows with values of 1
In the end initializes the corners of the array with values of 2
Prints the number of times the elements 0, 1, 2, 5 have appeared
Author: Andrei Negura
OS: win 7
Date 05/12/2016

*/

#include <stdio.h>

// Sizes of the array
#define SIZE 5

int main()
{
    // For the array
    int a[SIZE][SIZE];
    int i,j;

    //variables for counting the numbers
    int count0=0, count1=0, count2=0, count5=0;

    //initialize the whole array with the value 5
    for(i=0;i<SIZE;i++)
        for(j=0;j<SIZE;j++)
            *(*(a+i)+j))=5;

    //initialize the diagonals with 0
    for(i=0;i<SIZE;i++)
        for(j=0;j<SIZE;j++)
            if(i==j || i+j==SIZE-1)
                *(*(a+i)+j))=0;

    //initialize the center lines with 1
    for(i=0;i<SIZE;i++)
        for(j=0;j<SIZE;j++)
            if(i==SIZE/2 || j==SIZE/2)
                *(*(a+i)+j))=1;

    //initialize the corners with 2
    for(i=0;i<SIZE;i++)
        for(j=0;j<SIZE;j++)
            if((i==0 && j==0) ||
               (i==0 && j==SIZE-1) ||
               (i==SIZE-1 && j==SIZE-1)||
               (i==SIZE-1 && j==0) )
                *(*(a+i)+j))=2;

    //count every number to see how many times it appears.
    for(i=0;i<SIZE;i++)
        for(j=0;j<SIZE;j++)
            switch(*(*(a+i)+j)))
            {
                case 0:
                {
                    count0++;
                    break;
                }
                case 1:
                {
                    count1++;
                    break;
                }
                case 2:
                {
                    count2++;
                    break;
                }
                default:
                {
                    count5++;
                    break;
                }
            }//end switch

    // Display the number of times the numbers 0, 1, 2, 5 appeared
    printf("Number 0 appears %d times.\n", count0);
    printf("Number 1 appears %d times.\n", count1);
    printf("Number 2 appears %d times.\n", count2);
    printf("Number 5 appears %d times.\n", count5);

    // Array print
    for(i=0;i<SIZE;i++)
        {
            for(j=0;j<SIZE;j++)
                printf("%d ", *(*(a+i)+j)));
            printf("\n");
        }

    getchar();

    return 0;
}
