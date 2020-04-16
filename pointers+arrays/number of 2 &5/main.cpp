/*
Program description: In a factorial number, determines how many 2's
and how many 5's occur
Author: Andrei Catalin Negura
Os: win10
Date: 11/01/2017

*/
#include <iostream>

using namespace std;

int main()
{
    int n,i;
    int count2=0, count5=0, sum2=0, sum5=0;
    long int f=1;
    int divizor(int x, int y);

    cout<<"Please enter a number: ";
    cin>>n;

    for(i=2;i<=n;i++)
    {
        if(i%2==0)
        {
            count2=divizor(i,2);
            sum2+=count2;
        }
        if(i%5==0)
        {
            count5=divizor(i,5);
            sum5+=count5;
        }
        f*=i;
    }

    cout<<"Your number has "<<sum2<<" divisions"<<endl;
    cout<<"Your number has "<<sum5<<" divisions"<<endl;
    cout<<"N factorial "<<f;

    return 0;
}

int divizor(int x, int y)
{
    int j=0;

    while(x%y==0)
    {
        j++;
        x/=y;
    }
    return j;
}
