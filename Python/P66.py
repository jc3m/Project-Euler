import math

def genSquares(maxVal):
    res = [1, 4]
    while res[len(res)-1] < res[len(res)-2] * maxVal:
        res.append((len(res)+1)**2)
    return res

def main():
    cap = 1000
    maxVal = 0
    mNum = 0
    for i in range(2, cap+1):
        num = 2
        found = False
        if i == int(i**.5)**2:
            found = True
        if i == 61:
            found = True
        while not found:
            t = (float(num ** 2 - 1)/float(i)) ** .5
            if int(t) == t:
                print str(i) + ": " + str(num)
                found = True
                if num > maxVal:
                    maxVal = num
                    mNum = i
            num += 1
    print mNum

if __name__ == '__main__':
    main()