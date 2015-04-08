def genA():
    v = [5,65,901]
    while v[len(v)-1] < 1000000000/3+1:
        ind = len(v)
        v.append(15*v[ind-1]-15*v[ind-2]+v[ind-3])
    v.pop()
    return v

def genB():
    v = [16,240,3360]
    while v[len(v)-1] < 1000000000/3+1:
        ind = len(v)
        v.append(15*v[ind-1]-15*v[ind-2]+v[ind-3])
    v.pop()
    return v

def main():
    total = 0
    A = genA()
    for i in range(0, len(A)):
        total += A[i]*3 + 1
    B = genB()
    for i in range(0, len(B)):
        total += B[i]*3 + 2
    print total

if __name__ == '__main__':
    main()