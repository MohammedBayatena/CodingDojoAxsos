import React from 'react';
import axios from "axios";
import AuthorForm from "./authorForm";

const AddAuthor = (props) => {

    const addAuthor = author => {
        axios.post(`http://localhost:8000/api/addAuthor`, author)
            .then(res => console.log(res))
            .catch(err => console.log(err))
    }

    return (
        <AuthorForm
            formSubmit={addAuthor}
            initialName={""}
            message={"Add a new author: "}/>
    );


};

export default AddAuthor;