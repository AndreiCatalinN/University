import main

letters = 'abcdefghijklmnopqrstuvwxyz -_.,;:?!0123456789'
punctuation_digits = 'ABCDEFGHIJKLMNOPQRSTUVWX'
coded_letters = '1A1C1E1D1F2120222423252726282A292B2D2C2E302F31333234584E505251535554561211131514161817191B'
code_punct_digits = ''


if __name__ == '__main__':
    encrypted = '261129152E152B'
    char_map = main.make_dict(coded_letters, letters)
    print(char_map)
    result = main.decode_text(char_map, encrypted)
    print(result)
