# List flying vehicles sorted by cargo capacity
from countPeople1 import open
from operator import itemgetter
from operator import attrgetter


def get_list(url):
    space = []
    while url:
        data = open(url)
        space.extend(data['results'])
        url = data['next']
    return space



def main():
    # Variables
    url = 'https://swapi.co/api/starships'
    print("Getting API data")
    space = get_list(url)
    print("Sorting API data")

    for spacecraft in space:
        try:
            spacecraft['cargo_capacity'] = \
                int(spacecraft['cargo_capacity'])
        except: spacecraft['cargo_capacity'] = 0

    sort = sorted(space, key = lambda space: space['cargo_capacity'])
    for spacecraft in sort:
        if spacecraft['cargo_capacity'] == 0:
            spacecraft['cargo_capacity'] = 'unknown'
        else: spacecraft['cargo_capacity'] = str(spacecraft['cargo_capacity'])
    print(sort)


if __name__ == "__main__":
    main()