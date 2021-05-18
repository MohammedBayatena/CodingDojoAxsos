from django.shortcuts import render, redirect


# python manage.py migrate Run Before we are beind apple to use Sessions

# Note: If you are storing a list in session that is being modified (such as an append), you will need to save the session after the append, like so:
# request.session['my_list'] = []
# request.session['my_list'].append("new item")
# request.session.save()

# Usage <p>Name in session is: {{request.session.name}}</p>

# Create your views here.

def root(request):
    if 'counter' not in request.session:
        request.session['counter'] = 1
    else:
        request.session['counter'] += 1

    if 'visitcounter' not in request.session:
        request.session['visitcounter'] = 1
    else:
        request.session['visitcounter'] += 1

    return render(request, "index.html")


def count(request):
    if 'counter' not in request.session:
        request.session['counter'] = 1
    else:
        request.session['counter'] += 1

    return redirect('/')


def destroy(request):
    try:
        del request.session['counter']
        del request.session['visitcounter']
        return redirect('/')
    except:
        print("Counter Not Found Ignoring for now")
        return redirect('/')


def incby2(request):
    if 'counter' not in request.session:
        request.session['counter'] = 1
    else:
        request.session['counter'] += 1
        request.session['visitcounter'] -= 1
    return redirect('/')


def incbyval(request):
    if 'counterval' in request.POST:
        value = int(request.POST['counterval']) - 1
    else:
        value = 0
        print("Dictionary Error in reading from Form")

    if 'counter' not in request.session:
        request.session['counter'] = 1
    else:
        request.session['counter'] += value
        request.session['visitcounter'] -= 1

    return redirect('/')
