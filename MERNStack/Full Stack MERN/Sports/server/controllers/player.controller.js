const { Player } = require("../models/player.model");
// The method below is new

module.exports.createPlayer = (request, response) => {
	const { playerName, prefferedPosition } = request.body;
	Player.create({
		playerName,
		prefferedPosition,
		Game1: "Undecided",
		Game2: "Undecided",
		Game3: "Undecided",
	})
		.then((player) => response.json(player))
		.catch((err) => response.status(400).json(err));
};

module.exports.getAllPlayers = (request, response) => {
	Player.find({})
		.then((players) => response.json(players))
		.catch((err) => console.log(response.json(err)));
};

module.exports.deletePlayer = (request, response) => {
	Player.deleteOne({ _id: request.params.id })
		.then((deletedPlayer) => response.json(deletedPlayer))
		.catch((err) => response.json(err));
};

module.exports.updatePlayer = (request, response) => {
	Player.findOneAndUpdate({ _id: request.params.id }, request.body, {
		upsert: true,
	})
		.then((updatedPlayer) => response.json(updatedPlayer))
		.catch((err) => response.json(err));
};
