import socket, sys
def getHostnameByIP(h):
try:
	hostname = str(sys.angv[1])
	ip = socket.gethostbyname(hostname)
	print (hostname +' has an IP of ' + ip)
except:
	print("Oops, something is wrong with that host")