from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('show/new', views.newshow),
    path('new',views.addnewshow),
    path('shows', views.allshows),
    path('shows/<int:id>',views.info),
    path('shows/<int:id>/edit',views.viewedit),
    path('edit/<int:id>' , views.editshow),
    path('shows/<int:id>/delete',views.delete)
    
]