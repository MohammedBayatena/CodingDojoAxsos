from django.urls import path

from . import views

urlpatterns = [

    path('', views.root),
    path('counter', views.count),
    path('destroy_session', views.destroy),
    path('incrementby2',views.incby2),
    path('counterval',views.incbyval)

]
