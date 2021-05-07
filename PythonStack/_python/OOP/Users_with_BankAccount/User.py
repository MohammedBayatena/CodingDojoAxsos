from Bankaccount import *

class User:

    def __init__(self,name,int_rate,balance=0):
        self.accountslist = []
        self.name=name
        self.accountslist.append(BankAcccount(int_rate,balance))

    def add_account(self,int_rate,balance):
        self.accountslist.append(BankAcccount(int_rate,balance))

    def make_withdrawal(self, amount):

        account = int(input("User "+self.name+" Please Enter the ID of The Account you want to withdraw money from: "))
        if account not in range(0,len(self.accountslist)):
            print("Account of similar ID doesnt exist for this user, Withdrawal Failed!")
        else:
            self.accountslist[account].withdraw(amount)
            return self


    def display_user_balance(self):
        account = int(input("User "+self.name+" Please Enter the ID of The Account You Want to Display Balance for: "))
        if account not in range(0, len(self.accountslist)):
            print("Account of similar ID doesnt exist for this user, Display Balance Failed!")
        else:
            print(self.accountslist[account].display_account_balance())

    def deposite(self,amount):

        account = int(input("User "+self.name+" Please Enter the ID of The Account You want to Deposit to: "))
        if account not in range(0, len(self.accountslist)):
            print("Account of similar ID doesnt exist for this user, Deposit Failed!")
        else:
            self.accountslist[account].deposite(amount)
            return self

    def transfer_money(self, other_user, amount):

        account = int(input("User "+self.name+" Please Enter the ID of The Account You want to send money (FROM): "))
        if account in range(0, len(self.accountslist)):
            account2 = int(input("Please Enter the ID of " + other_user.name+ " Account You want to send money (TO): "))
            if account2 in range(0, len(other_user.accountslist)):

                if (amount < self.accountslist[account].balance):
                    other_user.accountslist[account2].deposite(amount)
                    self.accountslist[account].withdraw(amount)
                return self
            else:
                print("Account of similar ID doesnt exist for this user, Transfer Failed!")
        else:
            print("Account of similar ID doesnt exist for this user, Transfer Failed!")

    def print_user_info(self):
        account = int(input("User "+self.name+" Please Enter the ID of The Account You want to show info for: "))
        if account not in range(0, len(self.accountslist)):
            print("Account of similar ID doesnt exist for this user, Display info Failed!")
        else:
            print("User Name is: " , self.name)
            self.accountslist[account].display_account_info()








