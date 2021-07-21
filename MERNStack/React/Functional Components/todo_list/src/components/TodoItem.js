import React, {useState} from 'react';
import "./ListItem.css"

const TodoItem = (props) => {

    const task = props.task;
    const deleteTask = props.deleteTask
    const updateTask = props.updateTask;
    const [isDone, setIsDone] = useState(task.finished);

    function handleSubmit(event) {
        event.preventDefault();
        deleteTask(task);
    }

    return (
        <form className={"d-flex m-2 align-self-center w-50"} onSubmit={handleSubmit}>
            <p style={{display: "inline-block"}}
               className={isDone.toString() + " m-2 w-50 text-break"}>{task.task}</p>
            <label>
                <input className={"form-check m-2"} type="checkbox" checked={isDone} onChange={e => {
                    setIsDone(e.target.checked)
                    updateTask(task)
                }}/></label>
            < input type={"submit"} value={"Delete"} className={"btn btn-dark"}/>
        </form>
    )
}

export default TodoItem;