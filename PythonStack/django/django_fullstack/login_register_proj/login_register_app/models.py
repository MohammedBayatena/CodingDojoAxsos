import re

from django.db import models


# Create your models here.
class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['firstname']) < 2:
            errors["firstname"] = "First name should be at least 2 characters"

        if len(postData['lastname']) < 2:
            errors["lastname"] = "Last name should be at least 2 characters"

        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):  # test whether a field matches the pattern
            errors['email'] = "Invalid email address!"

        if len(postData['password']) < 8:
            errors["passwordlen"] = "Password should be at least 8 characters"

        if postData['password'] != postData['confirmpassword']:
            errors["passwordmatch"] = "Password and Password confirmation don't match! "
        return errors


class User(models.Model):
    first_name = models.CharField(max_length=200)
    last_name = models.CharField(max_length=200)
    email = models.CharField(max_length=200)
    password = models.CharField(max_length=200)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    # cars =
    objects = UserManager()  # add this line!


class Car(models.Model):
    name = models.CharField(max_length=200)
    model = models.IntegerField()
    clients = models.ManyToManyField(User, related_name="cars")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def create_user(firstname, lastname, email, password):
    return User.objects.create(first_name=firstname, last_name=lastname, email=email, password=password)


def usercheckexist(email):
    users = User.objects.filter(email=email)
    if len(users) > 0:
        return users[0]
    else:
        return None


def get_user_cars(id):
    user = User.objects.get(id=id)
    return user.cars
