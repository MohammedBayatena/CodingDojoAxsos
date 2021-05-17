from django.shortcuts import render  # don't forget to import redirect!


def index(request):
    # this is the route that shows the form
    return render(request, "index.html")


def result(request):
    hearaboutus = ""

    for key in request.POST.keys():
        if key.startswith("gridCheck"):
            hearaboutus += request.POST[key] + ' , '

    context = {
        'name': request.POST['name'],
        'location': request.POST['dojolocation'],
        'favlang': request.POST['favlang'],
        'gender': request.POST['gridRadios'],
        'comments': request.POST['comments'],
        'hearaboutus': hearaboutus
    }

    print(request.POST)

    return render(request, "info.html", context)
