import os

def main():
    location = "C:\\Users\\Catalin\\Downloads"
    temp = location +'\\'
    for file in os.listdir(location):
        if file.__contains__('_'):
            n_file = file.replace('_',' ')
            os.rename(temp + file, temp + n_file)

    return 0


if __name__ == '__main__':
    main()