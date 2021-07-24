import React, {useContext} from 'react';
import Context from "../context/tasksContext";
import Task from "./Task";

const DoneList = (props) => {
    const {todoList} = useContext(Context);
    return (
        <div className={"d-flex flex-column w-25 align-items-center  text-center"}>
            <h1>Done List</h1>
            {
                todoList.map((item, i) => {
                    return item.status === "finish" ?
                        <Task key={"done" + i} status={item.status} text={item.text}/> : ""
                })
            }
        </div>
    )
}

export default DoneList;