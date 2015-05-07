import math

def genCont(x):
    m = 0
    d = 1
    a = int(math.sqrt(x))
    mlist = [m]
    dlist = [d]
    alist = [a]

    count = 2

    mlist.append(dlist[0]*alist[0]-mlist[0])
    dlist.append((x-mlist[1]**2)/dlist[0])
    alist.append(int((alist[0]+mlist[1])/dlist[1]))

    m2 = mlist[1]
    d2 = dlist[1]

    n = len(mlist)-1
    mlist.append(dlist[n]*alist[n]-mlist[n])
    dlist.append((x-mlist[n+1]**2)/dlist[n])
    alist.append(int((alist[0]+mlist[n+1])/dlist[n+1]))

    while mlist[len(mlist)-1] != m2 or  dlist[len(mlist)-1] != d2:
        n = len(mlist)-1
        mlist.append(dlist[n]*alist[n]-mlist[n])
        dlist.append((x-mlist[n+1]**2)/dlist[n])
        alist.append(int((alist[0]+mlist[n+1])/dlist[n+1]))
        count = n + 1

    #print mlist
    #print dlist
    #print alist

    return count - 1

def main():
    count = 0

    for i in range(2, 10000):
        if (int(math.sqrt(i)) ** 2) != i:
            if genCont(i) % 2 == 1:
                count += 1
    print count

if __name__ == '__main__':
    main()