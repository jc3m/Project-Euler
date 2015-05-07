import time

def readIn(filepath):
    res = []
    f = open(filepath)
    z = []
    for i in f:
        z.append(i)
    f = z
    for i in range(0, len(f), 10):
        r = 0
        t = []
        for j in range(1, 10):
            t.append([])
            s = f[i+j].strip()
            for k in s:
                t[r].append(int(k))
            r += 1
        res.append(t)
    return res

def solved(grid):
    for i in range(8, -1, -1):
        for j in range(8, -1, -1):
            if grid[i][j] == 0:
                return False

    for i in range(0, 9):
        for j in range(0, 9):
            if not isValid(i, j, grid):
                print 'False Board'
                return False

    return True

def isValid(r, c, grid):
    rows = [0] * 10
    cols = [0] * 10
    square = [0] * 10
    for i in range(0, 9):
        rows[grid[r][i]] += 1
    for i in range(0, 9):
        cols[grid[i][c]] += 1
    x = (r // 3) * 3
    y = (c // 3) * 3
    for i in range(x, x+3):
        for j in range(y, y+3):
            square[grid[i][j]] += 1

    for i in range(1, 10):
        if rows[i] > 1 or cols[i] > 1 or square[i] > 1:
            return False
    return True

def mostConstrained(grid):
    minP = 10
    minI = -1
    minJ = -1
    for i in range(0, 9):
        for j in range(0, 9):
            if grid[i][j] != 0:
                continue
            count = 0
            for k in range(1, 10):
                grid[i][j] = k
                if isValid(i, j, grid):
                    count += 1
            if count == 1:
                return [i, j]

            if count < minP:
                minP = count
                minI = i
                minJ = j
            grid[i][j] = 0
    return [minI, minJ]

def getValid(r, c, grid):
    res = []
    for i in range(1, 10):
        grid[r][c] = i
        if isValid(r, c, grid):
            res.append(i)
    grid[r][c] = 0
    return res

def printGrid(grid):
    for i in grid:
        print i

def solve(grid):
    if solved(grid):
        return grid[0][0] * 100 + grid[0][1] * 10 + grid[0][2]
    else:
        point = mostConstrained(grid)
        x = point[0]
        y = point[1]
        l = getValid(x, y, grid)
        for i in l:
            grid[x][y] = i
            z = solve(grid)
            if z > 0:
                return z
            grid[x][y] = 0
    return -1


def main():
    fp = 'p096_sudoku.txt'
    grid = readIn(fp)
    total = 0
    count = 0
    for i in grid:
        start = time.time()
        total += solve(i)
        count += 1
        print total, count, (time.time()-start)
    print total

if __name__ == '__main__':
    main()