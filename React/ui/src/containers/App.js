import HeaderContainer from './header/HeaderContainer';
import ContentContainer from "./content/ContentContainer";
import FooterContainer from "./footer/FooterContainer";
import './App.css';

function App() {
    return <div className='mainApp'>
        <HeaderContainer />
        <ContentContainer />
        <FooterContainer />
    </div>;
}

export default App;