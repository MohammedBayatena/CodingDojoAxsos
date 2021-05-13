from flask import Flask, render_template , request ,redirect

app = Flask(__name__)

@app.route("/" , methods=["GET", "post" ])
def drawindex():
    return render_template("index.html")


@app.route("/result" , methods=["POST"])
def info():
    name = request.form["name"]
    location = request.form["location"]
    favlang = request.form["favlang"]
    comment = request.form["comment"]
    return render_template("info.html",
                           name=name,
                           location=location,
                           favlang=favlang,
                           comment=comment)

if __name__ == "__main__":
    app.run(debug=True)
