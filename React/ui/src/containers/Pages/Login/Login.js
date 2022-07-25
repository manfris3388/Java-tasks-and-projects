import {Field, Form, Formik} from 'formik';

const Login = () => {
    const validate = (login) => {
        const errors = {};

        if (!login.email.includes('@')) {
            errors.email = "Elektroninis pastas turi tureti @!";
        }
        if (login.password.length < 8) {
            errors.password = 'Slaptazodis per trumpas';
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

                return (<Form>
                        <div>
                            <label>Email</label>
                            <Field name="email"/>
                            {props.errors.email && (
                                <span>{props.errors.email}</span>
                            )}
                        </div>
                        <div>
                            <label>Password</label>
                            <Field name="password"/>
                            {props.errors.password && (
                                <span>{props.errors.password}</span>
                            )}
                        </div>

                        <div>
                            <button type="submit">Submit</button>
                        </div>
                    </Form>
                )
            }
            }
        </Formik>
    );
};

export default Login;
