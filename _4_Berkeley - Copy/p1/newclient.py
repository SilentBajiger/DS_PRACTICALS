import socket
import datetime


def start():
    client = socket.socket()
    client.connect(("localhost",8080))
    
    local_time = datetime.datetime.now()
    print(f"CURRENT TIME {local_time}")
    client.send(local_time.strftime("%Y-%m-%d %H:%M:%S.%f").encode())
    
    offset_data = client.recv(1024).decode()
    offset = float(offset_data)
    print(f"OFFSET : {offset}" )
    
    
    new_time = local_time + datetime.timedelta(seconds=offset)
    
    print(f"OLD TIME {local_time}")
    print(f"NEW TIME {new_time}")
    
    
    
start()