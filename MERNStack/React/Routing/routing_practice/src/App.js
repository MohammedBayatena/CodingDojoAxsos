import './App.css';
import {Router} from '@reach/router';
import HomeComponent from "./components/HomeComponent";
import CutsomWordNumComponent from "./components/CutsomWordNumComponent";

function App() {
    return (
        <div className="App">
            <Router>
                <HomeComponent path={"/home"}/>
                <CutsomWordNumComponent path={"/:value/"}/>
                <CutsomWordNumComponent path={"/:value/:txtcolor"}/>
                <CutsomWordNumComponent path={"/:value/:txtcolor/:bgcolor/"}/>
            </Router>
        </div>
    );
}

export default App;
