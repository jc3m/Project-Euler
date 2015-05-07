from sets import Set

def sieve(n):
    """ Returns  a list of primes < n """
    sieve = [True] * (n/2)
    for i in xrange(3,int(n**0.5)+1,2):
        if sieve[i/2]:
            sieve[i*i/2::i] = [False] * ((n-i*i-1)/(2*i)+1)
    return [2] + [2*i+1 for i in xrange(1,n/2) if sieve[i]]

def getL(l, minLen):
    cap = 10 ** (minLen-1)
    for i in range(0, len(l)):
        if l[i] > cap:
            return l[i:]
    return -1

def getDigits(num):
    m = [False] * 10
    while num:
        dig = num % 10
        m[dig] = True
        num /= 10
    res = []
    for i in range(0, len(m)):
        if m[i]:
            res.append(i)
    return res

def replace(num, primeSet):
    digs = getDigits(num)
    first = int(str(num)[0])

    maxPrimes = 0
    res = []

    for i in digs:
        r = range(0, 10)
        start = 0
        if i == first:
            r = r[1:]
        r.remove(i)
        passed = [num]
        for j in r:
            t = int(str(num).replace(str(i), str(j)))
            if t in primeSet:
                passed.append(t)

        if len(passed) > maxPrimes:
            maxPrimes = len(passed)
            res = passed

    return res

def main():
    digits = 2
    primes = getL(sieve(10 ** digits), digits)
    primeSet = Set(primes)

    maxLen = 0
    best = []

    while maxLen < 8:
        for i in primes:
            z = replace(i, primeSet)
            if len(z) > maxLen:
                maxLen = len(z)
                best = z

        digits += 1
        primes = getL(sieve(10 ** digits), digits)
        primeSet = Set(primes)

    print best
    #print getDigits(125316)

if __name__ == '__main__':
    main()