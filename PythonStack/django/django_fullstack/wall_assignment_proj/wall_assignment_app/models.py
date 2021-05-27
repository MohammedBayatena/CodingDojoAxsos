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
    # messages =
    objects = UserManager()  # add this line!


def create_user(firstname, lastname, email, password):
    return User.objects.create(first_name=firstname, last_name=lastname, email=email, password=password)

def getallusers():
    users = User.objects.all()
    return users


def get_userbyid(id):
    try:
        return User.objects.get(id=id)
    except Exception as e:
        print("error couldnt find user", e)


def usercheckexist(email):
    users = User.objects.filter(email=email)
    if len(users) > 0:
        return users[0]
    else:
        return None


class Message(models.Model):
    user_id = models.ForeignKey(User, related_name="messages", on_delete=models.CASCADE)
    message = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def create_message(id, textareapost):
    try:
        user = User.objects.get(id=id)
    except Exception as e:
        print("error adding message , finding user failed", e)
    return Message.objects.create(user_id=user, message=textareapost)


def getallmesages():
    messages = Message.objects.all()
    return messages

def get_messagebyid(id):
    try:
        return Message.objects.get(id=id)
    except Exception as e:
        print("error couldnt find message", e)


class Comments(models.Model):
    message = models.ForeignKey(Message, related_name="comments", on_delete=models.CASCADE)
    user = models.ForeignKey(User, related_name="comments", on_delete=models.CASCADE)
    comment = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def create_comment(user_id , post_id,comment):
    try:
        message = get_messagebyid(post_id)
        user = get_userbyid(user_id)
        print(user.first_name , message.message)
        Comments.objects.create(user=user, message=message,comment=comment)
    except Exception as e:
        print("error adding comment , finding user or message failed", e)
    return None

def getall_commentsbyPost(id):
    message = get_messagebyid(id)
    allcomments = Comments.objects.filter(message=message)
    return allcomments

def getall_comments():
    allcomments = Comments.objects.all()
    return allcomments



