# Generated by Django 3.2.3 on 2021-05-25 12:29

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('semirestful_app', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='show',
            name='Network',
            field=models.CharField(default='', max_length=255),
            preserve_default=False,
        ),
    ]
