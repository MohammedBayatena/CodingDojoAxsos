from django.db import models


# Create your models here.

class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    # authors =  This Field Contains info about authors

    def get_all_books(self):
        return self.objects.all()

    def newbook(self, title, desc):
        self.objects.create(title=title, desc=desc)

    def getbyid(self, id):
        return self.objects.get(id=id)

    def __str__(self):
        string = "\n{ Title: " + self.title + "\n" "Description: " + self.desc + " }\n"
        return string

    def get_allauthors(book):
        return book.authors.all()

    def linkauthor(self,bookid,authorid):
        author = Authors.objects.get(id=authorid)
        self.objects.get(id=bookid).authors.add(author)


class Authors(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    notes = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    books = models.ManyToManyField(Book, related_name="authors")

    def get_all_authors(self):
        return self.objects.all()

    def newauthor(self, first_name, last_name, notes):
        self.objects.create(first_name=first_name, last_name=last_name, notes=notes)

    def getbyid(self, id):
        return self.objects.get(id=id)

    def get_allauthors(author):
        return author.books.all()

    def linkbook(self,bookid,authorid):
        book = Book.objects.get(id=bookid)
        self.objects.get(id=authorid).books.add(book)

    def __str__(self):
        string = "{ \nFirst Name: " + self.first_name + "\nLast Name: " + self.last_name + "\nNotes: " + self.notes + " }\n"
        return string
