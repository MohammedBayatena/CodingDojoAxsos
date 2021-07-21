import './App.css';
import TodoForm from "./components/TodoForm";
import {useEffect, useState} from "react";
import TodoList from "./components/TodoList";


export default function App() {

    const [tasks, setTasks] = useState([])

    //Initialize the taskslist Variable , Read Tasks from the json file or initialize to an empty Array []
    useEffect(() => {
        if (localStorage.getItem("tasksList")) {
            setTasks(JSON.parse(localStorage.getItem("tasksList")))
        }
    }, [])

    // Every Time the Tasks list changes this code excutes
    useEffect(() => {
        localStorage.setItem("tasksList", JSON.stringify(tasks))
    }, [tasks])

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

