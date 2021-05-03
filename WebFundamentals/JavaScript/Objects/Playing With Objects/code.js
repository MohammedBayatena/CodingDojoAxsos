var users = [
    {
        name: "Michael",
        age: 37
    },
    {
        name: "John",
        age: 30
    },
    {
        name: "David",
        age: 27
    }
];

//Johns Name
console.log(users[1].age);
//name of first object
console.log(users[0].name);
//name and age of all objects

for ( var user in users) {
console.log("Name: "+users[user].name+" ,Age: "+users[user].age);
}