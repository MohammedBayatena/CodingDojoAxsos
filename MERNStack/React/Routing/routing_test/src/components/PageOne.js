import React from 'react';
import {Link} from "@reach/router";

const PageOne = (props) => {

    return (
        <div>
            You are in Page One
            <br/>
            <Link to={"/route-two"}>Go To Page Two</Link>
        </div>
    )


}

export default PageOne;