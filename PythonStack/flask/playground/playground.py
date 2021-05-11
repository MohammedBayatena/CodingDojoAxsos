from flask import Flask, render_template

app = Flask(__name__)


@app.route('/')
def root():
    return "Hello This is Root"


@app.route('/play')
def play():
    return render_template("index.html", numOfBoxes=3, color="blue")


@app.route('/play/<int:x>')
def playwithlen(x):
    return render_template("index.html", numOfBoxes=x, color="blue")


@app.route('/play/<int:x>/<string:color>')
def playwithlenncolor(x, color):
    return render_template("index.html", numOfBoxes=x, color=color)


if __name__ == "__main__":
    app.run(debug=True)
