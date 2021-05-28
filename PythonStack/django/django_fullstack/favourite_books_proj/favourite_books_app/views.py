import bcrypt
from django.contrib import messages
from django.shortcuts import render, redirect

from . import models
from .models import User, Book


# Create your views here.

def root(request):
    if 'id' in request.session:
        return redirect('/welcome')
    return render(request, "login.html")


def login(request):
    if request.method == 'POST':
        email = request.POST['emaillogin']
        user = models.usercheckexist(email)
        errors = {}
        if user is None:
            errors['login'] = "User with similar email does not exist!"
        if len(errors) > 0:
            # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
            for key, value in errors.items():
                messages.error(request, value)
            # redirect the user back to the form to fix the errors
            return redirect('/')
        else:
            password = request.POST['passwordlogin']
        if user is not None and bcrypt.checkpw(password.encode(), user.password.encode()):
            request.session['id'] = user.id
            request.session['first_name'] = user.first_name
            request.session['last_name'] = user.last_name
            messages.success(request, 'Successfully Logged In!')
            return redirect('/welcome')
        else:
            messages.error(request, "Invalid password or email!")
    return redirect('/')


def register(request):
    if request.method == "POST":
        errors = User.objects.basic_validator(request.POST)
        if len(errors) > 0:
            # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
            for key, value in errors.items():
                messages.error(request, value)
            # redirect the user back to the form to fix the errors
            return redirect('/')
        else:
            firstname = request.POST['firstname']
            lastanme = request.POST['lastname']
            email = request.POST['email']
            password = request.POST['password']
            passwordc = request.POST['confirmpassword']
            if password == passwordc:
                hashed_password = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
                user = models.create_user(firstname, lastanme, email, hashed_password)
                request.session['id'] = user.id
                request.session['first_name'] = user.first_name
                request.session['last_name'] = user.last_name
                messages.success(request, 'Successfully Registered!')
                return redirect('/welcome')
    return redirect('/')


def welcome(request):
    if 'id' not in request.session:
        return redirect('/')
    context = {
        'books': models.getallbooks(),
        'user': models.getuserby_id(request.session['id'])
    }
    return render(request, 'welcome.html', context)


def logout(request):
    request.session.clear()
    return redirect('/')


def addbook(request):
    if request.method == "POST":
        errors = Book.objects.basic_validator(request.POST)
        if len(errors) > 0:
            # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
            for key, value in errors.items():
                messages.error(request, value)
            # redirect the user back to the form to fix the errors
            return redirect('/welcome')
        else:
            title = request.POST['title']
            description = request.POST['desc']
            userid = int(request.session['id'])
            try:
                user = models.User.objects.get(id=userid)
            except Exception as e:
                print("error adding box , user not found", e)
                redirect('/welcome')
            book = models.create_book(title, description, user)
            return redirect('/welcome')
    return redirect('/welcome')


def addfav(request, bookid):
    if models.bookcheckexist(int(bookid)) is None:
        return redirect('/welcome')
    else:
        book = models.getbookby_id(bookid)
        if book is not None:
            userid = request.session['id']
            user = models.getuserby_id(userid)
            book.users_who_like.add(user)
        else:
            return redirect('/welcome')
    return redirect('/welcome')


def viewbook(request, bookid):
    book = models.getbookby_id(bookid)
    userid = request.session['id']
    user = models.getuserby_id(userid)
    fav = False
    if book in user.books_liked.all():
        fav = True
    context = {
        'book': book,
        'fav': fav
    }
    if book.uploaded_by_id.id == userid:
        return render(request, "bookinfoedit.html", context)
    else:
        return render(request, "bookinfo.html", context)


def removefav(request, bookid):
    if models.bookcheckexist(int(bookid)) is None:
        return redirect('/books/' + str(bookid))
    else:
        book = models.getbookby_id(bookid)
        if book is not None:
            userid = request.session['id']
            user = models.getuserby_id(userid)
            book.users_who_like.remove(user)
        else:
            return redirect('/books/' + str(bookid))
    return redirect('/books/' + str(bookid))


def deletebook(request, bookid):
    models.deletebook(bookid)
    return redirect('/welcome')


def updatebook(request, bookid):

    #TODO Add Validation before upating title and description

    title = request.POST['title']
    desc = request.POST['desc']
    models.updatebook(bookid, title, desc)
    return redirect('/welcome')
