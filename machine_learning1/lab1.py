import random


def f():
    stringtest = 'The quick brown fox jumps over the lazy dog'
    set1 = set(stringtest)
    print(sorted(set1))


def g():
    users = {}
    # get users and passwords from file
    with open('file.txt') as file:
        for line in file:
            username, pas = line.split()
            users[username] = pas
        for username in users:
            print(username + ' : ' + users[username])

    # get input
    user = (input('Username: '), input('Password: '))

    if user in users.items():
        print("logged in")
    else:
        print("wrong username or password")


def h():
    list = [1, 2, 3, 4, 5]
    list = [x ** 2 + 4 - 5 for x in list]
    list2 = [x ** 2 // 13 for x in range(123, 130)]
    for el in list2:
        print(el / 2)
        if el % 2 == 0:
            print('even')
        else:
            print('odd')
    print(list2)


def i():
    count = 0
    a_list = range(0, 100)
    guess = 69
    while random.choice(a_list) != guess:
        count += 1
    print('it took ' + str(count) + ' tries to guess my number')


def factorial(x):
    if x == 0 or x == 1:
        return 1
    elif x > 0:
        return x * factorial(x - 1)
    else:
        return 0


def fibonnaci(x):
    if x < 0:
        return "Invalid number"
    elif x == 1:
        return 1
    elif x == 0:
        return 0
    else:
        return fibonnaci(x - 2) + fibonnaci(x - 1)


def make_multiplier(n):
    return lambda x: x * n


def main():
    by_three = make_multiplier(3)
    by_five = make_multiplier(5)
    print(by_five(10))
    print(by_three(3))
    return 0


if __name__ == '__main__':
    main()
