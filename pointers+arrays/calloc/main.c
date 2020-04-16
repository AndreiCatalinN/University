/**
Program description: Program to work with calloc, realloc and free.
Author:Andrei Negura
Date: 19/01/2017
Os: win 10
*/

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, *p,i, addon;
    char response[3];

    //Number of elements
    printf("How many numbers would you like to enter: ");
    scanf("%d", &n);

    //Memory allocation
    p=(int)calloc(n, sizeof(int));

    //Check if itwas allocated
    if(p==NULL)
        printf("Error, did not allocate the space");
    else
    {   //Read the numbers
        printf("Please enter the numbers: ");
        for(i=0; i<n; i++)
            scanf("%d", &*(p+i));

        //Ask if the use would like to read some more numbers
        printf("Would you like to add more?\n");
        scanf("%s", response);
        if(strcmp(response, "Yes")==0 || strcmp(response, "yes")==0 || strcmp(response, "y")==0)
        {
            printf("How many numbers would you like to ad: ");
            scanf("%d", &addon);
            //Add the numbers to the existing ones
            n=n+addon;
            p=realloc(p, n*sizeof(int));
            if(p==NULL)
                printf("Error, did not allocate the space");
            else
            {
                //Read the extra numbers
                printf("Please enter the numbers: ");
                for(; i<n; i++)
                scanf("%d", &*(p+i));
            }
        }
        else
            printf("The list remains unchanged.\n");

    }

    //Print the numbers
    for(i=0; i<n; i++)
        printf("*%d*",*(p+i));
    //free the memory
    free(p);
    return 0;
}
