from django.urls import path
from . import views


urlpatterns = [
    path('', views.root),
    path('newninja',views.newninja),
    path('newdojo', views.newdojo)
]