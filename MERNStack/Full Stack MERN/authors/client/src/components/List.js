import React from 'react';
import Row from "./Row";

const List = (props) => {

    const {data, onItemDelete, editCallBack} = props
    return (
        <div>
            <table className={"table table-bordered table-striped"}>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    data.map((item, index) => {
                        return (<Row data={{name: item.name}} id={item._id} key={item._id + index}
                                     editCallBack={editCallBack}
                                     ondelete={onItemDelete}/>)
                    })
                }
                </tbody>
            </table>
        </div>
    );
};

export default List;