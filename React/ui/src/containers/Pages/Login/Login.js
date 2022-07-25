import {ErrorMessage, Field, Form, Formik} from 'formik';
import {Container} from "react-bootstrap";

const Login = () => {
    const validate = (login) => {
        const errors = {};

        if (!login.email.includes('@')) {
            errors.email = "Elektroninis pastas turi tureti @!";
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
            {props => {
                console.log('React formik props', props)

                return (
                    <Container>
                        <Form>
                            <div>
                                <label>Email</label>
                                <Field name="email"/>
                                <ErrorMessage name='email' style={{color: 'red'}} component={'div'}/>
                            </div>
                            <div>
                                <label>Password</label>
                                <Field name="password"/>
                                <ErrorMessage name='password' style={{color: 'red'}} component={'div'}/>
                            </div>

                            <div>
                                <button type="submit">Submit</button>
                            </div>
                        </Form>
                    </Container>
                )
            }
            }
        </Formik>
    );
};

export default Login;
