import React, {useEffect, useState} from 'react';
import axios from "axios";

const InformationComponent = (props) => {

    const [result, setResult] = useState({});
    const [attributes, setAttributes] = useState([]);
    const [error, setError] = useState("");
    const {category, id} = props;


    useEffect(() => {

        function getANewList() {
            return Object.keys(result).filter(
                (item) => {
                    return (!(item.endsWith('s') || item.includes('_') || (["created", "edited", "url", "people"]).includes(item)))
                })
        }

        axios.get("https://swapi.dev/api/" + category + "/" + id)
            .then(
                (response) => {
                    setResult(response.data)
                    console.log(result)
                    setAttributes(getANewList())
                }
            )
            .catch(
                (err) => {
                    err.toString().includes("404") ? setError("No Search Results!") : console.log(err)
                })
        return () => {
            setError("");
        }

    }, [id])


    return (
        <div>
            {
                error !== "" ? <h1>{error}</h1> : attributes.map(
                    (item, index) => {
                        return (index === 0 || item === "name") ?
                            <h1 key={"a" + index}>{item}: {result[item]} </h1> :
                            <h4 key={"a" + index}>{item}: {result[item]}</h4>
                    })
            }
        </div>
    )

}

export default InformationComponent;

//Todo Fix Lag Bug