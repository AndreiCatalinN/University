
def steg():
    with open('stegano1.bmp', 'r') as f:
        return f.read()

def pri():
    with open('file.txt', 'w') as fi:
        fi.write(steg())

def main():
    pri()
    return 0

if __name__ == '__main__':
    main()