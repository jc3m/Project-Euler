import math

def factors(n):    
    return set(reduce(list.__add__, 
                ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

def is_prime(n):
    if n == 2:
        return True
    if n%2 == 0 or n <= 1:
        return False
    sqr = int(math.sqrt(n)) + 1
    for divisor in range(3, sqr, 2):
        if n%divisor == 0:
            return False
    return True

def checkNum(n):
    f = factors(n)
    for j in f:
        temp = j + n/j
        if not is_prime(temp):
            return False
    return True

def main():
    total = 0
    for i in range(1, 1000000001):
        if checkNum(i):
            total += i
    print total

if __name__ == '__main__':
    main()