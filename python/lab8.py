import requests, re
from bs4 import BeautifulSoup

data = requests.get("http://www.reebok.com/us/question-low-shoes---grade-school/ID9292.html").content
soup = BeautifulSoup(r, 'html.parser')
span = soup.find("h1", {"class":"name___120FN"})
title = span.text
