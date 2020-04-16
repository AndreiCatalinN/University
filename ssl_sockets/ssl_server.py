import socket
from _thread import *
import threading

print_lock = threading.Lock()


def main():
    host = ""
    port = 8080
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((host, port))
    print("socket bound to port ", port)
    server_socket.listen(5)
    print("socket is listening")

    # a forever loop until client wants to exit
    while True:
        # establish connection with client
        client, addr = server_socket.accept()
        # lock acquired by client
        print_lock.acquire()
        print('Connected to :', addr[0], ':', addr[1])
        start_new_thread(threaded, (client,))
    server_socket.close()


def threaded(client):
    while True:
        packet = client.recv(1024)

        if not packet:
            print('There is no data')
            print_lock.release()  # unlocks it
            break

        data = str(packet.decode('ascii'))
        data += " received"
        data = data[::-1]
        client.send(data.encode('ascii'))
    client.close()


if __name__ == '__main__':
    main()
