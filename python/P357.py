import math
from sets import Set

primes = []

def factors(n):    
  return set(reduce(list.__add__, ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

def sieve(n):
  b = [True] * n + [True]
  b[0] = False
  b[1] = False
  for i in xrange(0, len(b)):
    if b[i]:
      cur = i ** 2
      while cur <= n:
        b[cur] = False
        cur += i

  nums = []
  for i in xrange(0, len(b)):
    if b[i]:
      nums.append(i)
  return Set(nums)

def primes_sieve2(limit):
  a = [True] * limit                   # Initialize the primality list
  a[0] = a[1] = False

  for (i, isprime) in enumerate(a):
    if isprime:
      yield i
      for n in xrange(i*i, limit, i):  # Mark factors non-prime
        a[n] = False

def sieveF(n):
    "Return all primes <= n."
    np1 = n + 1
    s = list(range(np1)) # leave off `list()` in Python 2
    s[1] = 0
    sqrtn = int(round(n**0.5))
    for i in range(2, sqrtn + 1): # use `xrange()` in Python 2
        if s[i]:
            # next line:  use `xrange()` in Python 2
            s[i*i: np1: i] = [0] * len(range(i*i, np1, i))
    return filter(None, s)


def checkNum(n):
  f = factors(n)
  for j in f:
    temp = j + n/j
    if not temp in primes:
      return False
  return True

def main():
  # Must be even

  global primes
  primes = Set(sieveF(100000001))
  print 'primes generated'
  total = 0
  for i in range(1, 100000001):
    if checkNum(i):
      total += i
  print total
  #print 'start'
  #s = sieveF(100000000)
  #print 'converting to set'
  #x = Set(s)
  #print 'end'

if __name__ == '__main__':
  main()