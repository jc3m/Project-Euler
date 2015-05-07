def isPrime(a):
    return not ( a < 2 or any(a % i == 0 for i in range(2, int(a ** 0.5) + 1)))

def phi(n):
    y = n
    for i in range(2,n+1):
        if isPrime(i) and n % i == 0:
            y *= 1 - 1.0/i
    return float(y)

def sieve(n):
    """ Returns  a list of primes < n """
    sieve = [True] * (n/2)
    for i in xrange(3,int(n**0.5)+1,2):
        if sieve[i/2]:
            sieve[i*i/2::i] = [False] * ((n-i*i-1)/(2*i)+1)
    return [2] + [2*i+1 for i in xrange(1,n/2) if sieve[i]]

def genDigits(num):
    res = [0] * 10
    for i in str(num):
        res[int(i)] += 1

    return res

def main():
    cap = 10 ** 7
    primes = sieve(cap/2)

    for a in range(0, len(primes)):
        for b in range(a+1, len(primes)):
            i = primes[a]
            j = primes[b]
            n = i*j
            pn = (i-1)*(j-1)

            if i*j > cap:
                continue

            if genDigits(n) == genDigits(pn):
                print n, pn

if __name__ == '__main__':
    main()