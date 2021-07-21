import React, {useContext} from 'react';
import "./navstyle.css" // Simple Styling
import MyContext from "../context/MyContext";

const NavBar = (props) => {

    const {name} = useContext(MyContext); // >> Uses Context imported from MyContext [Destructuring is done here as name is got from context]
    return (
        <div className={"navbar align-content-center justify-content-between p-4"}>
            <a href={""}></a>
            <h4 className={"navbar-text"}>Hi {name}!</h4>
        </div>
    );
}

export default NavBar;