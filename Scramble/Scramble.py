# Prog description: Program taht scrambles words in a text
# Works for sentences, not paragraphs. Has a bug where, if
# one letter words are used (like I), it doubles that letter
# Author: Andrei Negura
# IDe: Pycharm
# Date: 12/10/2017


from random import shuffle


def scramble(word):
    # Take out the first and last char
    new = word[1:-1]
    # Scramble stuff
    s_new = word[0] + new[1::2] + new[::2] + word[-1]
    return s_new


def main():
    line = str(input("Input a sentence: "))
    # Makes the list word
    words = line.split(" ")

    sentence = ''
    for i in words:
        n_word = scramble(i)
        sentence += n_word + " "
    print(sentence)
    return 0


if __name__ == '__main__':
    main()
