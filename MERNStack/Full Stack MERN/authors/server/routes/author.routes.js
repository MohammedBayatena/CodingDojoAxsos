const AuthorController = require('../controllers/author.controller')

module.exports = function (app) {
    app.post('/api/addAuthor', AuthorController.createAuthor);
    app.get('/api/authors', AuthorController.getAllAuthors);
    app.get('/api/author/:id', AuthorController.findAuthor);
    app.put('/api/author/:id/edit', AuthorController.updateAuthor)
    app.delete('/api/author/:id/delete', AuthorController.deleteAuthor)
}