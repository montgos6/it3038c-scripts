import json
import requests

r = requests.get('http://api.openweathermap.org/data/2.5/weather?zip=12345,us&appid=d9600f1d03d1dc7ea44886124066f82a')
data = r.json()
print(data['weather'][0]['description'])