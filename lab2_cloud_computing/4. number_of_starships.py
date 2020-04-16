
#How many distinct starships are associated with Darth Vader and Luke Skywalker?


from sort_cargo3.py import get_list

def starships_associated(result):

    res = []

    for people in result:
        if people['name'] == "Luke Skywalker":
            res = people['starships']
        elif people['name'] == 'Darth Vader':
            res += people['starships']

    print (res)
    print ("the number of ships associated with Luke Skywalker and Darth Vader are : ", len(res))


def main():

    results = get_list('http://swapi.co/api/people')
    num_starships_associated(results)

if __name__ == '__main__':
    main()