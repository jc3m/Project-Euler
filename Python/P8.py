def main():
    filepath = 'Euler8.txt'
    f = open(filepath)
    string = ''
    for i in f:
        string += i.rstrip('\n')
    
    maximum = 0
    for i in range(len(string)-13):
        product = 1
        for j in range(13):
            product *= int(string[i+j])
        if product > maximum:
            maximum = product
    print maximum

if __name__ == '__main__':
    main()