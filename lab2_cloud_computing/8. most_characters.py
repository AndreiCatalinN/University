from sort_cargo3 import get_list
from character_films6 import get_content

def most_characters(results):
    '''
    determine the species name and planet origin
    of the species with the most characters
    '''
    max = 0
    for specie in results:
        temp = len(specie['people'])
        if(max <temp):
            max = temp
            answer= specie
    print(answer['name'])
    p = get_content(answer['homeworld'])
    print(p['name'])


def main():
    url = "https://swapi.co/api/species/"
    data = get_list(url)
    most_characters(data)



if __name__ == '__main__':
    main()