from random import *
print("Welcome to guess the number between 1 and 1000 please guess a number")
guess = int(input())
rng = randint(1, 1000)
while guess != rng:
	if guess > rng:
		print('Too high try again')
		guess = int(input())
	else:
		print('Too low try again')
		guess = int(input())
print("You did it! The number was " + str(rng))