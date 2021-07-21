import React, {useState} from 'react';
import ShapeForm from "./components/ShapeForm";
import ShapeDisplay from "./components/ShapeDisplay";
import './App.css';


function App() {

    const [shapes, setShapes] = useState([]);   // Add a new State that contains an empty list
    const newShape = (shape) => {  // This function is passed as a parameter and is called from the child class
        setShapes([...shapes, shape]) // Do a copy of the array then add the object we created in the form and set that in the state
    }
//View Form and Boxes
    return (
        <>
            <div className={"App"}>
                <h1>Add Shapes</h1>
                <ShapeForm addShape={newShape}/>
                <ShapeDisplay shapes={shapes}/>
            </div>

        </>
    );
}

export default App;