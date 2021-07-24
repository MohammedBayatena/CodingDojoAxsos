import React, {useState} from 'react';

const Tip = (props) => {

    const [likes, setLikes] = useState(0)
    const {name, description} = props;

    function addlikes() {
        setLikes(likes + 1);
    }

    return (
        <div className={"border d-flex flex-column align-items-center m-3 p-4 w-50 "}>
            <h2>{name}</h2>
            <button
                className={"btn btn-dark"}
                onClick={addlikes}

            >Like this Tip
            </button>
            <p>Likes: {likes}</p>
            <p className={"text-break"}>Description : {description} </p>
        </div>
    )


}

export default Tip;