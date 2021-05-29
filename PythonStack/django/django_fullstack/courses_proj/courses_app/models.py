from django.db import models


# Create your models here.


class CoursesManger(models.Manager):

    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['name']) < 5:
            errors["name"] = "Course name should be at least 5 characters"
        if len(postData['desc']) < 15:
            errors["desc"] = "Description should be at least 15 characters"
        return errors


class Course(models.Model):
    name = models.CharField(max_length=45)
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = CoursesManger()


def getcourseby_id(id):
    try:
        course = Course.objects.get(id=id)
    except Exception as e:
        print("Error getting course by id", e)
        return None
    return course


def add_course(name, desc):
    course = Course.objects.create(name=name, description=desc)


def remove_course(id):
    course = getcourseby_id(id)
    if course is not None:
        course.delete()
    else:
        print("Error deleting course, course object not found")


def get_all_courses():
    courses = Course.objects.all()
    return courses

#TODO Description as a separate class as one to many
#TODO Add comments page for each course