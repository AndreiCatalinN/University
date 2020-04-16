#include <stdio.h>


void read(int *);
int main()
{
    int a[4],i;
    read(a);
    for(i=0;i<4;i++)
        printf("%c ",*(a+i));
    return 0;
}

//Function to read the code
void read(int *a)
{
	register int i;
	for(i=0;i<4;i++)
		*(a+i)=getchar();
}
