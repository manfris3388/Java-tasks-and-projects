import HeaderContainer from './header/HeaderContainer';
import FooterContainer from "./footer/FooterContainer";
import './App.css';
import {BrowserRouter,Routes, Route} from "react-router-dom";
import HomePage from "./Pages/HomePage/HomePage";
import NewChartPage from "./Pages/NewChartPage/NewChartPage";

function App() {
    return (
        <BrowserRouter>
            <div className='mainApp'>
                <HeaderContainer />
                <Routes>
                    <Route path='/' element={ <HomePage /> } />
                    <Route path='/charts' element={ <HomePage /> } />
                    <Route path='/charts/create' element={ <NewChartPage /> } />
                </Routes>
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;