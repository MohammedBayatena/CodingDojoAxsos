import React, {useEffect, useState} from 'react';
import axios from "axios";
import Form from "./Form";

const Update = (props) => {

    const [name, setName] = useState("");
    const [loaded, setLoaded] = useState(false);
    const {id, onSubmit, onCancel} = props;

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
            .catch(err => console.log(err))
    }

    return (
        loaded && <>
            <Form
                initialName={name}
                onCancel={onCancel}
                onSubmit={updateAuthor}
                message={"Edit this author: "}/>
        </>
    );
};

export default Update;