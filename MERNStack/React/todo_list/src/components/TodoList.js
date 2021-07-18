import React from 'react';
import TodoItem from "./TodoItem";

const TodoList = (props) => {

    const tasks = props.tasks;
    const setTasks = props.setTasks;

    //keep and array of every thing but the value passed to that function
    const deleteATask = (task) => {
        setTasks(tasks.filter((item) => item !== task))
    }

    //Keep state of object when the delete renders everything again
    const updateTask = (task) => {
        setTasks(tasks.map((item) => {
            if (item === task) {
                const updated = {...task, finished: !task.finished};
                return updated;
            }
            return item;
        }))
    }

    return (
        tasks.map((item, index) => <TodoItem key={item.task + index}
                                             updateTask={updateTask}
                                             deleteTask={deleteATask}
                                             task={item}/>)
        // Key is very importnant here ( if item doesnt have key there will be serveral items with same id or name hence the class inherit bug happens
        // Remove key= and see the bug when removing from list form top ----------> Important (Fixes warning in console)
    );

}

export default TodoList;