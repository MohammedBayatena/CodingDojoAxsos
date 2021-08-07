const mongoose = require("mongoose");

const PlayerSchema = new mongoose.Schema(
	{
		playerName: {
			type: String,
			required: [true, "Name is required"],
			minlength: [2, "Name should be  at least 2 characters in length"],
		},
		prefferedPosition: {
			type: String,
			required: [true, "Position is required"],
		},
		Game1: { type: String },
		Game2: { type: String },
		Game3: { type: String },
	},
	{ timestamps: true }
);
module.exports.Player = mongoose.model("Player", PlayerSchema);
