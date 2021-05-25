from django.shortcuts import redirect, render

from . import models


def index(request):
    return redirect('/shows')


def newshow(request):
    return render(request, "index.html")


def addnewshow(request):
    if request.method == 'POST':
        title = request.POST['title']
        network = request.POST['network']
        releasedate = request.POST['releasedate']
        description = request.POST['description']
        models.create_show(title, releasedate, network,description)

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
        title = request.POST['title']
        network = request.POST['network']
        releasedate = request.POST['releasedate']
        description = request.POST['description']
        models.updatebyid(id, title, releasedate, network ,description)
    return redirect('/shows')


def delete(request, id):
    models.deleteshowbyid(int(id))
    return redirect('/')
