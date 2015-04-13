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

def findPos(init, num, lim):
    n = num[init]
    maxNum = lim//n
    for i in range(init, len(num)):
        if maxNum < num[i]:
            return i - init
    return len(num) - init

def count(nums, lim):
    total = 0
    for i in range(len(nums)//2+1):
        total += findPos(i, nums, lim)
        #print str(nums[i]) + ": " + str(findPos(i, nums, lim))
    return total

def main():
    nums = sieve(10**7)
    print len(nums)
    #print len(sieve(10**7))

if __name__ == '__main__':
    main()