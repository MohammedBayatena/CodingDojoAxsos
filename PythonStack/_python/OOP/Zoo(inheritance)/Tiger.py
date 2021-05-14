from Animal import *
class Tiger(Animal):
    def __init__(self, name, age, jumpheight, health_level=100, happiness_level=20):
        super().__init__(name, age, health_level, happiness_level)
        self.jumpheight = jumpheight

    def display_info(self):
        print("I am a Tiger ")
        super().display_info()
        print(f"I can jump {self.jumpheight} meters upward")

    def makesound(self):
        print("growl Rawr growl Rawr")

    def expresspain(self):
        print("Comm Susser Tod, Meow! Meow!")
