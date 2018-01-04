import math
import sys

def main():
    for i in range(1, 500):
        for j in range(i, 500):
            if test(i, j):
                print i * j * (1000 - i - j)
                sys.exit

def test(i, j):
    num = 1000 - i - j
    return i ** 2 + j ** 2 == num ** 2

if __name__ == '__main__':
    main()