//This is a Custom hook , we can manage lists using this hook , hooks are like classes that we create objects from
import {useState} from "react";

export default (initialList = []) => {

    const [list, setList] = useState(initialList);
    const addToList = (value) => setList([...list, value])
    const removeFromList = (position) => setList([...list.slice(0, position), ...list.slice(position + 1)]);

    return {
        list,
        addToList,
        removeFromList
    };

}