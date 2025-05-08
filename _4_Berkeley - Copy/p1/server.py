import socket
import datetime

# This function calculates time differences and finds the average time
def calculate_offsets(client_times, server_time):
    all_times = client_times + [server_time]

    # Convert all times to seconds since epoch
    time_stamps = [t.timestamp() for t in all_times]
    
    # Calculate average of all timestamps
    average_time = sum(time_stamps) / len(time_stamps)

    # Calculate how much each client needs to adjust (offset = average - client time)
    offsets = [average_time - t.timestamp() for t in client_times]

    print("\nAverage Time (Calculated):", datetime.datetime.fromtimestamp(average_time))
    print("Offsets (in seconds):", offsets)
    return offsets

# Main server function
def start_server():
    # Create a TCP socket
    server = socket.socket()
    
    # Bind to localhost and port 8080
    server.bind(("localhost", 8080))
    server.listen(3)  # Wait for 3 clients

    print("Server started. Waiting for 3 clients to connect...\n")

    clients = []
    client_times = []

    # Accept connections from 3 clients
    for i in range(3):
        conn, addr = server.accept()
        print(f"Client {i+1} connected from {addr}")
        print(conn)

        # Receive client's current time
        data = conn.recv(1024).decode()
        print(data)
        client_time = datetime.datetime.strptime(data, "%Y-%m-%d %H:%M:%S.%f") 
        client_times.append(client_time)
        clients.append(conn)

        print(f"Client {i+1} Time: {client_time}")

    # Get current time of the server
    server_time = datetime.datetime.now()
    print("\nServer Time:", server_time)

    # Calculate offsets for each client
    offsets = calculate_offsets(client_times, server_time)

    # Send each client their respective offset
    for i in range(3):
        clients[i].send(str(offsets[i]).encode())
        clients[i].close()
        print(f"Sent offset to Client {i+1}")

    # Close the server socket
    server.close()
    print("\nAll clients synchronized. Server closed.")

# Run the server
if __name__ == "__main__":
    start_server()
