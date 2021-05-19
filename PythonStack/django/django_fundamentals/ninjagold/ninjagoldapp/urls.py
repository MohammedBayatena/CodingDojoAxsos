from . import views
from django.urls import path

urlpatterns = [

    path('' , views.root),
    path('process_money', views.process)


]