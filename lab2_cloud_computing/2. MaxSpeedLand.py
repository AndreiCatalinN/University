#Finds the land vehicle with the biggest speed

from countPeople1 import open
#functions
def getMaxSpeed(results):
    '''gets the max speed per page'''
    maxSpeed = 0
    vehicle = []
    for car in results:
        if car['max_atmosphering_speed'] == 'unknown':
            pass
        elif maxSpeed < int(car['max_atmosphering_speed']):
            maxSpeed = int(car['max_atmosphering_speed'])
            vehicle = car
    return maxSpeed, vehicle


def main():
    #Variables
    url = 'https://swapi.co/api/vehicles'

    print("Getting data and determining the max number")
    data = open(url)
    results = data['results']
    #Find maximum in first page
    maxSpeed, maxVehicle = getMaxSpeed(results)
    #I get the max per page
    #Store it in prevMax in order to check it
    #With the next page maximum
    prevMax, prevVehicle = maxSpeed, maxVehicle
    url = data['next']

    #load the rest
    while data['next']:
        data = open(url)
        results = data['results']
        maxSpeed, maxVehicle = getMaxSpeed(results)
        if maxSpeed< prevMax :
            maxSpeed, maxVehicle = prevMax, prevVehicle
        url = data['next']

    print (maxSpeed, "\n", maxVehicle)

if __name__ =="__main__":
    main()