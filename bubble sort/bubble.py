# Program description: An attempt to make bubble sort different
# and faster
# Author: Andrei Negura
# IDE: PyCharm
# Date: I forgot

# Checks if the array is sorted
# If it is not sorted it returns the index of the unsorted element
def check(array):
    n = len(array)
    for i in range(n - 1):
        if array[i] > array[i + 1]:
            return i
    else:
        return -1


# swap function
def swap(a, b):
    return b, a


# read a list
def read_l():
    print("Enter some numbers with spaces between them:")
    l = [int(num) for num in input().split()]
    return l


# bubble sort function
def bubble_sort(unsorted):
    n = len(unsorted)
    j = check(unsorted)
    while (j < n - 1) and j > -1:
        unsorted[j], unsorted[j + 1] = swap(unsorted[j], unsorted[j + 1])
        j = check(unsorted)
    return unsorted


def main():
    array = read_l()
    array = bubble_sort(array)
    print("Sorted list: ", array)
    input("Press enter to exit")
    return 0


if __name__ == '__main__':
    main()
