from django.http import JsonResponse
from django.shortcuts import HttpResponse , redirect


# Create your views here.

def root(request):
    return redirect("/blogs")

def index(request):
    return HttpResponse("placeholder to later display a list of all blogs")

def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")

def create(request):
    return redirect("/")

def show(request,number):
    return HttpResponse("placeholder to display blog number: "+str(number))

def edit(request,number):
    return HttpResponse("placeholder to edit blog "+str(number))

def destroy(request,number):
    return redirect("/")

def json(request):
    return JsonResponse({"title": "My first blog", "content": "Lorem, ipsum dolor sit amet consectetur adipsicing elit." })


# def one_more(request, id, color):  # id would be a number, and color a string from the URL
#     pass  # given the example above, id would be 17 and color would be 'brown'

