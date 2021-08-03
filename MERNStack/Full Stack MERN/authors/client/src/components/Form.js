import React, {useState} from 'react';
import {Link} from "@reach/router";
import ButtonComponent from "./ButtonComponent";


const Form = (props) => {

    const {initialName, message, onCancel, onSubmit} = props;
    const [name, setName] = useState(initialName);

    return (
        <div className={"container"}>
            <h1 className={"p-2"}>Favourite Authors</h1>
            <Link className={"p-2"} to={"/api"}>Home</Link>
            <h5 className={"p-2"}>{message}</h5>
            <form>
                <div className={"p-5 border"}>
                    <div className={"row d-flex align-items-center"}>
                        <div className={"col-auto"}>
                            <label>Name: </label>
                        </div>
                        <div className={"col-auto"}>
                            <input
                                id={"nameInput"}
                                onChange={(e) => setName(e.target.value)}
                                className={"form-control"}
                                value={name}/>
                        </div>
                    </div>
                    <div className={"row offset-sm-1 pt-2"}>
                        <div className={"col-auto"}>
                            <ButtonComponent buttonText={"Cancel"} successCallBack={onCancel}/>
                        </div>
                        <div className={"col-auto"}>
                            <ButtonComponent buttonText={"Submit"} successCallBack={() => onSubmit({name: name})}/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default Form;