const express = require("express");  //Import Express
var faker = require('faker'); // Import Faker

const app = express(); // Call Express

app.use( express.json() );  //Must be used for Post/Put/delete Requests
app.use( express.urlencoded({ extended: true }) ); //Must be used for Post/Put/delete Requests

const port = 8000;

//This is a User Class
class User{
  constructor(){
      this._id = Math.floor(Math.random() * (10000 - 1) + 1);
      this.firstName = faker.name.firstName();
      this.lastName = faker.name.lastName();
      this.phoneNumber = faker.phone.phoneNumber();
      this.email = faker.internet.email();
      this.password = faker.internet.password();
  }
}

//This is a Company Class
class Company {
  constructor(){
    this._id = Math.floor(Math.random() * (10000 - 1) + 1);
    this.name = faker.company.companyName();
    this.address = {
      
        street: faker.address.streetAddress(),
        city: faker.address.city(),
        state: faker.address.state() ,
        zipCode: faker.address.zipCode(),
        country: faker.address.country()
    };
  }
}

//Handle Api call
app.get("/api", (req, res) => {
  res.send("I Like Hatsune Miku");
});

//Handle new user get request
app.get("/api/users/new", (req, res) => {
  res.json( new User() );
});

//Handle new company get request
app.get("/api/companies/new", (req, res) => {
  res.json( new Company()  );
});

//Handle new company and new user get request
app.get("/api/user/company", (req, res) => {
  res.json({User: new User() , Company: new Company()} );
});

//Listen at port 8000
const server = app.listen(8000, () =>
  console.log(`Server is locked and loaded on port ${server.address().port}!`)
);
