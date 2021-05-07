import unittest
def reverse_list(list):
    copy = list.copy()
    copy.reverse()
    return copy
def ispalendrome(list):
    count=len(list)-1
    result = True
    for i in range(len(list)):
        if list[i] == list[count]:

           result= result and True
        else:
            result = result and False
        count-=1
    return result
def coins(amount):
    qcount=dcoun=ncount=pcount=0
    remainder=amount
    qcount,remainder = divmod(amount,25)
    dcount , remainder = divmod(remainder, 10)
    ncount, remainder = divmod(remainder, 5)
    pcount, remainder = divmod(remainder, 1)
    change = [qcount, dcount, ncount, pcount]
    return change
def factorial(num):
    if num == 1:
        return 1
    if num == 0:
        return 1
    else:
        return num*factorial(num-1)
def fibbonaci(num):
    if num == 0:
        return 0
    if num == 1:
        return 1
    else:
        return fibbonaci(num - 2) + fibbonaci(num - 1)

class reverse_listTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(reverse_list([1,3,5]), [5,3,1])
    def test2(self):
        self.assertEqual(reverse_list([8,2,10]), [10,2,8])
    def test3(self):
        self.assertEqual(reverse_list([1,1,1,1,1,1,1,1,1,1]), [1,1,1,1,1,1,1,1,1,1])
    def test4(self):
        self.assertEqual(reverse_list([1,3,5,1,3,5,1,3,5,1,3,5,1,3,5,1,3,5]), [5,3,1,5,3,1,5,3,1,5,3,1,5,3,1,5,3,1])
    # any task you want run before any method above is executed, put them in the setUp method
    def setUp(self):
        # add the setUp tasks
        print("running setUp")
    # any task you want run after the tests are executed, put them in the tearDown methodcopy
    def tearDown(self):
        # add the tearDown tasks
        print("running tearDown tasks")

class ispalendromeTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(ispalendrome("racecar"), True)
    def test2(self):
        self.assertEqual(ispalendrome("rabcr"), False)
    def test3(self):
        self.assertEqual(ispalendrome(""), True)
    def test4(self):
        self.assertEqual(ispalendrome("Ma aM"), True)
    def test5(self):
        self.assertEqual(ispalendrome("MaraMMaraMo"), False)
    def setUp(self):
        print("running setUp")
    def tearDown(self):
        print("running tearDown tasks")

class coinsTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(coins(87), [3,1,0,2])
    def test2(self):
        self.assertEqual(coins(50), [2,0,0,0])
    def test3(self):
        self.assertEqual(coins(123), [4,2,0,3])
    def test4(self):
        self.assertEqual(coins(47), [1,2,0,2])
    def test5(self):
        self.assertEqual(coins(0), [0,0,0,0])
    def setUp(self):
        print("running setUp")
    def tearDown(self):
        print("running tearDown tasks")

class  factorialTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(factorial(1), 1)
    def test2(self):
        self.assertEqual(factorial(0), 1 )
    def test3(self):
        self.assertEqual(factorial(5), 120)
    def test4(self):
        self.assertEqual(factorial(10), 3628800 )
    def test5(self):
        self.assertEqual(factorial(3), 6 )
    def setUp(self):
        print("running setUp")
    def tearDown(self):
        print("running tearDown tasks")

class fibbonaciTests(unittest.TestCase):
    def test1(self):
        self.assertEqual(fibbonaci(1), 1)
    def test2(self):
        self.assertEqual(fibbonaci(0), 0)
    def test3(self):
        self.assertEqual(fibbonaci(5), 5)
    def test4(self):
        self.assertEqual(fibbonaci(10), 55)
    def test5(self):
        self.assertEqual(fibbonaci(20), 6765)
    def setUp(self):
        print("running setUp")
    def tearDown(self):
        print("running tearDown tasks")

if __name__ == '__main__':
    unittest.main() # this runs our tests