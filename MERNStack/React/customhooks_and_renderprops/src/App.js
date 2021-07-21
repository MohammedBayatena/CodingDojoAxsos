import './App.css';
import CounterExample from "./components/Counter/CounterExample";
import AnotherCounterExample from "./components/Counter/AnotherCounterExample";
import ListComp1 from "./components/CustomList/ListComp1";

function App() {
    return (
        <div className="App">
            <h1>Render Props </h1>
            <CounterExample/>
            <hr/>
            <AnotherCounterExample/>
            <h1>Custom Hooks</h1>
            <ListComp1/>
        </div>
    );
}

export default App;
