import React, {useContext} from 'react';
import Context from "../context/tasksContext";
import Task from "./Task";

const TodoList = (props) => {

    const {todoList} = useContext(Context);
    return (
        <div className={"d-flex flex-column w-25 align-items-center  text-center"}>
            <h1>Todo List</h1>
            {
                todoList.map((item, i) => {
                    return item.status === "todo" ? <Task key={"todo" + i} status={item.status} text={item.text}/> : ""
                })
            }
        </div>
    )
}

export default TodoList;