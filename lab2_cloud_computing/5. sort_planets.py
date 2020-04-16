"""
List the names of all planets sorted by (one list each)
●	diameter in ascending order
●	population in descending order

author: Andrei Negura
"""
from sort_cargo3 import get_list



def sort_by_population(data):

    for population in data:
        if population['population'] == 'unknown':
            population['population'] = '-1'
        population['population'] = int(population['population'])

    sort = sorted(data, key=lambda data: data['population'], reverse=True)

    for population in sort:
        if population['population'] == -1:
            population['population'] = 'unknown'
        else:
            population['population'] = str(population['population'])
    print(sort)

def sort_by_diameter(data):

    for planet in data:
        if planet['diameter'] == 'unknown':
            planet['diameter'] = '-1'
        planet['diameter'] = int(planet['diameter'])

    sort = sorted(data, key=lambda data: data['diameter'])

    for planet in sort:
        if planet['diameter'] == -1:
            planet['diameter'] = 'unknown'
        else:
            planet['diameter'] = str(planet['diameter'])
    print(sort)

def main():

    results = get_list("https://swapi.co/api/planets/")
    print("Reverse sort by population")
    sort_by_population(results)
    print("Sorted by diameter")
    sort_by_diameter(results)

if __name__ == '__main__':
    main()