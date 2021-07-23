import React, {useEffect, useState} from 'react';
import axios from "axios";
import ErrorYoda from "./ErrorYoda";
import {Link} from "@reach/router";
import 'x-axios-progress-bar/dist/nprogress.css'
import {loadProgressBar} from 'x-axios-progress-bar'

loadProgressBar();

const InformationComponent = (props) => {

    const [result, setResult] = useState({});
    // const [attributes, setAttributes] = useState([]);
    const [homeworld, setHomeWorld] = useState("");
    const [error, setError] = useState("");
    const {category, id} = props;

    function getANewList() {
        return Object.keys(result).filter(
            (item) => {
                return (!(item.endsWith('s') || item.includes('_') || (["created", "edited", "url", "people"]).includes(item)))
            })
    }


    useEffect(() => {
        axios.get("https://swapi.dev/api/" + category + "/" + id)
            .then(
                (response) => {
                    setResult(response.data)
                }
            )
            .catch(
                (err) => {
                    err.toString().includes("404") ? setError("No Search Results!") : console.log(err)
                })
        return () => {
            setError("");
        }

    }, [id, category])


    function getHomeWorld(resultElement) {

        axios.get(resultElement, {progress: false})
            .then(
                (response) => {
                    setHomeWorld(response.data.name);
                })
            .catch(
                (err) => {
                    setHomeWorld("Error 404 Planet not Found");
                }
            )
        return homeworld;
    }

    return (
        <div>
            {
                error !== "" ? <ErrorYoda/> : getANewList().map(
                    (item, index) => {
                        return (index === 0 || item === "name") ?
                            <h1 key={"a" + index}>{item}: {result[item]} </h1> :
                            item === "homeworld" ?
                                <div key={"b" + index}>
                                    <h4>HomeWorld: {getHomeWorld(result[item])}</h4>
                                    <Link
                                        to={"/planets/" + result[item].charAt(result[item].length - 2)}>View
                                        HomeWorld</Link>
                                </div> :
                                <h4 key={"a" + index}>{item}: {result[item]}</h4>
                    })
            }
        </div>
    )

}

export default InformationComponent;

//Todo Fix Lag Bug