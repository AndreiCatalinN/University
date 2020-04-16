# Program description: Palindrome algorithm
#                       and other strings stuff
# Author: Andrei Negura
# Date: 28/09/2017
# os/ide: win 7 /pycharm

import string


# palindrome gets a string through st
# and checks if it's the same string when reversed

def palindrome(st):
    # make everything low
    st = st.lower()

    # get rid of punctuation
    # remove whitespaces and punctuation
    l = len(st)
    i = 0

    while i < l:
        if st[i].isalpha() != 1:
            st = st[:i] + st[i + 1:]
            i -= 1
        l = len(st)
        i += 1

    # check if palindrome
    check(st)


def simpler(st):
    st = st.lower()# string
    nst = ''# new string
    # get rid of punctuation
    # remove whitespaces and punctuation
    for char in st:
        if char in string.whitespace or \
                char in string.punctuation:
            pass
        else:
            nst += char

    # check if palindrome
    check(nst)


def check(line):
    rev_line = line[::-1]
    if line == rev_line:
        print("Palindrome")
    else:
        print("Not palindrome")


# Main
def main():
    line = input("Enter a string: ")
    # simpler is the palindrome function
    # rewritten using other features of python
    simpler(line)
    return 0


# Call main
if __name__ == '__main__':
    main()
