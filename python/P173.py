def genCap(holeSize, cap):
    maxSide = int((cap + (holeSize**2)) ** 0.5)
    return (maxSide - holeSize) / 2

def main():
    tiles = 1000000
    maxHole = tiles // 4 - 1
    total = 0
    for i in range(1, maxHole+1):
        total += genCap(i, tiles)
    print total

if __name__ == '__main__':
    main()