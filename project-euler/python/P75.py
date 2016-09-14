def main():
    upper = 1500000
    bound = int((upper/2)**.5)

    perims = dict()

    for i in range(1, bound):
        for j in range(i + 1, bound):
            if gcd(i, j) == 1 and (j - i) % 2 == 1:
                orig = triple(j, i)
                trip = orig
                while trip < upper:
                    if perims.has_key(trip):
                        perims[trip] += 1
                    else:
                        perims[trip] = 1
                    trip += orig

    total = 0
    for i in perims:
        if perims[i] == 1:
            total += 1

    print total

def gcd(M, N):
    m = M
    n = N
    while n != 0:
        t = n
        n = m % n
        m = t
    return m

def triple(m, n):
    a = m ** 2 - n ** 2
    b = 2 * m * n
    c = m ** 2 + n ** 2
    return a + b + c

if __name__ == '__main__':
    main()