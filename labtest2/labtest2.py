dict = {}


def read_f():
    '''
    Reads the file
    Cleans the data of endofline characters and divides it
    Returns the dictionary
    '''
    with open('books.txt', 'r') as f:
        for line in f:
            l = line.strip('\n').split(',')
            dict[int(l[0])] = l[1:]


def add_book():
    '''
    Adds a book to my dictionary
    Ensures the ID is unique
    :param dict: My dictionary
    :return: -
    '''
    w = 'y'
    ID = int(input('unique id: '))
    while dict.get(ID) and w == 'y':
        ID = int(input('Enter another id: '))
        w = input("Press 'y' if you wanna try again")

    Title = input('Book title: ')
    Author = input('Author of book: ')
    price = float(input("Price of book: "))
    l = []
    l.append(Title)
    l.append(Author)
    l.append(price)
    dict[ID] = l


def total_price():
    sum = 0
    for key in dict:
        dict[key][2] = float(dict[key][2])
        sum += dict[key][2]
    return sum


def print_books():
    for key in dict:
        print('ID: ', key, ' Author: ', dict[key][1], \
              ' Title: ', dict[key][0], ' Price: ', dict[key][2])


def discount():
    for key in dict:
        dict[key][2] -= dict[key][2] * 0.1


def search():
    search = input('Enter the book title you want to search(enter the exact name): ')
    for key in dict:
        if search == dict[key][0]:
            print("Found it! ", dict[key][1])


def save_file():
    with open('book1.txt', 'w') as f:
        for key in dict:
            f.write(str(key)+' '+ dict[key][0]+' '+ dict[key][1]+' '+ str(dict[key][2])+ '\n')



def menu():

    check = 0
    while 1:
        print(
            '''
            1. Read books from file
            2. Add a new book
            3. Search for author of book by title
            4. Print all books
            5. Calculate total price
            6. Apply 10% discount
            7. Save the books in another file
            8. Exit
        ''')
        print('You need to read the books in order to make the other ones work')
        ch = input('Pick your option: ')

        if ch == '1':
            read_f()
            check = 1
            print('Finished!')
        elif ch == '2' and check == 1:
            add_book()
        elif ch == '3' and check == 1:
            search()
        elif ch == '4' and check == 1:
            print_books()
        elif ch == '5' and check == 1:
            total=total_price()
            print('Total price is: ', total)
        elif ch == '6' and check == 1:
            discount()
            print('Discount applied')
        elif ch == '7' and check == 1:
            save_file()
            print('File saved!')
        elif ch == '8':
            return 0


def main():
    menu()
    return 0


if __name__ == '__main__':
    main()
