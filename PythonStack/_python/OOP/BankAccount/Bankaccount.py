class BankAcccount:

    def __init__(self,int_rate, balance=0):
        self.int_rate=int_rate
        self.balance=balance

    def deposite(self,amount):
        self.balance+=amount
        return self

    def withdraw(self, amount):
        if amount < self.balance:
            self.balance-=amount
        return self

    def display_account_info(self):
        print("Balance is : " ,self.balance , "$")
        print("Intrest Rate is " , self.int_rate*100,"%")

    def yield_interest(self):
        self.balance= self.balance +  self.balance*self.int_rate
        return self

account1 = BankAcccount(.1)
account2 = BankAcccount(.01,1000)

account1.deposite(100).deposite(100).deposite(100).withdraw(200).display_account_info()
account2.deposite(50).deposite(50).withdraw(10).withdraw(10).withdraw(10).withdraw(10).yield_interest().display_account_info()

