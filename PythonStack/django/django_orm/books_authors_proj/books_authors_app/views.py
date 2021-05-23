from django.http import HttpResponse
from django.shortcuts import render, redirect

from . import models


# Create your views here.

def root(request):
    book = models.Book
    print(book.get_all_books(book))
    context = {
        'books': book.get_all_books(book)
    }

    return render(request, "books.html", context)


def handleAuthors(request):
    author = models.Authors
    print(author.get_all_authors(author))
    context = {
        'authors': author.get_all_authors(author)
    }

    return render(request, "authors.html", context)


def newbook(request):
    print(request.POST)
    newbook = {
        'title': request.POST['title'],
        'desc': request.POST['desc']
    }
    book = models.Book
    book.newbook(book, newbook['title'], newbook['desc'])
    return redirect('/')


def newauthor(request):
    print(request.POST)
    newauthor = {
        'first_name': request.POST['first_name'],
        'last_name': request.POST['last_name'],
        'notes': request.POST['notes']
    }
    author = models.Authors
    author.newauthor(author, newauthor['first_name'], newauthor['last_name'], newauthor['notes'])
    return redirect('/authors')


def authorinfo(request, id):
    try:
        author = models.Authors.getbyid(models.Authors, int(id))
        books = models.Authors.get_allauthors(author)
        allbooks = models.Book.get_all_books(models.Book)
    except:
        print("Error Reading from database")
    context = {
        'id': author.id,
        'first_name': author.first_name,
        'last_name': author.last_name,
        'notes': author.notes,
        'books': books,
        'allbooks': allbooks
    }
    return render(request, "authorinfo.html", context)


def bookinfo(request, id):
    try:
        # print(models.Book.getbyid(models.Book, int(id)))
        book = models.Book.getbyid(models.Book, int(id))
        authors = models.Book.get_allauthors(book)
        allauthors = models.Authors.get_all_authors(models.Authors)
    except:
        print("Error Reading from database")
        return HttpResponse("Internal Error")
    context = {
        'id': book.id,
        'title': book.title,
        'desc': book.desc,
        'authors': authors,
        'allauthors': allauthors
    }
    return render(request, "bookinfo.html", context)


def addauthor(request):
    bookid = request.POST['bookid']
    authorid = request.POST['select']
    models.Book.linkauthor(models.Book, bookid, authorid)
    return redirect("/")


def addbook(request):
    authorid = request.POST['authorid']
    bookid = request.POST['select']
    models.Authors.linkbook(models.Authors, bookid, authorid)
    return redirect("/authors")
