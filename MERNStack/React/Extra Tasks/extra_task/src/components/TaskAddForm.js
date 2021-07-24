import React, {useContext, useState} from 'react';
import Context from "../context/tasksContext";

const TaskAddForm = (props) => {

    const [task, setTask] = useState("");
    const {todoList, setTodoList} = useContext(Context);

    function handleSubmit(e) {
        e.preventDefault();
        setTodoList([...todoList, {text: task, status: "todo"}])
        setTask("")
    }

    return (
        <form onSubmit={(e) => handleSubmit(e)} className="row g-3 m-3 align-items-center">

            <div className="col-auto">
                <label htmlFor="taskinput"
                       className="col-form-label">Task</label>
            </div>

            <div className="col-auto">
                <input
                    type="text"
                    id="taskinput"
                    value={task}
                    className="form-control"
                    onChange={(e) => setTask(e.target.value)}
                />
            </div>

            <div className="col-auto">
                <button className={"btn btn-primary"}>Add Task</button>
            </div>

        </form>
    )

}

export default TaskAddForm;