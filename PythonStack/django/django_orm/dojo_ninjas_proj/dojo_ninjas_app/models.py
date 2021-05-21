from django.db import models

# Create your models here.
class Dojo(models.Model):
    name = models.CharField(max_length=255)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=2)
    desc = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    # ninjas = This contains the ninjas i have in my dojo

    def getalldojos(self):
        return Dojo.objects.all()

    def get_ninjas_in_dojo(self):
        return self.ninjas.all()

    def get_ninjas_in_dojo_by_id(self, id):
        return Dojo.objects.all()[id].ninjas.all()

    def add_dojo(self, name, city, state, desc="This is a Dojo"):
        Dojo.objects.update_or_create(name=name, city=city, state=state, desc=desc)


class Ninja(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    dojo_id = models.ForeignKey(Dojo, related_name="ninjas", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def add_ninja(self, first_name, last_name, dojo_id):
        dojo = Dojo.objects.get(id=int(dojo_id))
        Ninja.objects.update_or_create(first_name=first_name, last_name=last_name, dojo_id=dojo)
