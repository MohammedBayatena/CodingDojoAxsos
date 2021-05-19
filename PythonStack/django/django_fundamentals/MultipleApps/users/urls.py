from django.http import JsonResponse
from django.shortcuts import HttpResponse , redirect
from django.urls import path

from . import views

urlpatterns = [

    path('register', views.userregister ,  name = "userregister"),
    path('login' , views.userlogin , name="userlogin"),
    path('new', views.userregister, name="usernew"),
    path('',views.users, name="user")
]
