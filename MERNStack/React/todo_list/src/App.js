import './App.css';
import TodoForm from "./components/TodoForm";
import {useEffect, useState} from "react";
import TodoList from "./components/TodoList";


export default function App() {

    const [tasks, setTasks] = useState([])

    useEffect(() => {
        // setTasks(tasks);
        console.log(tasks)
    });

    const addTask = (task) => {
        setTasks([...tasks, task]);
    }

    return (
        <div className="App d-flex flex-column">
            <TodoForm taskcreator={addTask}/>
            <TodoList tasks={tasks} setTasks={setTasks}/>
        </div>
    );
}

