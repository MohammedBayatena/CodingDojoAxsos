from Bear import *
from Lion import *
from Tiger import *


class Zoo:
    def __init__(self, zoo_name):
        self.animals = []
        self.name = zoo_name

    def add_lion(self, name, age, wivesno, *args):
        self.animals.append(Lion(name, age, wivesno, *args))

    def add_tiger(self, name, age, jump, *args):
        self.animals.append(Tiger(name, age, jump, *args))

    def add_bear(self, name, age, clawsize, *args):
        self.animals.append(Bear(name, age, clawsize, *args))

    def print_all_info(self):
        print("-" * 30, self.name, "-" * 30)
        for animal in self.animals:
            animal.display_info()
