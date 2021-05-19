from django.urls import path

from . import views

urlpatterns = [

    path('' , views.survey , name="surveys"),
    path('new', views.surveynew, name="surveysnew")

]
