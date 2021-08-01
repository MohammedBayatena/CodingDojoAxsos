import React, {useEffect, useState} from 'react';
import {Link, navigate} from "@reach/router";
import ButtonComponent from "./ButtonComponent";
import axios from "axios";

const AuthorRow = (props) => {

    const {id, ondelete} = props;
    const [name, setName] = useState("");
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {
        axios.get('http://localhost:8000/api/author/' + id)
            .then(res => {
                setName(res.data.name);
                setLoaded(true);
            })
    }, [id])

    function editData() {
        navigate(`/api/author/${id}/edit`)
            .then(res => console.log("Navigated to home"))
            .catch(err => console.log(err))
    }

    function deleteData() {
        axios.delete(`http://localhost:8000/api/author/${id}/delete`)
            .then(res => console.log(res))
            .then(ondelete())
            .catch(err => console.log(err))
    }

    return (loaded &&
        <tr>
            <td>
                <Link to={"/api"}>{name}</Link>
            </td>
            <td>
                <ButtonComponent buttonText={"Edit"} successCallBack={editData}/>
                <ButtonComponent buttonText={"Delete"} successCallBack={deleteData}/>
            </td>
        </tr>
    );
};

export default AuthorRow;