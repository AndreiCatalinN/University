from sort_cargo3 import get_list
from character_films6 import get_content

def resolve(data):
    '''
    List the names of the people
    that have spaceships and the cost of each spaceship
    :return:
    '''
    for people in data:
        if len(people['starships']) == 0 :
            pass
        else:
            for spaceship in people['starships']:
                sp = get_content(spaceship)
                print("Name: ", people['name'], end = ' ')
                print("Starship: ", sp['name'], end = ' ')
                print("Cost: ", sp['cost_in_credits'], end='\n' )


def main():
    url = "https://swapi.co/api/people/"
    data = get_list(url)
    resolve(data)


if __name__ == '__main__':
    main()
