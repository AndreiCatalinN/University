import socket


def main():
    server = '127.0.0.1'
    port = 8080
    my_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    my_socket.connect((server, port))
    while True:
        message = input("Send something to the server: ")
        my_socket.send(message.encode('ascii'))
        packet = my_socket.recv(1024)
        data = str(packet.decode('ascii'))
        print('Received from the server :', data)
        data = data[::-1]
        print('And human readable: ', data)
        answer = input('\nDo you want to continue(y/n) :')
        if answer == 'y':
            continue
        else:
            break
    my_socket.close()


if __name__ == '__main__':
    main()
