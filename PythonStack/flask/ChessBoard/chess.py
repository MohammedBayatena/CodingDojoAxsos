from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
def root():
    return render_template("index.html", rows=8, columns=8,color1="white",color2="black")


@app.route("/<int:rows>")
def draw1(rows):
    return render_template("index.html", rows=rows, columns=8,color1="white",color2="black")


@app.route("/<int:rows>/<int:columns>")
def draw2(rows, columns):
    return render_template("index.html", rows=rows, columns=columns,color1="white",color2="black")

@app.route("/<int:rows>/<int:columns>/<string:color1>/<string:color2>")
def draw3(rows, columns,color1,color2):
    return render_template("index.html", rows=rows, columns=columns,color1=color1,color2=color2)



if __name__ == "__main__":
    app.run(debug=True)
