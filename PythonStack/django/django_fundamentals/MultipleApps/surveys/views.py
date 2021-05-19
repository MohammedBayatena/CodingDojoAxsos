from django.http import JsonResponse
from django.shortcuts import HttpResponse , redirect

# Create your views here.

def survey(request):
    return HttpResponse("placeholder to display all the surveys created")

def surveynew(request):
    return HttpResponse("placeholder for users to add a new survey")

