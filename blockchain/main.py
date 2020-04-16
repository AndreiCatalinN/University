import block
import datetime as date

def create_genesis_block():
    return block.Block(0, date.datetime.now(),
                       "Genesis Block", "0")


def next_block(last_block):


if __name__ == '__main__':
    create_genesis_block()