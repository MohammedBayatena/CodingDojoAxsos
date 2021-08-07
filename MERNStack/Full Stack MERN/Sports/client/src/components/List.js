import React from "react";
import ButtonComponent from "./ButtonComponent";

export default function List(props) {
	const { list, onDelete } = props;

	return (
		<div>
			<table className={"table table-striped table-bordered"}>
				<thead>
					<tr>
						<th>Team Name</th>
						<th>Preffered Position</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					{list.map((player, index) => (
						<tr key={player._id}>
							<td>{player.playerName}</td>
							<td>{player.prefferedPosition}</td>
							<td>
								<ButtonComponent
									buttonText={"Delete"}
									btnstyle={"primary"}
									successCallBack={() =>
										onDelete(player._id, player.playerName)
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
