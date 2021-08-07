const PlayerController = require("../controllers/player.controller");
module.exports = function (app) {
	app.get("/players", PlayerController.getAllPlayers);
	app.post("/players/new", PlayerController.createPlayer);
	app.delete("/players/delete/:id", PlayerController.deletePlayer);
	app.put("/players/edit/:id", PlayerController.updatePlayer);
};
