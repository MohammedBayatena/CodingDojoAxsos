from flask import Flask, render_template
from jinja2 import Template

app = Flask(__name__)


@app.route("/")
def root():
    return "You are in Root! please go to /lists"

@app.route('/lists')
def render_lists():
    users = [
        {'first_name': 'Michael', 'last_name': 'Choi'},
        {'first_name': 'John', 'last_name': 'Supsupin'},
        {'first_name': 'Mark', 'last_name': 'Guillen'},
        {'first_name': 'KB', 'last_name': 'Tonel'}
    ]
    return render_template("index.html", users = users)

if __name__ == "__main__":
    app.run(debug=True)
