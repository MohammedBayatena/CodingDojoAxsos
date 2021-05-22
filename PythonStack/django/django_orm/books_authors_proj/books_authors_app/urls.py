from django.urls import path

from . import views

urlpatterns = [
    path('', views.root),
    path('authors', views.handleAuthors),
    path('books/<int:id>', views.bookinfo),
    path('authors/<int:id>', views.authorinfo),
]
