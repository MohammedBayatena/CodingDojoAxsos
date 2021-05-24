from django.http import HttpResponse
from django.shortcuts import render, redirect

from . import models


# Create your views here.

def root(request):
    #print(models.get_all_books())
    context = {
        'books': models.get_all_books()
    }

    return render(request, "books.html", context)


def handleAuthors(request):
    #print(models.get_all_authors())
    context = {
        'authors': models.get_all_authors()
    }

    return render(request, "authors.html", context)


def newbook(request):
    #print(request.POST)
    newbook = {
        'title': request.POST['title'],
        'desc': request.POST['desc']
    }
    models.newbook(newbook['title'], newbook['desc'])
    return redirect('/')


def newauthor(request):
    #print(request.POST)
    newauthor = {
        'first_name': request.POST['first_name'],
        'last_name': request.POST['last_name'],
        'notes': request.POST['notes']
    }
    models.newauthor(newauthor['first_name'], newauthor['last_name'], newauthor['notes'])
    return redirect('/authors')


def authorinfo(request, id):
    try:
        author = models.getbyid_author(int(id))
        books = models.get_allbooks(author)
        allbooks = models.getbooks_not_associated(int(id)) #---------->
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
        book = models.getbyid_book(int(id))
        authors = models.get_allauthors(book)
        allauthors = models.getauthors_not_associated(int(id))
    except Exception as e:
        print("Error Reading from database",e)
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
    models.linkauthor(bookid, authorid)
    return redirect("/")


def addbook(request):
    authorid = request.POST['authorid']
    bookid = request.POST['select']
    models.linkbook(bookid, authorid)
    return redirect("/authors")
