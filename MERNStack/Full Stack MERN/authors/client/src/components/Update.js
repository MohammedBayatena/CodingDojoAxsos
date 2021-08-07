import React, {useEffect, useState} from 'react';
import axios from "axios";
import Form from "./Form";

const Update = (props) => {

    const [name, setName] = useState("");
    const [loaded, setLoaded] = useState(false);
    const {id, onSubmit, onCancel} = props;
    const [errors, setErrors] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + id)
            .then(res => {
                setName(res.data.name);
                setLoaded(true);
            })
    }, [id])

    const updateAuthor = (author) => {
        axios.put(`http://localhost:8000/api/author/${id}/edit`, author)
            .then(updatedAuthor => {
                onSubmit(updatedAuthor.data)
            })
            .catch(err => {
                const errorResponse = err.response.data.errors; // Get the errors from err.response.data
                const errorArr = []; // Define a temp error array to push the messages in
                for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
                    errorArr.push(errorResponse[key].message)
                }
                // Set Errors
                setErrors(errorArr);
            })
    }

    return (
        loaded && <>
            <Form
                initialName={name}
                onCancel={onCancel}
                errors={errors}
                onSubmit={updateAuthor}
                message={"Edit this author: "}/>
        </>
    );
};

export default Update;