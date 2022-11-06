import json
import requests

r = requests.get('http://localhost:3000')
data = r.json()
n1 = (data[0]['name'])
n2 = (data[1]['name'])
n3 = (data[2]['name'])
n4 = (data[3]['name'])
c1 = (data[0]['color'])
c2 = (data[1]['color'])
c3 = (data[2]['color'])
c4 = (data[3]['color'])
print(n1 + ' is ' + c1 + '.')
print(n2 + ' is ' + c2 + '.')
print(n3 + ' is ' + c3 + '.')
print(n4 + ' is ' + c4 + '.')