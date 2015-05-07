def genDigits(num):
    res = [0] * 10
    for i in str(num):
        res[int(i)] += 1

    s = ''
    for i in res:
        s += str(i)
    return s

def main():
    cubes = dict()
    
    count = 1
    while True:
        t = genDigits(count**3)
        if t not in cubes:
            cubes[t] = [count**3]
        else:
            cubes[t].append(count**3)
            if len(cubes[t]) == 5:
                print cubes[t]
                return
        count += 1
    #print cubes

if __name__ == '__main__':
    main()