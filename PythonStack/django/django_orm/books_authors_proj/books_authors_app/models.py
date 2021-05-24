from django.db import models


# Create your models here.

class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    # authors =  This Field Contains info about authors

    def __str__(self):
        string = "\n{ Title: " + self.title + "\n" "Description: " + self.desc + " }\n"
        return string


class Authors(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    notes = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    books = models.ManyToManyField(Book, related_name="authors")

    def __str__(self):
        string = "{ \nFirst Name: " + self.first_name + "\nLast Name: " + self.last_name + "\nNotes: " + self.notes + " }\n"
        return string


def get_all_books():
    return Book.objects.all()


def newbook(title, desc):
    Book.objects.create(title=title, desc=desc)


def getbyid_book(id):
    return Book.objects.get(id=id)


def get_allauthors(book):
    return book.authors.all()


def linkauthor(bookid, authorid):
    author = Authors.objects.get(id=authorid)
    Book.objects.get(id=bookid).authors.add(author)


def getauthors_not_associated(id):

    book = Book.objects.get(id=id)
    return Authors.objects.exclude(id__in=book.authors.all())

def getbooks_not_associated(id):

    author = Authors.objects.get(id=id)
    return Book.objects.exclude(id__in=author.books.all())



def get_all_authors():
    return Authors.objects.all()


def newauthor(first_name, last_name, notes):
    Authors.objects.create(first_name=first_name, last_name=last_name, notes=notes)


def getbyid_author(id):
    return Authors.objects.get(id=id)


def get_allbooks(author):
    return author.books.all()


def linkbook(bookid, authorid):
    book = Book.objects.get(id=bookid)
    Authors.objects.get(id=authorid).books.add(book)
