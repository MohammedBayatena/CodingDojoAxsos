# Generated by Django 3.2.3 on 2021-05-25 13:56

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('semirestful_app', '0002_show_network'),
    ]

    operations = [
        migrations.AddField(
            model_name='show',
            name='description',
            field=models.TextField(default=''),
            preserve_default=False,
        ),
    ]