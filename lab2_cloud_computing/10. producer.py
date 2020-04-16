from sort_cargo3 import get_list
from character_films6 import get_content

def resolve(data):
    producers = []
    ans = []
    #form producers array
    for movie in data:
        producers.extend(movie['producer'].split(','))
    for i in producers:
        i = i.strip(' ')
        ans.append(i)
    #sort
    sort = sorted(ans)
    count = 1
    max = 0
    #get biggest series
    for i in range(len(sort)-1):
        if sort[i] == sort[i+1]:
            count +=1
        else: count =1

        if max < count:
            max = count
            name = sort[i]

    print(name)

def main():
    url = "https://swapi.co/api/films/"
    data = get_list(url)
    resolve(data)


if __name__ == '__main__':
    main()
