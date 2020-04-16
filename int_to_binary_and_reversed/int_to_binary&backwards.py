# Program description: Program that
#  converts a decimal number into
#  any other base number( up to 16 so far)
# Author: Andrei Negura
# IDE/ OS: Pycharm / win10 & 7
# Date: 3/10/2017


# Function that converts a
# decimal number to any base(Up to 10)
def to_base(num, base):
    result = ''
    copy = num
    while num != 0:
        result = str(num % base) + result
        num //= base
    print("Binary of ", copy, " is ", result)
    return result


# Function that converts a base number(up to 10)
# in any base to decimal
def to_normal(bnr, base):
    # l is the length of my base string
    l = len(bnr)
    my_int = int(0)
    # I reverse bnr so the
    # highest power would be the first
    bnr = bnr[::-1]
    while l > 0:
        l -= 1
        if bnr[l] != '0':
            my_int = my_int + ((base ** l) * int(bnr[l]))

    print("The whole number, recalculated is ", my_int)


# Not working yet!!!
def to_base_recursive(num, base, result):
    if num != 0:
        result = str(to_base_recursive(num / 2, base, result)) + result
    else:
        return 0


# Function that converts a
# decimal number to any base(Up to 16)
def to_base_hex(num, base):
    hex_cata = '0123456789ABCDEF'
    result = ''
    while num != 0:
        result = hex_cata[num % base] + result
        num //= base

    return result


# Function that converts a base number(up to 16)
# in any base to decimal
# Not working yet! I have to use the index of the string letters
def to_normal_hex(bnr, base):
    hex_cata = "0123456789ABCDEF"
    # l is the length of my base string
    l = len(bnr)
    my_int = int(0)
    # I reverse bnr so the
    # highest power would be the first
    bnr = bnr[::-1]
    while l > 0:
        l -= 1
        # find me bnr[l] in hex_cata
        # returns the position where bnr[l] was found
        num = hex_cata.find(bnr[l])
        if num > 0:
            my_int = my_int + ((base ** l) * num)

    return my_int


# Main function
def main():
    num = int(input("Enter a whole number "))
    base = int(input("In what base do you want to transform the number(2 - 16 which is hex): "))
    bnr = to_base_hex(num, base)
    print("Converted: ",bnr)
    to_int=to_normal_hex(bnr, base)
    print("And back to normal: ",to_int)
    return 0


if __name__ == "__main__":
    main()