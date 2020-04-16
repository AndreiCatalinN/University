# Program description: Reads tracks from a file
# x indicates the track number
# m indicates the time signature
# It reads the track number, first line from the title
# the time signature and key signature.
# Prints the all the above in  this format:
# track ... title ... time signature ... key signature ...
# Each track on a line. At the end prints the number of tracks
# Author: Andrei Negura
# IDE: Pycharm
# Last modified: 21/12/2017

def read_tracks():
    f = open("hnr.abc", "r")

    if f.closed:
        print("File could not be opened")
    else:
        my_print = ''
        l = f.readline()
        count = 0
        while l:
            if l[:2] == "X:":
                count += 1
                my_print += l[2:].replace('\n', '') + ' ... '
                title = f.readline()
                my_print += title[2:].replace('\n', '') + ' ... '
            elif l[:2] == "M:":

                my_print += 'Time sig: ' + l[2:].replace('\n', '') + ' ... '
                key_sig = f.readline()
                my_print += 'Key sig: ' + key_sig[2:].replace('\n', '') + ' ... '

                print(my_print)
                my_print = ''
            l = f.readline()
        print("Number of tracks: ", count);

    f.close()


def main():
    read_tracks()
    input('Press enter to exit')
    return 0

if __name__ == '__main__':
    main()