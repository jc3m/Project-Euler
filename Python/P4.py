def main():
    largest = 0
    for i in range(100, 1000):
        for j in range(i, 1000):
            if isPalindrome(i * j) and i * j > largest:
                largest = i * j
    print largest

def isPalindrome(num):
    s = str(num)
    return s == s[::-1]

if __name__ == '__main__':
    main()