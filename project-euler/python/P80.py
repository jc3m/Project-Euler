from decimal import *
import re

def sum_digits(n):
    s = 0
    #counter = 0
    while n:
        s += n % 10
        #counter += 1
        n /= 10
    #print s
    #print counter
    return s

def is_square(apositiveint):
  x = apositiveint // 2
  seen = set([x])
  while x * x != apositiveint:
    x = (x + (apositiveint // x)) // 2
    if x in seen: return False
    seen.add(x)
  return True

def calc(n):
    getcontext().prec = 105
    f = str(Decimal(n).sqrt())
    n = int((re.sub('[.]', '', f))[:100])
    return sum_digits(n)

def main():
    total = 0
    for i in range(2, 101):
        if not is_square(i):
            total += calc(i)
    print total

if __name__ == '__main__':
    main()