import './App.css';
import TaskAddForm from "./components/TaskAddForm";
import {useState} from "react";
import Context from "./context/tasksContext";
import TodoList from "./components/TodoList";
import DoingList from "./components/DoingList";
import DoneList from "./components/DoneList";
import Tip from "./components/Tip";

function App() {

    const [todoList, setTodoList] = useState([]);

    return (
        <div className={"d-flex flex-column"}>
            <Context.Provider value={{todoList, setTodoList}}>
                <TaskAddForm/>
                <div className={"d-flex justify-content-evenly"}>
                    <TodoList/>
                    <DoingList/>
                    <DoneList/>
                </div>
            </Context.Provider>
            <h1 className={"align-self-center m-4"}>Tips For Productivity</h1>
            <div className={"d-flex align-self-center"}>
                <Tip name={"Five-minutes rule"} description={"make a deal with yourself to do at least five minutes of a task"} />
                <Tip name={"Pomodoro technique"} description={"make a deal with yourself to do at least five minutes of a task"} />
                <Tip name={"Bruh rule"} description={"make a deal with yourself to do at least zero minutes of a task"} />
            </div>
        </div>
    );
}

export default App;
