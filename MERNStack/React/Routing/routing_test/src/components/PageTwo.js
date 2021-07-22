import React from 'react';
import {Link} from "@reach/router";

const PageTwo = (props) => {

    return (
        <div>
            You are in Page Two
            <br/>
            <Link to={"/route-one"}>Go To Page One</Link>

        </div>
    )


}

export default PageTwo;