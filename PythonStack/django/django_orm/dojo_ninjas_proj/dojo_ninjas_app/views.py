from django.shortcuts import render, redirect
from . import models

# Create your views here.

def root(request):
    # dojo= models.Dojo.objects.all()[1]
    # print(models.Dojo.get_ninjas_in_dojo(dojo))
    # print(models.Dojo.get_ninjas_in_dojo_by_id(dojo,1))

    dojo = models.Dojo
    context = {
        'dojos': dojo.getalldojos(dojo)
    }
    return render(request, "books.html", context)

def newdojo(request):
    dojodict = {
        'dojoname': request.POST['name'],
        'dojocity': request.POST['city'],
        'dojostate': request.POST['state']
    }
    # print(dojodict)
    dojo = models.Dojo
    dojo.add_dojo(dojo, dojodict['dojoname'], dojodict['dojocity'], dojodict['dojostate'])

    return redirect('/')

def newninja(request):
    ninjadict = {
        'first_name': request.POST['first_name'],
        'last_name': request.POST['last_name'],
        'dojoid': request.POST['dojoselect']
    }
    # print(ninjadict)
    ninjas = models.Ninja
    ninjas.add_ninja(ninjas, ninjadict['first_name'], ninjadict['last_name'], ninjadict['dojoid'])

    return redirect('/')
