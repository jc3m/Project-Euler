import math

def main():
    primeNum = 10001
    upperBound = int(primeNum * math.log(primeNum) + primeNum * math.log(math.log(primeNum)) + 1)
    print sieve(upperBound)[primeNum-1]
    
def sieve(upperBound):
    nums = dict()
    for i in range(2, upperBound):
        nums[i] = True

    for i in nums:
        multiples = range(i, upperBound, i)
        for j in multiples[1:]:
            nums[j] = False

    return [n for n in nums if nums[n]]

if __name__ == '__main__':
    main()