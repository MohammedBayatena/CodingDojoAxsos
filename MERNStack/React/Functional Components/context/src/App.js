import './App.css';
import NavBar from "./components/NavBar";
import Wrapper from "./components/Wrapper";
import FormWrapper from "./components/FormWrapper";

function App() {
//App Contains a Wrapper Components that have 2  Children Navbar and the form
    return (
        <Wrapper>
            <NavBar/>
            <FormWrapper/>
        </Wrapper>
    );
}

export default App;
