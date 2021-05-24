from django.shortcuts import render, redirect

from . import models


# Create your views here.

def root(request):
    if 'id' in request.session:
        return render(request, 'welcome.html')
    return render(request, "login.html")


def login(request):
    if request.method == 'POST':
        email = request.POST['emaillogin']
        password = request.POST['passwordlogin']
        user = models.usercheckexist(email, password)
        if user is not None:
            request.session['id'] = user.id
            request.session['first_name'] = user.first_name
            request.session['last_name'] = user.last_name
        return redirect('/welcome')
    return redirect('/')


def register(request):
    if request.method == "POST":
        firstname = request.POST['firstname']
        lastanme = request.POST['lastname']
        email = request.POST['email']
        password = request.POST['password']
        passwordc = request.POST['confirmpassword']

        if password == passwordc:
            user = models.create_user(firstname, lastanme, email, password)
            request.session['id'] = user.id
            request.session['first_name'] = user.first_name
            request.session['last_name'] = user.last_name

        return redirect('/welcome')
    return redirect('/')


def welcome(request):
    if 'id' not in request.session:
        return redirect('/')
    return render(request, 'welcome.html')


def logout(request):
    request.session.clear()
    return redirect('/')
