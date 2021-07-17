import React from "react";

const HooksForm = (props) => {

    const {state, setState} = props; // Get the state variables and the setter from props
    const writeToState = e => {
        setState({
            ...state, // copy the state as an array
            [e.target.id]: e.target.value // change this certain index inside the copied array (list)
        });
        console.log({state})
    }
    return (
        <form className={"d-flex flex-column"}>
            <div className="row mb-3 btn-secondary p-2 rounded mt-5 ">
                <label htmlFor="firstname" className="col-sm-5 col-form-label">First Name</label>
                <div className="col-sm-7">
                    <input onChange={writeToState} type="text" className="form-control"
                           id="firstname"/>
                </div>
            </div>
            {(state["firstname"].length < 2 && state["firstname"] !== "") ?
                <p style={{color: 'red'}}>{"First Name must be at least 2 characters long."}</p> : ''}
            <div className="row mb-3 btn-secondary p-2 rounded">
                <label htmlFor="lastname" className="col-sm-5 col-form-label">Last Name</label>
                <div className="col-sm-7">
                    <input onChange={writeToState} type="text" className="form-control"
                           id="lastname"/>
                </div>
            </div>
            {state["lastname"].length < 2 && state["lastname"] !== "" ?
                <p style={{color: 'red'}}>{"Last Name must be at least 2 characters long."}</p> : ''}
            <div className="row mb-3 btn-secondary p-2 rounded">
                <label htmlFor="email" className="col-sm-5 col-form-label">Email</label>
                <div className="col-sm-7">
                    <input onChange={writeToState} type="text" className="form-control"
                           id="email"/>
                </div>
            </div>
            {state["email"].length < 5 && state["email"] !== "" ?
                <p style={{color: 'red'}}>{"Email must be at least 5 characters long."}</p> : ''}
            <div className="row mb-3 btn-secondary p-2 rounded">
                <label htmlFor="password" className="col-sm-5 col-form-label">Password</label>
                <div className="col-sm-7">
                    <input onChange={writeToState} type="password" className="form-control"
                           id="password"/>
                </div>
            </div>
            <div className="row mb-3 btn-secondary p-2 rounded">
                <label htmlFor="passwordconfirm" className="col-sm-5 col-form-label">Confirm Password</label>
                <div className="col-sm-7">
                    <input onChange={writeToState} type="password"
                           className="form-control" id="passwordconfirm"/>
                </div>
            </div>
            {state["password"].length < 8 & state["password"] !== "" ?
                <p style={{color: 'red'}}>{"Password must be at least 8 characters long."}</p> : ''}
            {!(state['passwordconfirm'] === state['password']) ?
                <p style={{color: 'red'}}>{"Password and Password Confirmation must match"}</p> : ''}
        </form>
    )
}
export default HooksForm;