def genIncreasing(n, lim):
    if n > lim:
        return
    print n

    for i in range(n % 10, 10):
        genIncreasing(n*10+i, lim)

def genDecreasing(n, lim):
    if n > lim:
        return
    print n
    for i in range(0, n % 10):
        genDecreasing(n*10+i, lim)

def numIncreasing(level, digit):
    if level == 0:
        return 1
    total = 1
    for i in range(digit, 10):
        total += numIncreasing(level - 1, i)
    return total

def numDecreasing(level, digit):
    if level == 0:
        return 1
    total = 1
    for i in range(0, digit):
        total += numDecreasing(level-1, i)
    return total

def main():
    total = 0
    for i in range(1, 10):
        print str(i) + "..."
        total += numIncreasing(6, i)
        total -= 1
        total += numDecreasing(6, i)
    print total

if __name__ == '__main__':
    main()