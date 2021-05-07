import unittest

class MathDojo:
    def __init__(self):
        self.result = 0

    def add(self, num, *nums):
        self.result += num
        for number in nums:
            self.result += number
        return self

    def subtract(self, num, *nums):
        self.result -= num
        for number in nums:
            self.result -= number
        return self

class addTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(self.md.add(1,2).add(2).add(1,1,1,1,1).result, 10)
    def test2(self):
        self.assertEqual(self.md.add(1,2,100).add(0).add(1,1,1,1,1,500).result, 608)
    def test3(self):
        self.assertEqual(self.md.add(0,7).add(10).add(0,-1,0,0,-19).result, -3)
    def setUp(self):
        print("Initializing an instance of Dojo")
        self.md = MathDojo()
    def tearDown(self):
        self.md.result=0
#
class SubtractTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(self.md.subtract(1,2).subtract(2).subtract(1,1,1,1,1).result, -10)
    def test2(self):
        self.assertEqual(self.md.subtract(1,2,-100).add(0).subtract(50).result, 47)
    def test3(self):
        self.assertEqual(self.md.subtract(0,0).add(15015).subtract(0,-1,0,-15015,-19).result, 30050)
    def setUp(self):
        print("Initializing an instance of Dojo")
        self.md = MathDojo()
    def tearDown(self):
        print("Reseting Dojo instnace to zero")
        self.md.result=0

if __name__ == '__main__':
    unittest.main() # this runs our tests

