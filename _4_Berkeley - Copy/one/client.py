import socket
import datetime

def clock_client(port=8080):
    """
    Connects to the server, sends the current local time in full timestamp format,
    and receives the synchronized time from the server.
    """
    client = socket.socket()
    client.connect(("localhost", port))

    # Get current local time in full timestamp format
    local_time = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S.%f")
    print(f"Sending local time: {local_time}")

    # Send time to the server
    client.send(local_time.encode())

    # Receive synchronized time from server
    synced_time = client.recv(1024).decode()
    print(f"Synchronized Time Received: {synced_time}")

    client.close()

# Run the client
clock_client()
