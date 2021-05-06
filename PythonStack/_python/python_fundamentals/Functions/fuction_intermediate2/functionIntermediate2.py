#---------------#1-----------------
x = [ [5,2,3], [10,8,9] ]
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

#1-a
x[1][0] =15
#1-b
students[0]['last_name'] = "Bryant"
#1-c
sports_directory['soccer'][0]= 'Andreas'
#i-d
z[0]['y'] = 30

#Uncomment below lines to see results
# print(x)
# print(students)
# print(sports_directory)
# print(z)

#---------------#2-----------------
students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
]

def iterateDictionary(students):
    for item in students:
        print(f"first_name - {item['first_name']}, last_name - {item['last_name']}" )


#Uncomment below lines to see results
# iterateDictionary(students)
#---------------#3-----------------
def iterateDictionary2(key_name, list):
    for item in students:
        print(item[key_name])

#Uncomment below lines to see results
# iterateDictionary2('last_name',students)

#---------------#4-----------------

dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}

def printInfo(dojo):
    for item in dojo:
        print(len(dojo[item]),str(item).upper())
        for value in dojo[item]:
            print(value)
        print("\t")

printInfo(dojo)











