import React, {useState} from 'react'

export default (props) => {

    const {initialtitle, initialprice, initialdescription, buttontext, onSubmitProp} = props;

    //keep track of what is being typed via useState hook
    const [title, setTitle] = useState(initialtitle);
    const [price, setPrice] = useState(initialprice);
    const [description, setDescription] = useState(initialdescription);

    const onSubmitHandler = e => {
        e.preventDefault();
        onSubmitProp({title, price, description})
    }

    return (
        <form onSubmit={onSubmitHandler} className={"d-flex flex-column"}>
            <div className="row mb-3 btn-secondary p-2 rounded mt-5 ">
                <label htmlFor="title" className="col-sm-5 col-form-label">Title</label>
                <div className="col-sm-7">
                    <input placeholder={"Title"} onChange={(e) => setTitle(e.target.value)} type="text"
                           className="form-control"
                           value={title}
                           id="title"/>
                </div>
            </div>
            {(title.length < 3 && title !== "") ?
                <p style={{color: 'red'}}>{"Title must be at least 2 characters long."}</p> : ''}
            <div className="row mb-3 btn-secondary p-2 rounded">
                <label htmlFor="price" className="col-sm-5 col-form-label">Price</label>
                <div className="col-sm-7">
                    <input onChange={(e) => setPrice(e.target.value)} type="number"
                           className="form-control"
                           value={price}
                           id="price"/>
                </div>
            </div>
            {(price < 1 && price !== 0) ? <p style={{color: 'red'}}>{"Price must be at least 1 dollar."}</p> : ''}
            <div className="row mb-3 btn-secondary p-2 rounded">
                <label htmlFor="description" className="col-sm-5 col-form-label">Description</label>
                <div className="col-sm-7">
                    <textarea placeholder={"Description"} onChange={(e) => setDescription(e.target.value)}
                              className="form-control"
                              value={description}
                              id="description"/>
                </div>
            </div>
            {(description.length < 10 && description !== "") ?
                <p style={{color: 'red'}}>{"Description must be at least 10 characters long."}</p> : ''}

            <button className={"btn btn-primary"}>{buttontext}</button>

        </form>
    )


}