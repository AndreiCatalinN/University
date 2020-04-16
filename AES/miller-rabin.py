from random import randint


def miller_rabin():
    n = randint(3, 10000)
    a = randint(1, n - 1)
    k = 1
    q = 1

    calc = pow(2, k) * q
    while n - 1 != calc and calc < n:
        k += 1
        q += 2
        calc = pow(2, k) * q

    if pow(a, q) % n == 1:
        return "Inconclusive"

    for j in range(k):
        if pow(a, pow(2, j) * q) % n == n - 1:
            return "Inconclusive"

    return "Composite"


if __name__ == '__main__':
    print(miller_rabin())
