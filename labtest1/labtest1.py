# Program description: OOP labtest1
# Had to determine if a number is a happy number
# (Is a happy number if, after multiple iterations
# the number becomes 1, unhappy if it becomes 4).
# In the iterations I would calculate the sum
# of the squared digits of the number
# until it reaches 1 or 4.
# I had to check and print all the happy numbers up to
# n (n inputed from the keyboard).
# IDE/ OS: Pycharm / win 7
# Author: Andrei Negura
# Date: 26/10/2017

# Function to calculate the sum
# of squared digits of a number
def squared(number):
    new_num=0
    while number:
        # Calculate the sum of the squared digits
        # and put them in the new number
        new_num= new_num+ (number%10)**2
        number//=10

    return new_num


# Function to determine if a number is happy
def happy(number):
    # Calculate the number
    number = squared(number)
    #As long as it's not 1, calculate new numbers
    while number != 1:
        #if it reaches 4 before 1, exit
        if number == 4:
            return 0 #not happy
        elif number == 0:
            return 0 # otherwise keeps looping
        # Calculate number for next step
        number = squared(number)
    # While finished normally, number is happy
    else: return 1


# function to check all values from  range
# for one condition
def check_range(n):
    # Starts at 1 because if it starts at 0
    # it forms a infinite loop
    # n+1 because range goes until end-1
    for i in range(1,n+1):
        # Check if a number is happy
        # If it is, print it
        if happy(i):
            print(i,end=' ')


# main function
def main():

    num=int(input("Enter a whole number: "))
    check_range(num)
    # end main
    return 0


# Call main
if __name__ == '__main__':
    main()