import React, {useEffect, useState} from 'react';
import axios from "axios";
import InformationComponent from "./InformationComponent";
import {navigate, Router} from "@reach/router";

const SearchFormComponent = (props) => {
    const [categories, setCategories] = useState([]);
    const [category, setCategory] = useState("");
    const [id, setId] = useState("");


    useEffect(() => {
        axios.get('https://swapi.dev/api/')
            .then((response) => {
                setCategories(Object.keys(response.data));
            })
            .catch((err) => {
                console.log(err)
            })
    }, []);


    function handleFormSubmition(e) {
        e.preventDefault();
        navigate("/" + category + "/" + id);
    }

    return (
        <>
            <form onSubmit={handleFormSubmition} className="row g-3 align-items-center m-5">
                <div className="col-auto">
                    <label htmlFor="staticEmail2">Search for: </label>
                </div>
                <div className={"col-auto"}>
                    <select
                        defaultValue={''}
                        onChange={(e) => setCategory(e.target.value)}
                        className="col-auto form-select"
                        required={true}
                        aria-label="Default select example">
                        <option value="" disabled>Choose a Category</option>
                        {categories.map(
                            (item, i) => {
                                return (<option key={i} value={item}>{item}</option>)
                            })}
                    </select>
                </div>
                <div className="col-auto">
                    <label htmlFor="boxid" className="visually-hidden">Category</label>
                    <input onChange={(e) => setId(e.target.value)}
                           type="number"
                           className="form-control"
                           id="boxid"
                           required={true}
                           placeholder="ID"/>
                </div>
                <div className="col-auto align-self-center">
                    <button type="submit" className="btn btn-primary">Search</button>
                </div>
            </form>
            <Router>
                <InformationComponent path={"/:category/:id"}/>
            </Router>

        </>
    )

}


export default SearchFormComponent;