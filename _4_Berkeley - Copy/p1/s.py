import socket
import datetime

def calc_offset(client_timestamps,server_time):
    
    all_times = client_timestamps + [server_time]
    
    time_stamps = [t.timestamp() for t in all_times]
    
    avg_timestamp = sum(time_stamps) / len(time_stamps)
    
    offsets = [avg_timestamp - t.timestamp() for t in client_timestamps]

    print(f"OFFSET : {offsets}")
    
    print(f"AVG TIME : {datetime.datetime.fromtimestamp(avg_timestamp)}")
    
    
    
    return offsets
    
    

def start():
    server = socket.socket()
    server.bind(("localhost",8080))
    server.listen(3)
    clients = []
    clients_timestamps = []
    print("SERVER IS READY......")
    for i in range(3):
        conn , addr = server.accept()
        clients.append(conn)
        data = conn.recv(1024).decode()
        client_time = datetime.datetime.strptime(data,"%Y-%m-%d %H:%M:%S.%f")
        
        clients_timestamps.append(client_time)
        print(f"Time stamp : {client_time}")
    
    server_time = datetime.datetime.now()
    print(f"SERVER TIME : {server_time} ")
    
    offsets = calc_offset(clients_timestamps,server_time)
    
    for i in range(3):
        clients[i].send(str(offsets[i]).encode())
        clients[i].close()
    
    server.close()
    
    
start()