import './App.css';
import HooksForm from "./Components/HooksForm";
import FormView from "./Components/FormView";
import {useState} from "react";

function App() {

    const [state, setState] = useState({
        firstname: "",
        lastname: "",
        email: "",
        password: "",
        passwordconfirm: ""
    }); // Create one big state and initialize it to empty. the set state is the setter passed as function

    return (
        <div className="App">
            <HooksForm state={state} setState={setState}/>
            {/*Pass the state and the state setter in the props*/}
            <FormView inputvalues={state}/>
            {/* Just pass the state*/}
        </div>
    );
}

export default App;
