from django.db import models
import bcrypt

# Create your models here.

class User(models.Model):
    first_name = models.CharField(max_length=200)
    last_name = models.CharField(max_length=200)
    email = models.CharField(max_length=200)
    password = models.CharField(max_length=200)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    # cars =


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
