import React, {useState} from 'react';
import MyContext from "../context/MyContext"; // Imports the Context (MyContext) from the Context folder under src/context

const Wrapper = (props) => {

    //Wrapper have children passed to it from the App component ,
    //The State is in the Wrapper Component

    const [name, setName] = useState("Bob Smith");

    return (
        <div>
            <MyContext.Provider value={{name, setName}}>
                {props.children}
            </MyContext.Provider>
        </div>
    )
}

export default Wrapper;