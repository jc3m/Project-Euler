import sys

def main():
    num = 600851475143
    i = 1
    while i < num:
        if num % i == 0:
            num /= i
        i += 1
    print num

if __name__ == '__main__':
    main()