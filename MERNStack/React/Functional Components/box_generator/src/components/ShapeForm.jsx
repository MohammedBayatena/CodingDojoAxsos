import React, {useState} from 'react';

const ShapeForm = (props) => {

    const [shape, setShape] = useState({}); //Created an empty state to contain a color

    const handleSubmit = (e) => { //When a user submit a form , Crate a shape object and send it to the addShape method passed from its parent
        e.preventDefault();
        props.addShape(shape);
        setShape({color: "", height: "", width: ""}); // Empty the input fields here
    };

    const createBox = (e) => {
        setShape({...shape, [e.target.id]: e.target.value})  //Create a shape by copying whats in there already and adding what we want
        // (Seen in Previous assignment)
    }

    return (
        <form className="row g-3 align-items-center" onSubmit={handleSubmit}>
            <div className="col-auto">
                <label htmlFor="color" className="col-form-label">Color</label>
            </div>
            <div className="col-auto">
                <input value={shape.color} type="text" id="color" className="form-control"
                       onChange={createBox}/>
            </div>
            <div className="col-auto">
                <label htmlFor="height" className="col-form-label">Height</label>
            </div>
            <div className="col-auto">
                <input value={shape.height} max={200} min={5} type="number" id="height" className="form-control"
                       onChange={createBox}/>
            </div>
            <div className="col-auto">
                <label htmlFor="width" className="col-form-label">Width</label>
            </div>
            <div className="col-auto">
                <input value={shape.width} max={200} min={5} type="number" id="width" className="form-control"
                       onChange={createBox}/>
            </div>
            <div className="col-auto">
                <input type={"submit"} value={"Add"} className={"btn btn-primary"}/>
            </div>
        </form>
    );
}

export default ShapeForm;