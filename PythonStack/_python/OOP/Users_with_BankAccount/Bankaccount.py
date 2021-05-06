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
        print("Interest Rate is " , self.int_rate*100,"%")

    def display_account_balance(self):
        print("Balance is : ", self.balance, "$")

    def yield_interest(self):
        self.balance= self.balance +  self.balance*self.int_rate
        return self


