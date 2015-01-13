def main():
    nums = [n for n in range(1000) if n % 3 == 0 or n % 5 == 0]
    total = 0
    for n in nums:
        total += n
    print total

if __name__ == '__main__':
    main()