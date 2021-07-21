import React, {useState} from 'react';

const TodoForm = (props) => {

    const [task, setTask] = useState("");


    function addTask(e) {
        e.preventDefault();
        props.taskcreator({task: task, finished: false});
        setTask("");
    }

    return (
        <>
            <form onSubmit={addTask} className={"d-flex flex-column align-items-center"}>
                <div className={"row col-sm-4 m-5"}>
                    <input required={"required"} className={"form-control align-self-start"}
                           onChange={(e) => setTask(e.target.value)}
                           type="text" name={"task"} id={"task"}
                           placeholder={"Add a task"}
                           value={task}/>
                    <input type={"submit"} value={"Add"} className={"btn btn-primary align-self-start m-1 col-sm-2"}/>
                </div>
            </form>
        </>
    );
}

export default TodoForm;