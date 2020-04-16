#Prints the whole google page
import urllib.request
page = urllib.request.urlopen('https://google.com')
print(page.read())