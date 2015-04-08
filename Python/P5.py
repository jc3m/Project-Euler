def main():
    num = 1
    for i in range(1, 21):
        num = lcm(num, i)
    print num

def lcm(A, B):
    return abs(A * B)/gcd(A, B)

def gcd(A, B):
    a = A
    b = B
    while b != 0:
        temp = b
        b = a % b
        a = temp
    return a

if __name__ == '__main__':
    main()