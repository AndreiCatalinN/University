
/**
Program description: Adding, substracting, multiplying and deviding using define
Author: Andrei Negura
Os: win 10
Date: 01/12/2016

Number conversion + number check + document on strcat
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define SIZE 100
#define INTSIZE 15


int main()
{
    char opt[5], calc[SIZE], element[INTSIZE];
    int s=0, el, j=0,i;
    int first=0;

    FILE *fp;

    ///Open file for saving operations
    fp=fopen("data_save.txt", "a+");

    //Do while repeats until I want to exit the program. Gracefull ending.
    do
    {
        menu();

        //get the option
        gets(opt);

        switch(*opt)
        {
        //Simple calculator
        case 'c':
        {

            printf("Please enter what you want to calculate, then press the key \"Enter\" from the keyboard\n");
            gets(calculation);

            for(i=0; i<strlen(calculation); i++)
            {
                // Check if element is a number and store it in variable element for operations
                j=0;
                while(isdigit(*(calculation+i))!=0 )
                {
                    *(element+j)=*(calculation+i);
                    i++;
                    j++;
                }

                *(element+j)='\0';

                if(j!=0)
                    el=atoi(element);

                if(first==0)
                {
                    s=el;
                    first=1;
                    el=0;
                }
                    // Calculations switch
                    switch(*(calc +i))
                    {
                        case '+':
                        {
                            s+=el;
                            break;
                        }
                        case '-':
                        {
                            s-=el;
                            break;
                        }
                        case 'x':
                        case 'X':
                        case '*':
                        {
                                s*=el;
                            break;
                        }
                        case '\\':
                        case '/':
                        case ':':
                        {
                            s/=el;
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }//end switch
            }//end for

            printf("= %d\n", s);
            fprintf(fp,"%s = %d\n", calc, s);
            break;
        }
        /// Exit option
        case 'q':
        {
            printf("\nHave a nice day!\n");
            break;
        }
        /// In case of bad input
        default:
        {
            printf("\nBad input. Please enter one of the options\n");
            break;
        }
        }
    }
    while(opt!='q');

    fclose(fp);

    return 0;
}

/* Prints the options for the user*/

void menu(void)
{
     printf("Press the key \"c\" from the keyboard if you want to calculate something\n");
     printf("Press the key \"q\" from the keyboard if you want to exit the calculator\n");
}

int simple_calculator()
{
     printf("Please enter what you want to calculate, then press the key \"Enter\" from the keyboard\n");
            gets(calculation);

            for(i=0; i<strlen(calculation); i++)
            {
                // Check if element is a number and store it in variable element for operations
                j=0;
                while(isdigit(*(calculation+i))!=0 )
                {
                    *(element+j)=*(calculation+i);
                    i++;
                    j++;
                }

                *(element+j)='\0';

                if(j!=0)
                    el=atoi(element);

                    // Calculations switch
                    switch(*(calc +i))
                    {
                        case '+':
                        {
                            s+=el;
                            break;
                        }
                        case '-':
                        {
                            s-=el;
                            break;
                        }
                        case 'x':
                        case 'X':
                        case '*':
                        {
                                s*=el;
                            break;
                        }
                        case '\\':
                        case '/':
                        case ':':
                        {
                            s/=el;
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }//end switch
            }//end for

            printf("= %d\n", s);
            fprintf(fp,"%s = %d\n", calc, s);
}

