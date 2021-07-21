import React from 'react';

const FormView = (props) => {

    const {firstname, lastname, email, password, passwordconfirm} = props.inputvalues;
//Get the variables from the state passed as input Values (Deconstructing)

    return (
        <div className={"d-flex flex-column"}>
            <h6>Your Form Data</h6>
            <p>First Name : {firstname}</p>
            <p>Last Name : {lastname}</p>
            <p>Email : {email}</p>
            <p>Password : {password}</p>
            <p>Password Confirmation : {passwordconfirm}</p>
        </div>
    );
}

export default FormView;
