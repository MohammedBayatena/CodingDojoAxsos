import React, {useEffect, useState} from 'react';
import AuthorRow from "./AuthorRow";
import axios from "axios";

const AuthorsList = () => {

    const [authorsList, setAuthorsList] = useState([]);
    const [refresh, setRefresh] = useState(false);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {

        axios.get("http://localhost:8000/api/authors")
            .then(res => {
                setAuthorsList(res.data);
                setLoaded(true);
            })
            .catch(err => console.log(err));

    }, [refresh])

    const doRefresh = () => {
        setRefresh(!refresh);
    }

    return (loaded &&
        <div>
            <table className={"table table-bordered table-striped"}>
                <thead>
                <tr>
                    <th>Author</th>
                    <th>Actions available</th>
                </tr>
                </thead>
                <tbody>
                {
                    authorsList.map((author, index) => {
                        return (<AuthorRow id={author._id} key={index + "author"} ondelete={doRefresh}/>)
                    })
                }
                </tbody>
            </table>
        </div>
    );
};

export default AuthorsList;