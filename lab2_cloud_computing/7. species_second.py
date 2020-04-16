"""
What species appears the second-most often in a film?
author Andrei Negura
"""
from sort_cargo3 import get_list
from character_films6 import get_content

def most_species(results):
    #variables
    freq = dict()
    max = 0
    ante = 0
    result = []
    #build frequency of species
    for movie in results:
        for specie in movie['species']:
            if specie not in freq.keys():
                freq[specie] = 1
            else: freq[specie] += 1

    #find the second-most often species
    for specie in freq:
        if max < freq[specie]:
            ante = max
            max = freq[specie]
    #find all of them
    for specie in freq:
        if freq[specie] == ante:
            result.append(specie)
    return result


#retrieve and print all second-most often species
def release(species):
    for i in species:
        val = get_content(i)
        print (val['name'])


def main():
    url = "https://swapi.co/api/films/"
    data = get_list(url)
    most_s = most_species(data)
    release(most_s)

if __name__ == '__main__':
    main()