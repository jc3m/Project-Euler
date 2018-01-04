def main():
    upperBound = 2000000
    nums = dict()
    for i in range(2, upperBound):
        nums[i] = True

    for i in range(2, upperBound):
        seq = range(i, upperBound, i)
        for j in seq[1:]:
            nums[j] = False

    primes = [n for n in nums if nums[n]]
    print sum(primes)

if __name__ == '__main__':
    main()