# Program description: Menu operated
# Uses a class student
# Has almost no error checking
# Last modified: 21/12/2017
# Author: Andrei Negura
# IDE: Pycharm

class Student():
    #get functions
    def get_fname(self):
        '''
        Gets the first name of the student
        :return: f_name
        '''
        f_name = input('First name: ')
        return f_name

    def get_SID(self):
        '''
        Gets the Student ID
        :return: SID
        '''
        SID = input('Student ID: ')
        return SID

    def get_lname(self):
        '''
        Gets the last name of the student
        :return: l_name
        '''
        l_name = input('Last name: ')
        return l_name

    def get_DOB(self):
        '''
        Gets the date of birth of the student
        :return: DOB
        '''
        DOB = input('Date of Birth(dd/mm/yyyy): ')
        return DOB

    def set_fname(self):
        '''
        Sets self.f_name to f_name
        :return: -
        '''
        self.f_name = self.get_fname()

    def set_lname(self):
        '''
        Sets self.l_name to l_name
        :return: -
        '''
        self.l_name = self.get_lname()

    def set_SID(self):
        '''
        Sets self.SID to SID
        :return: -
        '''
        self.SID= self.get_SID()

    def set_DOB(self):
        '''
        Sets self.DOB to DOB
        :return: -
        '''
        self.DOB = self.get_DOB()

    def __init__(self):
        ''' Constructor'''
        self.set_SID()
        self.set_fname()
        self.set_lname()
        self.set_DOB()

    def __str__(self):
        '''Print function '''
        strin = "Student " + self.f_name
        strin += " " + self.l_name
        strin += " with ID " + self.SID
        strin += ' born at ' + self.DOB
        return strin


def menu():
    print('''
        1. Create Student
        2. Remove Student
        3. Change Student ID
        4. Change First Name
        5. Change Last Name
        6. Change Date of Birth
        7. Show Student
        8. Exit
        ''')


def operate_menu():
    check = 0
    while 1:
        menu()
        if check == 0:
            print('You have to create a student in order to access any other option')
        elif check == 2:
            print("You probably deleted your student, you need to input another one")

        ch = input('Enter your choice: ')

        if ch == '1':
            s = Student()
            check = 1
        elif ch == '2' and check == 1:
            del s
            check = 2
        elif ch == '3' and check == 1:
            s.set_SID()
        elif ch == '4' and check == 1:
            s.set_fname()
        elif ch == '5' and check == 1:
            s.set_lname()
        elif ch == '6' and check == 1:
            s.set_DOB()
        elif ch == '7' and check == 1:
            print(s)
        elif ch == '8':
            print('Goodbye')
            return 0
        else:
            print('Wrong input')


def main():
    operate_menu()
    return 0

if __name__ == '__main__':
    main()
