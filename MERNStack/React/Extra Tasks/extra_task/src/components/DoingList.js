import React, {useContext} from 'react';
import Context from "../context/tasksContext";
import Task from "./Task";

const DoingList = (props) => {

    const {todoList} = useContext(Context);
    return (
        <div className={"d-flex flex-column w-25 align-items-center  text-center"}>
            <h1>Doing List</h1>
            {
                todoList.map((item, i) => {
                    return item.status === "done" ? <Task key={"doing" + i} status={item.status} text={item.text}/> : ""
                })
            }
        </div>
    )
}

export default DoingList;