#include <stdio.h>
#include <stdlib.h>
#define SIZE 10

/*A void pointer can hold any type of data
such as int, float, char, struct
CANNOT be dereferenced directly(*ptr)
*/
/*
Function to compare 2 elements of
the same type(char, int, float, struct
              Returns a value >0 if a>b
              Returns 0 if a==b
              Returns a value <0 if a<b
that's why i have the casting
And it is int because, if it is char it uses ascii, if it is a adress
it converts it to decimal.
Always the same.
General purpose
*/
int cmpfunc (const void * a, const void * b)
{
    return ( *(int*)a - *(int*)b );
}

int main()
{
    int n;
    int values[SIZE] = { 1,1,1,1,88,1, 56, 100, 2, 25 };

    printf("Before sorting the list is: \n");
    for( n = 0 ; n < SIZE; n++ )
    {
        printf("%d ", values[n]);
    }
    /*Quick sort algorithm,
     value is the array
     SIZE is the SIZE of value
     sizeof is the type of the array
     cmpfunc is the comparing function.
    */
    qsort(values, SIZE, sizeof(int), cmpfunc);

    printf("\nAfter sorting the list is: \n");
    for( n = 0 ; n < SIZE; n++ )
    {
        printf("%d ", values[n]);
    }

    return 0;
}
