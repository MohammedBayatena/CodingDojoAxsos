from . import views
from django.urls import path

urlpatterns = [

    path('',views.root),
    path('add', views.add)

]