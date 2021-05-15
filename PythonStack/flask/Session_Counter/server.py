from flask import Flask, render_template, session, redirect, request

app = Flask(__name__)
app.secret_key = "156465sd4#$%GSD@#Gsdf64"


@app.route('/')
def index():
    if 'counter' not in session:
        session['visitcounter'] = 1

    if 'counter' not in session:
        session['counter'] = 1
    else:
        session['counter'] += 1
        session['visitcounter'] += 1

    return render_template("index.html")


@app.route("/destroy_session")
def destroy():
    session.pop('counter')  # clears a specific key
    return redirect('/')


@app.route("/incrementby2")
def incr2():
    if 'counter' not in session:
        session['counter'] = 2
    else:
        session['counter'] += 1
        session['visitcounter'] -= 1
    return redirect('/')


@app.route('/count', methods=['POST'])
def incrementbynum():
    if 'counter' not in session:
        session['counter'] = 1
    else:
        session['counter'] += int(request.form['counterval']) - 1
        session['visitcounter'] -= 1
    return redirect('/')


if __name__ == '__main__':
    app.run(debug=True)
