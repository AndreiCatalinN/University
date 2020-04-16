# Program description: Has a class rectangle that reads the width and length
# A class triangle that reads the sides of the triangle and based on those determines
# if the triangle is regular, isosceles, equilateral , rectangular isosceles or ordinary
from math import sqrt


class Rectangle():

    def calculate_perimeter(self):
        self.perimeter = 2 * (self.length + self.width)

    def calculate_surface(self):
        self.surface = self.length * self.width

    def set_width(self):
        self.width = float(input("Width of rectangle: "))


    def set_length(self):
        self.length = float(input("Length of rectangle: "))


    def get_width(self):
        return width

    def get_length(self):
        return length

    def update_rectangle(self):
        self.calculate_perimeter()
        self.calculate_surface()

    def __init__(self):
        self.set_width()
        self.set_length()


    def __str__(self):
        st = 'W: ' + str(self.width) + ' L: ' + str(self.length)
        st = st + ' Perimeter: ' + str(self.perimeter) + ' Surface: ' + str(self.surface)
        return st


class Triangle():
    def __init__(self, line1=0, line2=0, line3=0):
        self.AB = float(line1)
        self.BC = float(line2)
        self.AC = float(line3)
        self.c_perimeter()
        self.c_surface()
        self.det_property()

    def __str__(self):
        st = 'AB: ' + str(self.AB) + ' BC: ' + str(self.BC)
        st = st + ' AC: ' + str(self.AC)
        st = st + ' P: ' + str(self.perimeter) + ' S: {:.2f} '.format(self.surface)
        st += self.property
        return st

    def c_perimeter(self):
        self.perimeter = self.AB + self.BC + self.AC

    def c_surface(self):
        p = (self.AB + self.BC + self.AC) // 2
        self.surface = sqrt(p * (p - self.AB) * (p - self.BC) * (p - self.AC))

    def det_property(self):
        a = self.BC
        b = self.AC
        c = self.AB
        a = a * a
        b = b * b
        c = c * c
        self.property = 'Ordinary'
        if self.AB == self.AC or self.AC == self.BC or self.BC == self.AB:
            self.property = "Isoscel"
        if self.AB == self.AC and self.AC == self.BC:
            self.property = 'Equilateral'
        if (self.AB == self.AC or self.AC == self.BC or self.BC == self.AB) and \
                (a == b + c or b == a + c or c == a + b):
            self.property = " Rectangular Isoscel"
        if a == b + c or b == a + c or c == a + b:
            self.property = 'Rectangular'


class ImaginaryNumbers():
    def __init__(self, a=0, b=0):
        self.a = a
        self.b = b

    def __str__(self):
        st = str(self.a) + ' + ' + str(self.b) + 'i'
        return st

    def add_2_imaginary(self, imag_num_1, imag_num_2):
        self.a = imag_num_1.a + imag_num_2.a
        self.b = imag_num_1.b + imag_num_2.b

    def multiply_2_imaginary(self, imag_num1, imag_num2):
        '''
        (a1+b1i) (a2+b2i) = a1*a2 + a1*a2*b1*b2*i + b1*b2*i**2
        '''
        self.a = imag_num1.a * imag_num2.a - imag_num1.b * imag_num2.b
        self.b = imag_num1.a * imag_num2.a * imag_num1.b * imag_num2.b


def read_rectangle():
    sh = Rectangle()
    sh.update_rectangle()
    print(sh)
    sh.set_length()
    sh.set_width()
    sh.update_rectangle()
    print(sh)


def read_triangle():
    l1, l2, l3 = input("Enter the values of the sides of the triangle: ").split()
    sh = Triangle(l1, l2, l3)
    print(sh)


def read_imaginary():
    x = ImaginaryNumbers(2, 3)
    y = ImaginaryNumbers(5, 5)
    z = ImaginaryNumbers()
    w = ImaginaryNumbers()
    z.add_2_imaginary(x, y)
    w.multiply_2_imaginary(x, y)

    print('Num1: ', x)
    print('Num2: ', y)
    print('Sum: ', z)
    print('Multiplication: ', w)


def main():
    print ("Use of rectangle class: \n")
    read_rectangle()
    print ("Use of triangle class: \n")
    read_triangle()
    print ("Use of triangle class: \n")
    read_triangle()
    print ("Use of imaginary numbers class: \n")
    read_imaginary()
    return 0


if __name__ == '__main__':
    main()
