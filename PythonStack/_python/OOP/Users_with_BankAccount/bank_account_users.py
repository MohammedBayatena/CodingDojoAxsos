from User import *

user1 = User("Mohammed Bayatena",.05,5000)
user2 =  User("Hatsune Miku",.12,1000)

user1.print_user_info()
user2.print_user_info()
print("\n[[Values Updated]]\n")
user1.make_withdrawal(500).deposite(3000).transfer_money(user2,1000)
user1.print_user_info()
user2.print_user_info()


