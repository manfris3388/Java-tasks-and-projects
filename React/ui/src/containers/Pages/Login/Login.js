import { Field, Form, Formik } from 'formik';
import { Container } from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/FormikFieldInputGroup/FormikFieldInputGroup';

const Login = () => {
    const validate = (login) => {
        const errors = {};

        if (!login.email.includes('@')) {
            errors.email = 'Elektroninis pastas turi tureti @!';
        }
        if (login.password.length < 8) {
            errors.password = 'Slaptazodis per trumpas!';
        }

        return errors;
    };

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={(login, helper) => {
                console.log('login', login);
            }}
            validate={validate}
        >
            {(props) => {
                console.log('React formik props', props);
                return (
                    <Container>
                        <Form>
                            <Field
                                name="email"
                                labelText="Email:"
                                type="text"
                                component={FormikFieldInputGroup}
                            />
                            <Field
                                name="password"
                                labelText="Password:"
                                type="password"
                                component={FormikFieldInputGroup}
                            />
                            <div>
                                <button type="submit">Submit</button>
                            </div>
                        </Form>
                    </Container>
                );
            }}
        </Formik>
    );
};

export default Login;
