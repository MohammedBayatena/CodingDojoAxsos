from Animal import *
class Bear(Animal):
    def __init__(self, name, age, clawssize, health_level=30, happiness_level=60):
        super().__init__(name, age, health_level, happiness_level)
        self.clawssize = clawssize

    def display_info(self):
        print("I am a Bear ")
        super().display_info()
        print(f"I have Claws that are {self.clawssize} in size")

    def makesound(self):
        print("growl! growl!")

    def expresspain(self):
        print("Panik! Panik! i can smell Salmons! Feed me GROWL!")
