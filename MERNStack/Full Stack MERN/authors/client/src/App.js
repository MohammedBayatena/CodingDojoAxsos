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
    const [errors, setErrors] = useState([]);


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
        <div className="App">
            {loaded &&
            <>
                <Router>
                    <MainPage list={authorsList} onItemDelete={onItemDelete} editCallBack={editCallBack} path={"/api"}/>
                    <Form path={"/api/addAuthor"}
                          initialName={""}
                          onCancel={formCancel}
                          onSubmit={addAuthor}
                          errors={errors}
                          message={"Add a new author: "}/>
                    <Update path={"/api/author/:id/edit"}
                            onCancel={formCancel}
                            onSubmit={editAuthor}
                            errors={errors}
                            message={"Edit this author: "}
                    />
                </Router>
            </>}

        </div>
    );
}

export default App;
