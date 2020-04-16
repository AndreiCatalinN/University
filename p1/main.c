/**
Write a program that uses a pointer (which points to a variable called radius to store
the radius of a circle) to read the radius of a circle (i.e. use the indirection operator in
a scanf() statement to read and store the radius inside the floating-point radius
variable). Your program should calculate and display the diameter (2 x radius) and
area (? x radius2) of the circle using other pointers (these also need to point to other
variables required such as diameter and area) . Assume ? has the value 3.14
Daniel Apetri borland win 10
*/
#include <stdio.h>

int main()
{
    float radius;
    radius = 0;
    float pi = 3.14;
    float *p_radius;
    p_radius = &radius;
    float diameter;
    float *p_diameter;
    p_diameter = &diameter;
    float area;
    float *p_area;
    p_area = &area;



    printf ("give a data to your p_radius\n");
    scanf ("%f",&*p_radius);

    diameter = 2 *(* p_radius);
    printf("diameter of the circle is %.2f\n",*p_diameter);

    area = pi *((*p_radius) * (*p_radius));
    printf("area of the cicle is %f\n",*p_area);


    return 0;
}
