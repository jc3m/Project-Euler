def main():
    fibs = [1,1]
    while fibs[len(fibs)-1] < 4000000:
        l = len(fibs)
        fibs.append(fibs[l-1] + fibs[l-2])
    evenFibs = [n for n in fibs if n % 2 == 0]
    print total(evenFibs)

def total(l):
    t = 0
    for i in l:
        t += i
    return t

if __name__ == '__main__':
    main()