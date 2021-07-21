import React, {useContext} from 'react';
import MyContext from "../context/MyContext";


const Form = () => {

    const {name,setName} = useContext(MyContext);

    return (
        <div>
            <form>
                <div className={"row g-3 align-items-center mt-4 m-lg-4"}>
                    <div className="col-auto">
                        <label htmlFor={"name"} className={"col-sm-4 form-label text-nowrap"}>Your Name: </label>
                    </div>
                    <div className="col-auto">
                        <input className={"form-control bg-light"}
                               type={"text"}
                               id={"name"}
                               placeholder={name}
                               onChange={(e) => setName(e.target.value)}
                        />
                    </div>
                </div>
            </form>
        </div>
    )

}

export default Form;