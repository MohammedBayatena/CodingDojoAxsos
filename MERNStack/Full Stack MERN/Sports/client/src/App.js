import { Link, navigate, Router } from "@reach/router";
import { useState, useEffect } from "react";
import "./App.css";
import ManagePlayers from "./components/ManagePlayers";
import { confirmAlert } from "react-confirm-alert"; // Import
import "react-confirm-alert/src/react-confirm-alert.css"; // Import css
import ManageStatus from "./components/ManageStatus";
const axios = require("axios");

function App() {
	const [playersList, setPlayersList] = useState([]);
	const [loaded, setLoaded] = useState(false);
	const [errors, setErrors] = useState([]);

	const addplayer = (player) => {
		axios
			.post("http://localhost:8000/players/new", player)
			.then((res) => {
				setPlayersList([...playersList, res.data]);
				navigate("/ManagePlayers/list").catch((err) => console.log(err));
			})
			.catch((err) => {
				const errorResponse = err.response.data.errors; // Get the errors from err.response.data
				const errorArr = []; // Define a temp error array to push the messages in
				for (const key of Object.keys(errorResponse)) {
					// Loop through all errors and get the messages
					errorArr.push(errorResponse[key].message);
				}
				// Set Errors
				setErrors(errorArr);
			});
	};

	const statusChanger = (playerId, game, desiredStatus) => {
		axios
			.put("http://localhost:8000/players/edit/" + playerId, {
				[game]: desiredStatus,
			})
			.then(
				setPlayersList(
					playersList.map((player) =>
						player._id === playerId
							? { ...player, [game]: desiredStatus }
							: player
					)
				)
			)
			.catch((err) => console.log(err));
	};

	const deletePlayer = (playerId, playerName) => {
		confirmAlert({
			customUI: ({ onClose }) => {
				return (
					<div className="custom-ui d-flex flex-column align-items-center">
						<h1>Are you sure about deleteing player {playerName}?</h1>
						<div className={"d-flex"}>
							<button className={"btn btn-primary m-1"} onClick={onClose}>
								No
							</button>
							<button
								className={"btn btn-danger m-1"}
								onClick={() => {
									axios
										.delete("http://localhost:8000/players/delete/" + playerId)
										.then(
											setPlayersList(
												playersList.filter(
													(item, index) => item._id !== playerId
												)
											)
										)
										.catch((err) => console.log(err));
									onClose();
								}}
							>
								Yes, Delete it!
							</button>
						</div>
					</div>
				);
			},
		});
	};

	function goHome() {
		navigate("/ManagePlayers/list");
	}

	useEffect(() => {
		axios
			.get("http://localhost:8000/players")
			.then((res) => {
				setPlayersList(res.data);
				setLoaded(true);
			})
			.catch((err) => console.log(err));
	}, []);

	return (
		<div className="App d-flex flex-column align-items-center">
			<h5>
				<Link className={"p-2"} to={"/ManagePlayers"}>
					Manage Players
				</Link>
				<Link className={"p-2"} to={"/status"}>
					Manage Players Status
				</Link>
			</h5>
			{loaded && (
				<>
					<Router>
						<ManagePlayers
							errors={errors}
							onDelete={deletePlayer}
							onSubmit={addplayer}
							onCancel={goHome}
							playersList={playersList}
							path={"/ManagePlayers/*"}
						/>
						<ManageStatus
							path={"/status/*"}
							statusChanger={statusChanger}
							playersList={playersList}
						/>
					</Router>
				</>
			)}
		</div>
	);
}

export default App;
