import './App.css';
import MainPage from "./views/MainPage";
import {navigate, Router} from "@reach/router";
import Update from "./components/Update";
import axios from "axios";
import Form from "./components/Form";
import React, {useEffect, useState} from "react";

function App() {

    const [authorsList, setAuthorsList] = useState([])
    const [loaded, setLoaded] = useState(false)


    useEffect(() => {
        axios.get("http://localhost:8000/api/authors")
            .then(res => {
                setAuthorsList(res.data);
                setLoaded(true);
            })
            .catch(err => console.log(err));
    }, [])


    const onItemDelete = (id) => {
        axios.delete(`http://localhost:8000/api/author/${id}/delete`)
            .then(res => {
                setAuthorsList(authorsList.filter((item) => item._id !== id));
            })
            .catch(err => console.log(err))
    }

    const editCallBack = (id) => {
        navigate(`/api/author/${id}/edit`)
            .then(res => console.log("Navigated to home"))
            .catch(err => console.log(err))
    }


    function formCancel() {
        navigate("/api")
            .then(res => console.log("Back to Home"))
            .catch(err => console.log(err))
    }

    const editAuthor = (author) => {
        setAuthorsList(authorsList.map(
            (item) => (item._id === author._id) ? author : item));
        navigate("/api")
            .catch(err => console.log(err))
    }

    const addAuthor = (author) => {
        axios.post(`http://localhost:8000/api/addAuthor`, author)
            .then(
                addedAuthor => {
                    setAuthorsList([...authorsList, addedAuthor.data]);
                    navigate("/api")
                        .catch(err => console.log(err))
                }
            )
            .catch(err => console.log(err))
    }

    return (
        <div className="App">
            {loaded &&
            <>
                <Router>
                    <MainPage list={authorsList} onItemDelete={onItemDelete} editCallBack={editCallBack} path={"/api"}/>
                    <Form path={"/api/addAuthor"}
                          initialName={""}
                          onCancel={formCancel}
                          onSubmit={addAuthor}
                          message={"Add a new author: "}/>
                    <Update path={"/api/author/:id/edit"}
                            onCancel={formCancel}
                            onSubmit={editAuthor}
                            message={"Edit this author: "}
                    />
                </Router>
            </>}

        </div>
    );
}

export default App;
