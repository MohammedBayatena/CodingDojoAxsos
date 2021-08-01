import './App.css';
import MainPage from "./views/MainPage";
import {Router} from "@reach/router";
import AddAuthor from "./components/AddAuthor";
import UpdateAuthor from "./components/UpdateAuthor";

function App() {
    return (
        <div className="App">
            <Router>
                <MainPage path={"/api"}/>
                <AddAuthor path={"/api/addAuthor"}/>
                <UpdateAuthor path={"/api/author/:id/edit"}/>
            < /Router>
        </div>
    );
}

export default App;
