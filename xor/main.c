
/**
Prog description: Xor learning
Author: Andrei Negura
Os: win 10
Date: 22/01/2017

10=   00001010
12=   00001100
a=6=  00000110

6=    00000110
10=   00001010
b=12= 00001100

6=    00000110
12=   00001100
a=10= 00001010

  0 0 | 0
  0 1 | 1
  1 0 | 1
  1 1 | 0

*/

#include <stdio.h>
#include <stdlib.h>

int main()
{

    int a=12,b=10;
    //Interschimbare intre doua valori

    a=a^b;  /// Creaza un numar foarte diferit
    printf("a=%d b=%d\n",a,b);
    b=a^b;
    printf("a=%d b=%d\n",a,b);
    a=a^b;

    printf("a=%d b=%d",a,b);



    return 0;
}
