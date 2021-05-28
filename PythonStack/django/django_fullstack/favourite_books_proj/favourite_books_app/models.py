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
    # books =
    # books_liked =
    objects = UserManager()  # add this line!


def create_user(firstname, lastname, email, password):
    return User.objects.create(first_name=firstname, last_name=lastname, email=email, password=password)


def usercheckexist(email):
    users = User.objects.filter(email=email)
    if len(users) > 0:
        return users[0]
    else:
        return None


def getuserby_id(id):
    try:
        user = User.objects.get(id=id)
    except Exception as e:
        print("couldnt get user", e)
        return None
    return user


class BookManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['title']) < 1:
            errors["title"] = "Title is required"
        if len(postData['desc']) < 5:
            errors["desc"] = "Description should be at least 5 characters"
        return errors


class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    uploaded_by_id = models.ForeignKey(User, related_name='books', on_delete=models.CASCADE)
    users_who_like = models.ManyToManyField(User, related_name="books_liked")
    objects = BookManager()


def create_book(title, description, uploaded_by_id):
    book = Book.objects.create(title=title, desc=description, uploaded_by_id=uploaded_by_id)
    book.users_who_like.add(uploaded_by_id)
    return book


def getbookby_id(id):
    try:
        book = Book.objects.get(id=id)
    except Exception as e:
        print("couldnt get book", e)
        return None
    return book


def bookcheckexist(bookid):
    books = Book.objects.filter(id=bookid)
    if len(books) > 0:
        return books[0]
    else:
        return None


def getallbooks():
    books = Book.objects.all()
    return books


def deletebook(bookid):
    try:
        book = Book.objects.get(id=bookid)
    except Exception as e:
        print("couldnt get book", e)
        return None
    book.delete()


def updatebook(bookid, title, desc):
    try:
        book = Book.objects.get(id=bookid)
    except Exception as e:
        print("couldn't get book", e)
        return None
    book.title = title
    book.desc = desc
    book.save()
