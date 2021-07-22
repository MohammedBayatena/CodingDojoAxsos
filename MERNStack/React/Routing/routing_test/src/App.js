import './App.css';
import {Router} from "@reach/router";
import PageOne from "./components/PageOne";
import PageTwo from "./components/PageTwo";


function App() {
    return (
        <div className="App">
            <Router>
                <PageOne path={"/route-one"}/>
                <PageTwo path={"/route-two"}/>
            </Router>
        </div>
    );
}

export default App;
