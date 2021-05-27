from django.urls import path

from . import views

urlpatterns = [
    path('', views.root),
    path('login', views.login),
    path('register', views.register),
    path('welcome', views.welcome),
    path('logout', views.logout),
    path('wall',views.renderwall),
    path('message/<int:id>/new', views.addmessage),
    path('comment/<int:id>/new',views.addcomment)
]
