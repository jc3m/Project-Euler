import time
start = time.time()

def checkRight(xi, yi, xj, yj):
    if xi == 0 and yi == 0:
        return False
    if (xi*xj)+(yi*yj) == 0:
        return True
    xk = xi - xj
    yk = yi - yj
    if (xi*xk)+(yi*yk) == 0:
        return True
    if (xj*xk)+(yj*yk) == 0:
        return True
    return False

def main():
    cap = 50
    width = cap + 1
    pointCap = (width) ** 2
    counter = 0
    for i in range(0, pointCap):
        for j in range(i+1, pointCap):
            xi = i % width
            yi = i // width
            xj = j % width
            yj = j // width
            if checkRight(xi, yi, xj, yj):
                #print "(" + str(xi) + ", " + str(yi) + ");(" + str(xj) + ", " + str(yj) + ")"
                counter += 1
    print counter
    execution = (time.time() - start)
    print("Executed in %s seconds" %(execution))

if __name__ == '__main__':
    main()