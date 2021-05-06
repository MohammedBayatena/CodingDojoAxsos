from Bankaccount import *

class User:

    def __init__(self,name,int_rate,amount=0):
        self.name=name
        self.account = BankAcccount(int_rate,amount)

    def make_withdrawal(self, amount):
       self.account.withdraw(amount)
       return self

    def display_user_balance(self):
        print(self.account.display_account_balance())

    def deposite(self,amount):
        self.account.deposite(amount)
        return self

    def transfer_money(self, other_user, amount):
        if (amount < self.account.balance):
            other_user.deposite(amount)
            self.make_withdrawal(amount)
        return self

    def print_user_info(self):
        print("User Name is: " , self.name)
        self.account.display_account_info()








