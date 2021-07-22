import React, {useState} from 'react';
import axios from "axios";

const PokemonList = (props) => {

    const [pokemonList, setPokemonList] = useState([]);
    const [src, setSrc] = useState("")

    function getPokemon() {
        axios.get('https://pokeapi.co/api/v2/pokemon?limit=807')
            .then((response) => setPokemonList(response.data.results))
            .catch((err) => console.log(err))
    }

    return (
        <div>
            <button onClick={getPokemon}>Get Pokemon</button>
            <ul>
                {
                    pokemonList.map(
                        (item, index) => {
                            const {name, url} = item
                            return (<li key={index}>{name}</li>)
                        }
                    )
                }
            </ul>
        </div>
    );

}

export default PokemonList;

