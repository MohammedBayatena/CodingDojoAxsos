from django.urls import path

from . import views

urlpatterns = [
    path('', views.root),
    path('logout', views.logout),
    path('addcourse',views.addcourse),
    path('remove/<int:courseid>',views.removecourse),
    path('destroy/<int:courseid>',views.viewremove)
]
