import math

def main():
    total = 0
    b = 0
    for i in range(1, 101):
        total += i ** 2
        b += i
    print abs(total - b ** 2)

if __name__ == '__main__':
    main()