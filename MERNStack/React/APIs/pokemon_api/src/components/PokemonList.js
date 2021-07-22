import React, {useState} from 'react';

const PokemonList = (props) => {

    const [pokeList, setPokeList] = useState([]);

    function fetchPokemon() {
        fetch("https://pokeapi.co/api/v2/pokemon?limit=807")
            .then((response) => {
                return (response.json());
            })
            .then((response) => {
                setPokeList(response.results);
            }).catch(err => console.log("Error Fetching Pokemon" + err));
    }

    return (
        <div>
            <button onClick={fetchPokemon}> Fetch Pokemon</button>
            <ul>
                {
                    pokeList.map(
                        (item, i) => {
                            const {name} = item // Destructuring
                            return (<li key={i}>{name}</li>)
                        }
                    )
                }
            </ul>
        </div>
    );
}
export default PokemonList;