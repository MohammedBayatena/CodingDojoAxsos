import random

from django.shortcuts import render, redirect


# Create your views here.

def root(request):
    if 'generatednum' not in request.session:
        request.session['generatednum'] = random.randint(1, 100)  # random number between 1-100
    else:
        if 'reset' in request.session:
            request.session['generatednum'] = random.randint(1, 100)  # random number between 1-100
            del request.session['reset']

    numfromuser = -1
    generatednum = int(request.session['generatednum'])

    try:
        numfromuser = int(request.POST['value'])
    except KeyError:
        print("error reading num from user ignoring for now")

    print("---" + str(numfromuser))
    print("----" + str(generatednum))

    insidebox = "start!"
    if numfromuser == generatednum:
        insidebox = "Yes"
        print(insidebox)
        return redirect('/correct')
    else:
        if numfromuser > generatednum:
            insidebox = "too high"
            print(insidebox)
        if numfromuser < generatednum and numfromuser != -1:
            insidebox = "too low"
            print(insidebox)

    context = {
        'insidebox': insidebox
    }

    return render(request, "index.html", context)


def correct(request):
    context = {
        'insidebox': str(request.session['generatednum']) + " was the number!"
    }

    request.session['reset'] = 1
    return render(request, "correct.html", context)
