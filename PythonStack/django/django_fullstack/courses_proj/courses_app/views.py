from django.contrib import messages
from django.shortcuts import render, redirect

from . import models
from .models import Course


# Create your views here.

def root(request):
    context = {
        'courses': models.get_all_courses()
    }
    return render(request, 'welcome.html', context)


def logout(request):
    request.session.clear()
    return redirect('/')


# this is how we do the logout


def addcourse(request):
    if request.method == "POST":
        errors = Course.objects.basic_validator(request.POST)
        if len(errors) > 0:
            # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
            for key, value in errors.items():
                messages.error(request, value)
            # redirect the user back to the form to fix the errors
            return redirect('/')
        else:
            try:
                name = request.POST['name']
                desc = request.POST['desc']
                models.add_course(name, desc)
            except Exception as e:
                print("error adding course to database", e)
            return redirect('/')
    return redirect('/')


def viewremove(request, courseid):
    context = {
        'courseid': courseid,
        'course' : models.getcourseby_id(courseid)
    }
    return render(request, 'deletenotice.html', context)


def removecourse(request, courseid):
    models.remove_course(courseid)
    return redirect("/")
