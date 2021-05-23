from django.urls import path

from . import views

urlpatterns = [
    path('', views.root),
    path('authors', views.handleAuthors),
    path('books/<int:id>', views.bookinfo),
    path('books/newbook', views.newbook),
    path('books/addauthor', views.addauthor),
    path('authors/<int:id>', views.authorinfo),
    path('authors/newauthor', views.newauthor),
    path('authors/addbook', views.addbook)
]
