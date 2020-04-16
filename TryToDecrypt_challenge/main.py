#text = '''abcdefghijklmnopqrstuvwxyz -_.,;:?!0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'''
#code = ''''''


def decode_text_4(char_map, text):
    i = 0
    while i < len(text):
        search = text[i] + text[i + 1] + text[i + 2] + text[i + 3]
        print(char_map.get(search), end='')
        i += 4


def decode_text_3(char_map, text):
    i = 0
    decoded_text = ''
    while i < len(text):
        search = text[i] + text[i + 1] + text[i + 2]
        decoded_text += char_map.get(search)
        i += 3
    return decoded_text


def decode_text(char_map, text):
    i = 0
    decoded_text = ''
    while i < len(text):
        search = text[i] + text[i + 1]
        decoded_text += char_map.get(search)
        i += 2
    return decoded_text


def make_dict_4(code, text):
    char_map = {}
    i = 0
    j = 0
    while i < len(code):
        key = code[i] + code[i + 1] + code[i + 2] + code[i + 3]
        char_map[key] = text[j]
        j += 1
        i += 4
    return char_map


def make_dict_3(code, text):
    char_map = {}
    i = 0
    j = 0
    while i < len(code):
        key = code[i] + code[i + 1] + code[i + 2]
        char_map[key] = text[j]
        j += 1
        i += 3
    return char_map


def make_dict(code, text):
    char_map = {}
    i = 0
    j = 0
    while i < len(code):
        key = code[i] + code[i + 1]
        char_map[key] = text[j]
        j += 1
        i += 2
    return char_map


if __name__ == '__main__':
    pass