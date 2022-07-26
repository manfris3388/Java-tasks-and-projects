import {
    Button,
    Container,
    Form,
    FormControl,
    Nav,
    Navbar,
    NavDropdown,
} from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import { AuthUserContext } from '../../context/AuthUserContext';
import { useContext } from 'react';
import { useTranslation } from 'react-i18next';

const HeaderContainer = () => {
    const { authUser } = useContext(AuthUserContext);
    const { t } = useTranslation('header');
    return (
        <Navbar bg="light" expand="lg">
            <Container fluid>
                <Navbar.Brand to="/" as={NavLink}>
                    {t('common:anestheticChart')}
                </Navbar.Brand>
                <div>
                    <strong>{authUser.fullname}</strong>
                </div>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <Nav
                        className="me-auto my-2 my-lg-0"
                        style={{ maxHeight: '100px' }}
                        navbarScroll
                    >
                        <Nav.Link to="/charts" as={NavLink}>
                            {t('charts')}
                        </Nav.Link>
                        <Nav.Link to="/charts/create" as={NavLink}>
                            {t('newChart')}
                        </Nav.Link>
                        <Nav.Link href="#">{t('user')}</Nav.Link>
                    </Nav>
                    <NavDropdown title="Languages" id="navbarScrollingDropdown">
                        <NavDropdown.Item href="?lng=lt">LT</NavDropdown.Item>
                        <NavDropdown.Item href="?lng=en">EN</NavDropdown.Item>
                    </NavDropdown>
                    <Form className="d-flex">
                        <FormControl
                            type="search"
                            placeholder={t('search')}
                            className="me-2"
                            aria-label={t('search')}
                        />
                        <Button variant="outline-success">{t('search')}</Button>
                    </Form>
                    {!authUser.username ? (
                        <Nav.Link to="/login" as={NavLink}>
                            {t('login')}
                        </Nav.Link>
                    ) : (
                        <Nav.Link href="/login">{t('logout')}</Nav.Link>
                    )}
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default HeaderContainer;
