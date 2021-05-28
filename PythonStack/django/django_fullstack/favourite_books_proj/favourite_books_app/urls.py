from django.urls import path

from . import views

urlpatterns = [
    path('', views.root),
    path('login', views.login),
    path('register', views.register),
    path('welcome', views.welcome),
    path('logout', views.logout),
    path('addbook', views.addbook),
    path('addfav/<int:bookid>', views.addfav),
    path('removefav/<int:bookid>', views.removefav),
    path('books/<int:bookid>', views.viewbook),
    path('deletebook/<int:bookid>', views.deletebook),
    path('updatebook/<int:bookid>', views.updatebook),
]
