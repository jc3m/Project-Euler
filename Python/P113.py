global count

def genIncreasing(n, lim):
    if n > lim:
        return
    print n
    count += 1
    for i in range(n % 10, 10):
        genIncreasing(n*10+i, lim)

def genDecreasing(n, lim):
    if n > lim:
        return
    print n
    count += 1
    for i in range(0, n % 10):
        genDecreasing(n*10+i, lim)

def main():
    count = 0
    for i in range(1, 10):
        genDecreasing(i, 1000)

if __name__ == '__main__':
    main()