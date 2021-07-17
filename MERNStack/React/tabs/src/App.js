import './App.css';
import Tabs from "./components/Tabs";

function App() {

    const tabs = [
        {
            name: "Tab1",
            value: "Tab1 Content is shown here!"
        },
        {
            name: "Tab2",
            value: "Miku Miku Love"
        },
        {
            name: "Tab3",
            value: "I Really Like Miku!"
        }
    ];

    return (
        <div className="App">
            <Tabs tabs={tabs}/>
        </div>
    );
}

export default App;
