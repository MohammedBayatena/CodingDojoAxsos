import React from 'react';
import {Link} from "@reach/router";
import AuthorsList from "../components/AuthorsList";

const MainPage = () => {

    return (
        <div className={"container"}>
            <h1 className={"p-2"}>Favourite Authors</h1>
            <Link className={"p-2"} to={"/api/addAuthor"}>Add an Author</Link>
            <h5 className={"p-2"}>We have quotes by: </h5>
            <AuthorsList/>
        </div>
    );
};

export default MainPage;