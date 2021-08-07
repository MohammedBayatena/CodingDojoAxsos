import React from "react";
import { Link, Router } from "@reach/router";
import List from "./List";
import Form from "./Form";

export default function ManagePlayers(props) {
	const { playersList, onSubmit, onCancel, onDelete, errors } = props;

	return (
		<div
			style={{ height: 600, width: 800, overflow: "scroll" }}
			className={"border d-flex flex-column p-3"}
		>
			<h5 className={"align-self-start"}>
				<Link className={"p-2"} to={"list"}>
					List
				</Link>
				<Link className={"p-2"} to={"addplayer"}>
					Add Player
				</Link>
			</h5>
			<Router>
				<List onDelete={onDelete} list={playersList} path="list" />
				<Form
					path={"addplayer"}
					initialName={""}
					initialPosition={""}
					errors={errors}
					message={"Add Player"}
					onCancel={onCancel}
					onSubmit={onSubmit}
				/>
			</Router>
		</div>
	);
}
