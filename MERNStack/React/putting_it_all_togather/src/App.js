import './App.css';
import PersonCard from "./Component/PersonCard";

function App() {
    return (
        <div className="App">
            <PersonCard firstname={"Jane"} lastname={"Doe"} age={45} haircolor={"Black"}/>
            <PersonCard firstname={"John"} lastname={"Smith"} age={88} haircolor={"Brown"}/>
        </div>
    );
}

export default App;
