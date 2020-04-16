/*
Program description: Program that uses binary search
Author: Andrei Negura
Os: win 7 
Date: 14/02/2017
*/

#include <stdio.h>
#include <time.h>

int main()
{
    clock_t begin, end;
    begin=clock();
    double time;
    int c, first, last, middle, n, search, array[100];
    
    //Number of elements in the array
    printf("Enter number of elements: ");
    scanf("%d",&n);
    
    //Array reading
    printf("Enter %d integers\n", n);
    for (c = 0; c < n; c++)
        scanf("%d",&*(array+c));
 
    printf("Enter value to find: ");
    scanf("%d", &search);
    //Prepare for binary search
    first = 0;
    last = n - 1;
    middle = (first+last)/2;
 
    // Actaul binary search
    while (first <= last) 
    {
        if (array[middle] < search)
            first = middle + 1;    
        else
            if (array[middle] == search)
            {
                printf("%d found at location %d.\n", search, middle+1);
                break;
            }
            else
                last = middle - 1;
        middle = (first + last)/2;
    }
    //If the element was not found...
    if (first > last)
        printf("Not found! %d is not present in the list.\n", search);
    
    //Time check
    end=clock();
    time=(double)(end-begin)/CLOCKS_PER_SEC;

    printf("The program has run for %f seconds", time);
    //Borland stuff.   'o.o
    flushall();
    getchar();
    return 0;   
}//End main
