import random
from datetime import datetime

from django.shortcuts import render, redirect


# Create your views here.

def root(request):
    if "goldamount" not in request.session:
        request.session['goldamount'] = 0
    else:
        pass

    if "activities" not in request.session:
        request.session['activities'] = []
    else:
        pass
    return render(request, "index.html")

def process(request):
    print(request.POST)
    if request.method == "POST":
        if request.POST['formtype'] == "farm":

            activity = {
                'type': "farm",
                'rand': random.randint(10, 20),
                'date': datetime.now().strftime("%Y/%m/%d %I:%M %p"),
                'win': 1
            }
            request.session['goldamount'] += int(activity['rand'])
            request.session['activities'].append(activity)
            request.session.save()

        elif request.POST['formtype'] == "cave":
            activity = {
                'type': "cave",
                'rand': random.randint(5, 10),
                'date': datetime.now().strftime("%Y/%m/%d %I:%M %p"),
                'win': 1
            }
            request.session['goldamount'] += int(activity['rand'])
            request.session['activities'].append(activity)
            request.session.save()

        elif request.POST['formtype'] == "house":
            activity = {
                'type': "house",
                'rand': random.randint(2, 5),
                'date': datetime.now().strftime("%Y/%m/%d %I:%M %p"),
                'win': 1
            }
            request.session['goldamount'] += int(activity['rand'])
            request.session['activities'].append(activity)
            request.session.save()
        elif request.POST['formtype'] == "casino":
            activity = {
                'type': "casino",
                'rand': random.randint(0, 50),
                'date': datetime.now().strftime("%Y/%m/%d %I:%M %p"),
                'win': random.randint(0, 1)
            }

            if activity['win'] == 1:
                request.session['goldamount'] += int(activity['rand'])
            elif activity['win'] == 0:
                request.session['goldamount'] -= int(activity['rand'])

            request.session['activities'].append(activity)
            request.session.save()
    return redirect('/')
