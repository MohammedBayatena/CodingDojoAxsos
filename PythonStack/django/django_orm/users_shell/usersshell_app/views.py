from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.


def root(request):
    return HttpResponse("This is a place holder for an HTML page")