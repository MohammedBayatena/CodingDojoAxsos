from django.db import models

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid fieldcopy
        if len(postData['title']) < 2:
            errors["title"] = "Show title should be at least 2 characters"
        if len(postData['network']) < 3:
            errors["network"] = "Show network should be at least 3 characters"
        if len(postData['releasedate']) < 10:
            errors["releasedate"] = "Show release date should be at least 10 characters"
        if len(postData['description']) < 10:
            errors["description"] = "Blog description should be at least 10 characters"

        return errors


class Show(models.Model):
    title = models.CharField(max_length=255)
    Release_date = models.DateTimeField()
    Network = models.CharField(max_length=255)
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()  # add this line!


def get_all_show():
    all_shows = Show.objects.all()
    return all_shows


def create_show(title, Release_date, Network, description):
    show = Show.objects.update_or_create(title=title, Release_date=Release_date, Network=Network,
                                         description=description)


def getshowbyid(id):
    show = Show.objects.get(id=id)
    return show


def deleteshowbyid(id):
    show = Show.objects.get(id=id)
    show.delete()


def updatebyid(id, title, Release_date, Network, description):
    tobeupdated = Show.objects.get(id=id)
    tobeupdated.title = title
    tobeupdated.Network = Network
    tobeupdated.Release_date = Release_date
    tobeupdated.description = description
    tobeupdated.save()
