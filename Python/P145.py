def check(n):
    while (n):
        if n % 2 == 0:
            return False
        n /= 10
    return True

def addr(n):
    return int(str(n)[::-1]) + n

def test(n):
    count = 0
    for i in range(10, 10 ** n + 1):
        if i % 2 != 0:
            temp = addr(i)
            if check(temp):
                count += 1
                #print str(i) + ': ' + str(temp)
    print str(count * 2)

def main():
    for i in range(2, 9):
        test(i)

if __name__ == '__main__':
    main()