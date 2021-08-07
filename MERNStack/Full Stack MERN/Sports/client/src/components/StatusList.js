import React from "react";
import ButtonComponent from "./ButtonComponent";

export default function StatusList(props) {
	const { list, statusChanger, game } = props;

	return (
		<div>
			<table className={"table table-striped table-bordered"}>
				<thead>
					<tr>
						<th>Team Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{list.map((player, index) => (
						<tr key={player._id + "a"}>
							<td>{player.playerName}</td>
							<td>
								<ButtonComponent
									buttonText={"Playing"}
									btnstyle={player[game] === "Playing" ? "success" : "light"}
									successCallBack={() =>
										statusChanger(player._id, game, "Playing")
									}
								/>
								<ButtonComponent
									buttonText={"Not Playing"}
									btnstyle={player[game] === "Not Playing" ? "danger" : "light"}
									successCallBack={() =>
										statusChanger(player._id, game, "Not Playing")
									}
								/>
								<ButtonComponent
									buttonText={"Undecided"}
									btnstyle={player[game] === "Undecided" ? "warning" : "light"}
									successCallBack={() =>
										statusChanger(player._id, game, "Undecided")
									}
								/>
							</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	);
}
