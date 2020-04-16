import pandas as pd


def describe(data):
    print('min ', data['normalized-losses'].min())
    print('max ', data['normalized-losses'].max())
    print('count ', data['normalized-losses'].count())
    print('mean ', data['normalized-losses'].mean())
    print('standard ', data['normalized-losses'].std())
    print(data['normalized-losses'].quantile([0.25, 0.5, 0.75]))
    print()
    print(data['normalized-losses'].describe())


def print_sorted_losses(data):
    sorted_prices = data['price'].value_counts().sort_index()
    print(sorted_prices)


# def make_graph(graph_data, graph_name):
#     graph_data.plot(kind='bar', color='SteelBlue')
#     plt.title(graph_name)
#     plt.xlabel('value')
#     plt.ylabel('count')


def print_cars(data):
    cars = data['make'].unique()
    print(data['make'].count())
    print(cars)
    print(data[data['make'] == 'jaguar'])


def main():
    with open('feature_names_lab3.txt') as f:
        names = f.read().split('\n')
    data = pd.read_csv('dataset_lab3.csv',
                       names=names, na_values='?')
    print(data)
    return 0


if __name__ == '__main__':
    main()
