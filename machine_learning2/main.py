import pandas as pd


def traders_by_county(df):
    counties = df['county'].unique()
    for county in counties:
        fuel_stops = df['trading_name'][df['county'] == county]
        print(county, ' : ', fuel_stops.count())


def traders_by_county2(df):
        data = df.groupby(['county']).count()
        print(data)


def clear_data(df):
    return df


def main():
    df = pd.read_csv("./register-marked-fuel-traders.csv")
    df = clear_data(df)
    traders_by_county2(df)
    return 0


if __name__ == '__main__':
    main()