class User:

    def __init__(self,name,balance):
        self.name=name
        self.balance=balance

    def make_withdrawal(self, amount):
        if amount < self.balance:
            self.balance-=amount

    def display_user_balance(self):
        print(self.balance)

    def deposite(self,amount):
        self.balance+=amount

    def transfer_money(self, other_user, amount):
        if (amount < self.balance):
            other_user.deposite(amount)
            self.balance-=amount

    def print_user_info(self):
        print("User Name is: " , self.name)
        print("User Balance is: ",self.balance,"$")


user1 = User("Mohammed Bayatena",10)
user2 =  User("Hatsune Miku",1000000)
user3 = User ("Jack Ma",200000)

#
user1.deposite(500)
user1.deposite(300)
user1.deposite(100)
user1.make_withdrawal(10)
user1.print_user_info()
print("-"*30)
user2.deposite(500)
user2.deposite(300)
user2.make_withdrawal(300)
user2.make_withdrawal(500)
user2.print_user_info()
print("-"*30)
user3.deposite(300)
user3.make_withdrawal(300)
user3.make_withdrawal(500)
user3.make_withdrawal(500)
user3.print_user_info()
print("-"*30)
user2.transfer_money(user1,161616)
user1.print_user_info()
user2.print_user_info()



