import socket
import datetime

def calc_offset(client_timestamps,server_timestamp):
    
    all_time = client_timestamps + [server_timestamp]
    timestamps = [t.timestamp() for t in all_time]
    avgtime = sum(timestamps) / len(timestamps)
    print(f"Average time : {datetime.datetime.fromtimestamp(avgtime)}")
    offsets = [avgtime - t.timestamp() for t in client_timestamps]
    print(offsets)
    return offsets

def start():
    server = socket.socket()
    server.bind(("localhost",8080))
    server.listen(3)
    
    clients = []
    client_timestamps = []
    print("Server is Ready...")
    
    for i in range(3):
        conn,addr = server.accept()
        
        data = conn.recv(1024).decode()
        client_time = datetime.datetime.strptime(data,"%Y-%m-%d %H:%M:%S.%f")
        client_timestamps.append(client_time)
        clients.append(conn)
        print("received time: " + str(client_time))
    
    server_timestamp = datetime.datetime.now()
    print(f"SERVER TIME : {server_timestamp}")
    
    offsets = calc_offset(client_timestamps,server_timestamp)
    
    for i in range(3):
        clients[i].send(str(offsets[i]).encode())
        clients[i].close()
        
    server.close()



start()