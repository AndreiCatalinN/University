import pandas as pd
import data_sets as data

def main():
    series = pd.Series(data.numbers, data.index)
    data_frame = pd.DataFrame(data.data, data.columns)
    return 0

if __name__ == '__main__':
    main()
