# client.py
import socket
import datetime

def clock_client(port=8080):
    client = socket.socket()
    client.connect(("localhost", port))

    # Current local time
    local_time = datetime.datetime.now()
    print(f"Local Time: {local_time}")

    # Send local time to server
    client.send(local_time.strftime("%Y-%m-%d %H:%M:%S.%f").encode())

    # Receive offset
    offset_data = client.recv(1024).decode()
    offset = float(offset_data)

    # Apply offset
    new_time = local_time + datetime.timedelta(seconds=offset)
    print(f"Offset Received: {offset} seconds")
    print(f"Updated Local Time: {new_time}")

    client.close()

# Run client
if __name__ == "__main__":
    clock_client()
