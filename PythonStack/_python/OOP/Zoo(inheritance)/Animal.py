class Animal:

    def __init__(self, name, age, health_level=100, happiness_level=50):
        self.name = name
        self.age = age
        self.health_level = health_level
        self.happiness_level = happiness_level

    def display_info(self):
        print(
            f"Name: {self.name} Age: {self.age} Health Level: {self.health_level}% Happiness Level: {self.happiness_level}%")

    def makesound(self):
        print("---")

    def expresspain(self):
        print("---")

    def feed(self, maxhappy=100, maxhealth=100):

        if self.happiness_level > 60:
            self.makesound()

        if self.health_level < 20:
            self.expresspain()

        if self.happiness_level < maxhappy:
            self.happiness_level += 10
        else:
            print("Happiness is full yay!")

        if self.health_level < maxhealth:
            self.health_level += 10
        else:
            print("Health is at max! Nice!!")
