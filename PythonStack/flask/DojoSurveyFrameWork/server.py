from flask import Flask, render_template, request

app = Flask(__name__)


@app.route("/", methods=["GET", "post"])
def drawindex():
    return render_template("index.html")


@app.route("/result", methods=["POST"])
def info():
    name = request.form["name"]
    location = request.form["dojolocation"]
    favlang = request.form["favlang"]
    comments = request.form["comments"]
    checkedboxes = []
    hearaboutus = ""
    for item in request.form:
        if item.startswith("gridCheck"):
            checkedboxes.append(item)
            hearaboutus = hearaboutus + request.form[str(item)] + ","
    gender = request.form["gridRadios"]
    print(request.form)
    return render_template("info.html",
                           name=name,
                           location=location,
                           favlang=favlang,
                           gender=gender,
                           hearaboutus=hearaboutus,
                           comments=comments
                           )


if __name__ == "__main__":
    app.run(debug=True)
