#counts people
#imports
from urllib.request import Request, urlopen
from json import loads

#functions
def open(url):
    '''loads a page '''
    req = Request(url, None, {
        'User-agent': 'Mozilla/5.0 (Windows; U; Windows NT '
                      '5.1; de; rv:1.9.1.5) Gecko/20091102 Firefox/3.5.5'
    })
    data = loads(urlopen(req).read().decode("utf-8"))
    return data

def main():
    #variables
    count =0
    url = 'https://swapi.co/api/people'

    #load first page
    data = open(url)
    #Count names on first page
    count += len(data['results']);
    url = data['next']

    #load the rest
    while data['next']:
        data = open(url)
        count += len(data['results'])
        url = data['next']

    print(count)

if __name__ =="__main__":
    main()