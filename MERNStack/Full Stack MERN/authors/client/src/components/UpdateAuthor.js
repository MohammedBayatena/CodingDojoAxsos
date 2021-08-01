import React, {useEffect, useState} from 'react';
import axios from "axios";
import AuthorForm from "./authorForm";

const UpdateAuthor = (props) => {

    const [name, setName] = useState("");
    const [loaded, setLoaded] = useState(false);
    const {id} = props;

    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + id)
            .then(res => {
                setName(res.data.name);
                setLoaded(true);
            })
    }, [id])

    const updateAuthor = author => {
        axios.put(`http://localhost:8000/api/author/${id}/edit`, author)
            .then(res => console.log("{ Status OK }"))
            .catch(err => console.log(err))
    }

    return (
        loaded && <AuthorForm
            formSubmit={updateAuthor}
            initialName={name}
            message={"Edit this author: "}/>
    );
};

export default UpdateAuthor;