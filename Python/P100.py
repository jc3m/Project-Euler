def genX(x0, y0):
    return 3*x0 + 2*y0 - 2

def genY(x0, y0):
    return 4*x0 + 3*y0 - 3

def main():
    x0 = 1
    y0 = 1

    cap = 10 ** 12

    while (x0 + y0) < cap:
        t1 = x0
        t2 = y0
        x0 = genX(t1, t2)
        y0 = genY(t1, t2)

    print x0



if __name__ == '__main__':
    main()