import './App.css';
import PersonCard from "./components/PersonCard";

function App() {
    return (
        <div className="App">
            <PersonCard firstname={"Jane"} lastname={"Doe"} age={45} haircolor={"black"}/>
            <PersonCard firstname={"Jhon"} lastname={"Smith"} age={88} haircolor={"Brown"}/>
            <PersonCard firstname={"Millard"} lastname={"Fillmore"} age={50} haircolor={"Brown"}/>
            <PersonCard firstname={"Maria"} lastname={"Smith"} age={62} haircolor={"Brown"}/>
        </div>
    );
}

export default App;