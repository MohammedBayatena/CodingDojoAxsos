import React from "react";
import { Link, Router } from "@reach/router";
import StatusList from "./StatusList";

export default function ManageStatus(props) {
	const { playersList, statusChanger } = props;

	return (
		<div
			style={{ height: 600, width: 800, overflow: "scroll" }}
			className={"border d-flex flex-column p-3"}
		>
			<h5 className={"align-self-start"}>
				<Link className={"p-2"} to={"game1"}>
					Game 1
				</Link>
				<Link className={"p-2"} to={"game2"}>
					Game 2
				</Link>
				<Link className={"p-2"} to={"game3"}>
					Game 3
				</Link>
			</h5>

			<Router>
				<StatusList
					statusChanger={statusChanger}
					list={playersList}
					game="Game1"
					path="game1"
				/>
				<StatusList
					statusChanger={statusChanger}
					list={playersList}
					game="Game2"
					path="game2"
				/>
				<StatusList
					statusChanger={statusChanger}
					list={playersList}
					game="Game3"
					path="game3"
				/>
			</Router>
		</div>
	);
}
