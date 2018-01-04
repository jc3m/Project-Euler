max_value = 1000

def sumDivisbleBy(n):
  cap = (max_value - 1) // n
  return cap * (cap+1) / 2 * n

def main():
  print sumDivisbleBy(3) + sumDivisbleBy(5) - sumDivisbleBy(15)

if __name__ == '__main__':
  main()