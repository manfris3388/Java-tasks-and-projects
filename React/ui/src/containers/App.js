import HeaderContainer from './header/HeaderContainer';
import FooterContainer from './footer/FooterContainer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages';

function App() {
    return (
        <BrowserRouter>
            <div className="mainApp">
                <HeaderContainer />
                <Pages />
                <FooterContainer />
            </div>
        </BrowserRouter>
    );
}

export default App;
