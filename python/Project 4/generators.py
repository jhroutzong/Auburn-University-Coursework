
def fibonacci():
    flag = True
    a = 1
    iter = 1
    while True:
        if (iter < 3):
            b = a
            iter = iter + 1
            yield a
        else:
            c = a + b
            b = a
            a = c
            yield c

if __name__ == "__main__":
    g = fibonacci()
    value = next(g)
    print(value)
    print(next(g))
    print(next(g))
    print(next(g))



