const {Author} = require("../models/author.model")
const {request, response} = require("express");

module.exports.createAuthor = (req, res) => {
    Author.create(req.body)
        .then(res => console.log(res))
        .catch(err => res.json(err))
}

module.exports.findAuthor = (req, res) => {
    Author.findOne({_id: req.params.id})
        .then(author => res.json(author))
        .catch(err => res.json(err))
}

module.exports.getAllAuthors = (request, response) => {
    Author.find({})
        .then(authors => response.json(authors))
        .catch(err => console.log(response.json(err)))
}

module.exports.updateAuthor = (request, response) => {
    Author.updateOne({_id: request.params.id}, request.body, {new: true})
        .then(updatedAuthor => response.json(updatedAuthor))
        .catch(err => response.json(err))
}

module.exports.deleteAuthor = (request, response) => {
    Author.deleteOne({_id: request.params.id})
        .then(deletedAuthor => response.json(deletedAuthor))
        .catch(err => response.json(err))
}
