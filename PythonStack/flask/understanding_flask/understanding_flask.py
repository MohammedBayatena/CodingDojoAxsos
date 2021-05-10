from flask import Flask  # Import Flask to allow us to create our app

app = Flask(__name__)  # Create a new instance of the Flask class called "app"


@app.route('/')  # The "@" decorator associates this route with the function immediately following
def hello_world():
    return 'Hello World!'  # Return the string 'Hello World!' as a response


@app.route('/dojo')  # The "@" decorator associates this route with the function immediately following
def hello_dojo():
    return 'Dojo!'  # Return the string 'Hello World!' as a response


@app.route('/say/<name>')
def say(name):
    return f"Hello {name}"


@app.route('/repeat/<int:num>/<word>')
def repeat_str(num, word):
    body = ""
    for i in range(int(num)):
        body += f"<p style='background-color: pink ; color:white; font-weight: bold; width: fit-content;'>{word}</p>"
    return body


@app.errorhandler(404)
def page_not_found(e):
    return "Sorry! No response. Try again."


if __name__ == "__main__":  # Ensure this file is being run directly and not from a different module
    app.run(debug=True)  # Run the app in debug mode.
