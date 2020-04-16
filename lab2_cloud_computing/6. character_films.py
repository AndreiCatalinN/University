"""
Which character has the most associated films?
When was the first and last of their films released?
Author: Andrei Negura

"""
from sort_cargo3 import get_list
from urllib.request import Request, urlopen
from json import loads



def most_films(results):
    #calculate the person who has the most films associated
    max = 0
    for person in results:
        temp = len(person['films'])
        print(person['name'],' ',temp)
        if(max <temp):
            max = temp
            char = person

    return char

def get_content(url):
    req = Request(url, None, {
        'User-agent': 'Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5'
    })

    return loads(urlopen(req).read().decode("utf-8"))


def release(person):

    url_f = person['films'][0]
    url_l = person['films'][len(person['films'])-1]

    first_movie = get_content(url_f)
    last_movie = get_content(url_l)
    print(person)
    print(first_movie['release_date'])
    print(last_movie['release_date'])

def main():

    url = "https://swapi.co/api/people/"
    data = get_list(url)

    person = most_films(data)
    release(person)

if __name__ == '__main__':
    main()