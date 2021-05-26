from django.contrib import messages
from django.shortcuts import redirect, render

from . import models
from .models import Show


def index(request):
    return redirect('/shows')


def newshow(request):
    return render(request, "index.html")


def addnewshow(request):
    if request.method == 'POST':

        errors = Show.objects.basic_validator(request.POST)
        if len(errors) > 0:
            # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
            for key, value in errors.items():
                messages.error(request, value)
            # redirect the user back to the form to fix the errors
            return redirect('/show/new')
        else:
            title = request.POST['title']
            network = request.POST['network']
            releasedate = request.POST['releasedate']
            description = request.POST['description']
            models.create_show(title, releasedate, network, description)

    return redirect('/show/new')


def allshows(request):
    context = {
        'shows': models.get_all_show()
    }

    return render(request, "shows.html", context)


def info(request, id):
    context = {
        'show_info': models.getshowbyid(int(id))
    }
    print(context['show_info'])
    return render(request, "info.html", context)


def viewedit(request, id):
    context = {
        'id': id
    }
    return render(request, "edit.html", context)


def editshow(request, id):
    if request.method == 'POST':
        errors = Show.objects.basic_validator(request.POST)
        if len(errors) > 0:
            # if the errors dictionary contains anything, loop through each key-value pair and make a flash message
            for key, value in errors.items():
                messages.error(request, value)
            # redirect the user back to the form to fix the errors
            return redirect('/shows/'+str(id)+'/edit')
        else:
            title = request.POST['title']
            network = request.POST['network']
            releasedate = request.POST['releasedate']
            description = request.POST['description']
            models.updatebyid(id, title, releasedate, network, description)

    return redirect('/shows')


def delete(request, id):
    models.deleteshowbyid(int(id))
    return redirect('/')
