from time import strftime, localtime

from django.shortcuts import render

def index(request):
    context = {
        "name": "Noelle",
        "favorite_color": "turquoise",
        "pets": ["Bruce", "Fitz", "Georgie"]
    }
    return render(request, "index.html", context)


def displayTime(request):
    context = {
        "date": strftime("%b %d, %Y", localtime()),
        "time": strftime("%I:%M %p", localtime())
    }
    return render(request, "clock.html", context)
