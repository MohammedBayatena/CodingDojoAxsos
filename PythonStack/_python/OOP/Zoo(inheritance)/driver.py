from Zoo import *

if __name__=="__main__":
    zoo1 = Zoo("John's Zoo")
    zoo1.add_lion("Nala", 10, 6, 70, 60)
    zoo1.add_lion("Simba", 5, 0)
    zoo1.add_tiger("Rajah", 12, 50, 5)
    zoo1.add_tiger("Shere Khan", 6, 10)
    zoo1.add_bear("Grizzly", 5, "16cm", 5, 5)
    zoo1.print_all_info()