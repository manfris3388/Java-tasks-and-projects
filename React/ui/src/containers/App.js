import HeaderContainer from './header/HeaderContainer';
import FooterContainer from "./footer/FooterContainer";
import './App.css';
import {BrowserRouter,Routes, Route} from "react-router-dom";
import HomePage from "./Pages/HomePage/HomePage";

function App() {
    return (
        <BrowserRouter>
            <div className='mainApp'>
                <HeaderContainer />
                <Routes>
                    <Route path='/' element={ <HomePage /> } />
                </Routes>
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;