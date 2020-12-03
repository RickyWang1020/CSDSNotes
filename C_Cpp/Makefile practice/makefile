CC = gcc

main: foo.o bar.o main.c
	$(CC) main.c foo.o bar.o -o main

foo.o: foo.c
	gcc -c foo.c

bar.o: bar.c
	gcc -c bar.c

clean:
	rm *.o main
