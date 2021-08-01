import React, {useState} from 'react';
import {Link, navigate} from "@reach/router";
import ButtonComponent from "./ButtonComponent";


const AuthorForm = (props) => {

    const {formSubmit, initialName, message} = props;
    const [name, setName] = useState(initialName);

    function cancel() {
        navigate("/api")
            .then(res => console.log("Back to Home"))
            .catch(err => console.log(err))
    }

    const onSubmitHandler = e => {
        e.preventDefault();
        formSubmit({name})
        navigate("/api")
            .then(res => console.log("went to home"))
            .catch(err => console.log(err))
    }

    return (
        <div className={"container"}>
            <h1 className={"p-2"}>Favourite Authors</h1>
            <Link className={"p-2"} to={"/api"}>Home</Link>
            <h5 className={"p-2"}>{message}</h5>
            <form onSubmit={onSubmitHandler}>
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
                            <ButtonComponent buttonText={"Cancel"} successCallBack={cancel}/>
                        </div>
                        <div className={"col-auto"}>
                            <input className={"btn btn-primary"} type={"submit"} value={"Submit"}/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default AuthorForm;