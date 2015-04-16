import math

def generate_palindromes_with_length(l):
    if l < 1:
        return []
    if l == 1:
        return [x for x in range(10)]
    p = []
    if (l % 2):
        half_length = (l - 1) / 2
        for x in xrange(0, 10):
            for y in xrange(10 ** (half_length - 1), 10 ** half_length):
                p.append(int(str(y) + str(x) + str(y)[::-1]))
    else:
        half_length = l / 2
        for x in xrange(10 ** (half_length - 1), 10 ** half_length):
            p.append(int(str(x) + str(x)[::-1]))
    p.sort()
    return p

def generate_palindrome(minx, maxx):
    min_len = len(str(minx))
    max_len = len(str(maxx))
    p = []
    for l in xrange(min_len, max_len + 1):
        for x in generate_palindromes_with_length(l):
            if x <= maxx and x >= minx:
                p.append(x)
    p.sort
    return p

def checkInt(a):
    return int(a) == a

def solveQ(a, b, c):
    d = b**2-4*a*c

    if d < 0:
        return False
    elif d == 0:
        x = (-b+math.sqrt(b**2-4*a*c))/2*a
        if x > 0 and checkInt(x):
            return True
        else:
            return False
    else:
        x1 = (-b+math.sqrt((b**2)-(4*(a*c))))/(2*a)
        x2 = (-b-math.sqrt((b**2)-(4*(a*c))))/(2*a)
        if x1 > 0 and checkInt(x1):
            return True
        if x2 > 0 and checkInt(x2):
            return True
        else:
            return False

def main():
    #print len(generate_palindrome(1, 10**8))
    #print solveQ(2, 2, -4)

    cap = 10**8

    count = 2
    alist = []
    blist = []
    clist = []
    tlist = []
    a = 2
    b = 2
    c = 1

    while (a + b + c < cap):
        alist.append(a)
        blist.append(b)
        clist.append(c)
        tlist.append(a+b+c)
        a += 1
        b += count*2
        c += count ** 2
        count += 1

    palindromes = generate_palindrome(1, cap)

    count = 0
    total = 0

    for i in palindromes:
        j = 0
        found = False
        while j < len(tlist) and i >= tlist[j] and not found:
            #print i
            if solveQ(alist[j], blist[j], clist[j] - i):
                found = True
                count += 1
                total += i
            j += 1
    print count
    print total


if __name__ == '__main__':
    main()