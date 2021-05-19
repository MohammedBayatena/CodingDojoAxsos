from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.

def users(request):
    return HttpResponse("placeholder to later display all the list of users")

def userregister(request):
    return HttpResponse("placeholder for users to create a new user record")

def userlogin(request):
    return HttpResponse("placeholder for users to log in")

