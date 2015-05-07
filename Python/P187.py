def sieve(n):
    """ Returns  a list of primes < n """
    sieve = [True] * (n/2)
    for i in xrange(3,int(n**0.5)+1,2):
        if sieve[i/2]:
            sieve[i*i/2::i] = [False] * ((n-i*i-1)/(2*i)+1)
    return [2] + [2*i+1 for i in xrange(1,n/2) if sieve[i]]

def search(n, primes):
    if n > primes[len(primes) - 1]:
        return len(primes) - 1
    return searchRecur(n, primes, 0, len(primes))

def searchRecur(n, primes, begin, end):
    mid = (begin + end) / 2
    if primes[mid] <= n and primes[mid+1] > n:
        return mid
    if primes[mid] > n:
        return searchRecur(n, primes, begin, mid-1)
    return searchRecur(n, primes, mid+1, end)

def num(i, primes):
    cap = 10 ** 8
    #cap = 30
    n = cap // i
    if i > n:
        return 0
    r = search(n, primes) - search(i, primes) + 1
    #print i, n, r
    return r

def calc(primes):
    total = 0
    for i in range(0, len(primes)):
        total += num(primes[i], primes)
    return total

def main():
    nums = sieve((10**8)/2)
    #print nums
    print calc(nums)

if __name__ == '__main__':
    main()