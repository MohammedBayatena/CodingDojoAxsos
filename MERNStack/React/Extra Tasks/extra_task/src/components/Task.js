import React, {useContext} from 'react';
import "../styles/taskstyle.css"
import Context from "../context/tasksContext";

const Task = (props) => {

    const {todoList, setTodoList} = useContext(Context);
    const {text, status} = props;

    function generateClass() {
        return ((status === "todo") || (status === "done")) ? status : "hidden";
    }

    function handleClick(e) {
        e.preventDefault();
        console.log(status)
        let nextState = ""
        if (status === "todo") {
            nextState = "done"
        } else if (status === "done") {
            nextState = "finish"
        }

        let result = todoList.map(item => item.text === text ? {...item, status: nextState} : item)
        setTodoList(result)
    }

    function handleDelete(e) {
        e.preventDefault()
        setTodoList(todoList.filter((item) => item.text !== text))
    }

    return (
        <div className={"d-flex flex-column border p-1 m-1 w-50 h-100 text-break"}>
            <a href={"www.google.com"} className={"align-self-end text-danger fw-bold"}
               onClick={(e) => handleDelete(e)}>X</a>
            <p>{text}</p>
            <button
                className={"btn btn-primary " + generateClass()}
                onClick={(e) => handleClick(e)}>
                {status === "todo" ? "Start Doing" : status === "done" ? "Done?" : ""}
            </button>
        </div>
    )


}

export default Task;