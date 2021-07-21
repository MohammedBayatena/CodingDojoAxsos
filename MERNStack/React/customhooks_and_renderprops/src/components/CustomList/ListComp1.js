import React, {useState} from 'react';

import useList from './useList';

export default () => {

    const [val, setVal] = useState('');
    const {list, addToList, removeFromList} = useList(['item1', 'item2']); // Here we use the useList hook to create a list that is kept in the uselist.js hook
    //We can have as many lists as we want using this Custom hook

    function handleSubmit() {
        addToList(val);
        setVal('');
    }

    const handleDelete = (event, i) => {
        event.preventDefault();
        removeFromList(i);
    }

    return (
        <>
            <ul>
                {
                    list.map(
                        (item, i) => {
                            return (
                                <li style={{display: "flex", alignItems: "center"}} key={i}>
                                    <p style={{marginRight: "10px"}}>{item}</p>
                                    <a href='#' onClick={(e) => handleDelete(e, i)}>Remove</a>
                                </li>
                            )
                        })
                }
            < /ul>
            <input
                onChange={e => setVal(e.target.value)}
                value={val}
            />

            <button onClick={handleSubmit}>Add</button>
        </>
    );
}