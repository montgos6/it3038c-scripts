from bs4 import BeautifulSoup
import requests, re
r = requests.get('https://www.catalog.update.microsoft.com/Search.aspx?q=2022-10%20windows%2011%2022h2%20x64').content
soup = BeautifulSoup(r, 'html.parser')
for row in soup.find_all('a',{"class":"contentTextItemSpacerNoBreakLink"}):print(row.string)