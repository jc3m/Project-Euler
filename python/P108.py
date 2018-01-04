cdef factors(n):    
    return set(reduce(list.__add__, 
                ([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))

def triples(m, n, k):
    #6 permutations unless duplicates
    x = k*m*(m+n)
    y = k*n*(m+n)
    z = k*m*n
    return [x,y,z]

def gen(x):
    s = set()
    count = 0
    facs = list(factors(x))
    for i in range(0, len(facs)):
        for j in range(0, len(facs)):
            k = float(x) / float(facs[i]*facs[j])
            if int(k) == k:
                ts = triples(facs[i], facs[j], k)
                if not (ts[0], ts[1]) in s and not (ts[1], ts[0]) in s:
                    s.add((ts[0], ts[1]))
    return len(s)

def main():
    found = False
    n = 4

    #print gen(4)

    while not found:
        n += 1
        if len(factors(n)) < 30:
            continue
        s = gen(n)
        print str(n) + ": " + str(s) + " facs: " + str(len(factors(n)))
        if s > 1000:
            print n
            found = True


if __name__ == '__main__':
    main()