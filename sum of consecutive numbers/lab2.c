#include <stdio.h>
#include <time.h>

int main()
{
    clock_t start, stop;
    start=clock();
    int i,j, s=0;
    double time;
    printf("\nUntil what number would you like to add:");
    scanf("%d", &j);
    //First element=fel
    if(fel==0)
        s=(j*(j-1))/2;
    else
        s=(j*(j+1))/2;
    stop=clock();
    time=(double)(stop-start)/CLOCKS_PER_SEC;

    printf("The sum is: %d and it has been run for %f seconds",s, time);
    f
    getchar();
    return 0;
}
