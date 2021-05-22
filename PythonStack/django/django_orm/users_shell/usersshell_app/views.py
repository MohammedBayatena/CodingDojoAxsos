from django.contrib import messages
from django.shortcuts import render, redirect

from .models import User


# Create your views here.


def root(request):

    context = {
        'list': User.objects.all(),
        'success' : 0
    }

    return render(request, "books.html", context=context)


def add(request):
    try:
        User.objects.update_or_create(first_name=request.POST['first_name'], last_name=request.POST['last_name'],
                                      email_address=request.POST['email_address'], age=request.POST['age'])
        messages.success(request, 'Form submission successful')
    except Exception as e:
        print("Couldn't Add to Database cause of some error:" + str(e))
    return redirect("/")
