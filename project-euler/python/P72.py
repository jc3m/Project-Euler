import time
from sets import Set
start = time.time()

def sieve(n):
    # "Return all primes <= n."
    np1 = n + 1
    s = range(np1)
    s[1] = 0
    sqrtn = int(round(n**0.5))
    for i in xrange(2, sqrtn + 1):
        if s[i]:
            s[i*i: np1: i] = [0] * len(xrange(i*i, np1, i))
    return filter(None, s)

def toSet(seq):
    set = {}
    map(set.__setitem__, seq, [])
    return set.keys()

def factors(n, primes, primeSet):
    f = Set([])
    ind = 0
    while primes[ind] < int(round(n**.5)) + 1:
        if n in primeSet:
            f.add(n)
            return f
        if n % primes[ind] == 0:
            f.add(primes[ind])
            while n % primes[ind] == 0:
                n /= primes[ind]
        ind += 1
    f.add(n)
    return f

def gcd(a, b):
    while b > 0:
        t = b
        b = a % b
        a = t
    return a

def main():
    upper = 10 ** 6
    primes = sieve(upper)
    primeSet = toSet(primes)
    factorList = []

    for i in range(2, upper + 1):
        factorList[len(factorList):] = (factors(i, primes, primeSet))
        if i % (10 ** 2) == 0:
            print i

    print ("%s seconds" %(time.time() - start))

if __name__ == '__main__':
    main()