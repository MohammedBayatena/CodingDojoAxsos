from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.

def root(request):
    return render(request,"books.html")

def  handleAuthors(request):
    return render(request, "authors.html")

def authorinfo(request,id):
    return render(request, "bookinfo.html")

def bookinfo(request,id):
    return render(request, "authorinfo.html")