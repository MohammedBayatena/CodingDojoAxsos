import React, { useState } from "react";
import ButtonComponent from "./ButtonComponent";

const Form = (props) => {
	const { initialName, initialPosition, message, onCancel, onSubmit, errors } =
		props;
	const [playerName, setplayerName] = useState(initialName);
	const [prefferedPosition, setprefferedPosition] = useState(initialPosition);

	return (
		<div className={"container"}>
			<h5 className={"p-2"}>{message}</h5>
			<form>
				<div className={"p-5 border"}>
					<div className={"row d-flex align-items-center"}>
						<div className={"col-3"}>
							<label>Player Name: </label>
						</div>
						<div className={"col-auto m-1"}>
							<input
								id={"nameInput"}
								onChange={(e) => setplayerName(e.target.value)}
								className={"form-control"}
								value={playerName}
							/>
						</div>
					</div>
					<div className={"row d-flex align-items-center"}>
						<div className={"col-3"}>
							<label style={{ wordBreak: "break-word" }}>
								{" "}
								Preferred Position:{" "}
							</label>
						</div>
						<div className={"col-auto m-1"}>
							<input
								id={"positionInput"}
								onChange={(e) => setprefferedPosition(e.target.value)}
								className={"form-control"}
								value={prefferedPosition}
							/>
						</div>
					</div>
					<div className={"row offset-sm-3 pt-2"}>
						<div className={"col-auto"}>
							<ButtonComponent
								buttonText={"Cancel"}
                                btnstyle={"danger"}
								successCallBack={onCancel}
							/>
						</div>
						<div className={"col-auto"}>
							<ButtonComponent
								buttonText={"Submit"}
                                btnstyle={"primary"}
								successCallBack={() =>
									onSubmit({
										playerName: playerName,
										prefferedPosition: prefferedPosition,
									})
								}
							/>
						</div>
					</div>
				</div>
			</form>
			{
				// Loop through all errors and get the messages
				errors.map((err, index) => (
					<p className={"alert alert-warning p-2 m-2"} key={index}>
						{err}
					</p>
				))
			}
		</div>
	);
};

export default Form;
