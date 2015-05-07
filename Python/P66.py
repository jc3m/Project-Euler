import math

def frac(alist):
    num = 1
    dem = alist[len(alist)-1]
    for i in range(len(alist)-2, 0, -1):
        tnum = num
        num = dem
        dem = alist[i] * dem + tnum

    num = alist[0]*dem + num
    #print [num, dem]
    return [num, dem]


def genCont(x, cycle):
    m = 0
    d = 1
    a = int(math.sqrt(x))
    mlist = [m]
    dlist = [d]
    alist = [a]

    count = 1

    while count <= cycle:
        n = len(mlist)-1
        mlist.append(dlist[n]*alist[n]-mlist[n])
        dlist.append((x-mlist[n+1]**2)/dlist[n])
        alist.append(int((alist[0]+mlist[n+1])/dlist[n+1]))
        count += 1

    #print mlist
    #print dlist
    return frac(alist)

def findD(d):
    found = False
    count = 1
    while not found:
        tl = genCont(d, count)
        x = tl[0]**2
        y = tl[1]**2
        if x - d*y == 1:
            return math.sqrt(x)
        count += 1

def main():
    maxVal = 0
    maxD = -1

    for i in xrange(2, 1001):
        if int(math.sqrt(i))**2 == i:
            continue
        t = findD(i)
        #print str(i) + ': ' + str(t)
        if t > maxVal:
            maxVal = t
            maxD = i

    print maxD

if __name__ == '__main__':
    main()