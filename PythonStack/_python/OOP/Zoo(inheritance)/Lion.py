from Animal import *
class Lion(Animal):

    def __init__(self, name, age, wivesinharem, health_level=50, happiness_level=50):
        super().__init__(name, age, health_level, happiness_level)
        self.wivesinharem = wivesinharem

    def display_info(self):
        print("I am a Lion ")
        super().display_info()
        print(f"I have {self.wivesinharem} Wives in my harem")

    def makesound(self):
        print("Rawr Rawr")

    def expresspain(self):
        print("Holy Moly I'm dying, feed me Roar! Roar!")



