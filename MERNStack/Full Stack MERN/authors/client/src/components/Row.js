import React from 'react';
import {Link} from "@reach/router";
import ButtonComponent from "./ButtonComponent";


const Row = (props) => {

    const {id, ondelete, editCallBack, data} = props;

    return (
        <tr>
            <td>
                <Link to={"/api"}>{data.name}</Link>
            </td>
            <td>
                <ButtonComponent buttonText={"Edit"} successCallBack={() => editCallBack(id)}/>
                <ButtonComponent buttonText={"Delete"} successCallBack={() => ondelete(id)}/>
            </td>
        </tr>
    );
};

export default Row;