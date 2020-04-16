def key_expansion(key, word):
    w = []
    for i in range(4):
        w[i] = (key[4 * i],
                key[4 * i + 1],
                key[4 * i + 2],
                key[4 * i + 3])

    for i in range(4, 44):
        temp = w[i-1]
        if i % 4 == 0:
            temp = subword(rotword(temp))
