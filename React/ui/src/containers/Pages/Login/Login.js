import {ErrorMessage, Field, Form, Formik} from 'formik';
import {
    Button,
    Container,
    Form as BootstrapForm,
    InputGroup,
} from 'react-bootstrap';

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
                                <Field name="email">
                                    {({field, form}) => {  // form -> Field form props
                                        console.log('field', field)
                                        console.log('form', form)
                                        const isValid = !form.errors[field.name];
                                        const isInvalid = form.touched[field.name] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId='email'>
                                                <BootstrapForm.Label>Email:</BootstrapForm.Label>
                                                <InputGroup>
                                                    <BootstrapForm.Control
                                                        type='text'
                                                        name={field.name}
                                                        isValid={form.touched[field.name] && isValid}
                                                        isInvalid={isInvalid}
                                                        feedback={form.errors[field.name]}
                                                        onChange={field.onChange}
                                                    />
                                                    <BootstrapForm.Control.Feedback type="invalid">
                                                        {form.errors[field.name]}
                                                    </BootstrapForm.Control.Feedback>
                                                </InputGroup>
                                            </BootstrapForm.Group>
                                        );
                                    }}
                                </Field>
                            </div>
                            <div>
                                <Field name="password">
                                    {({field, form}) => {  // form -> Field form props
                                        console.log('field', field)
                                        console.log('form', form)
                                        const isValid = !form.errors[field.name];
                                        const isInvalid = form.touched[field.name] && !isValid;
                                        return (
                                            <BootstrapForm.Group controlId='password'>
                                                <BootstrapForm.Label>Email:</BootstrapForm.Label>
                                                <InputGroup>
                                                    <BootstrapForm.Control
                                                        type='text'
                                                        name={field.name}
                                                        isValid={form.touched[field.name] && isValid}
                                                        isInvalid={isInvalid}
                                                        feedback={form.errors[field.name]}
                                                        onChange={field.onChange}
                                                    />
                                                    <BootstrapForm.Control.Feedback type="invalid">
                                                        {form.errors[field.name]}
                                                    </BootstrapForm.Control.Feedback>
                                                </InputGroup>
                                            </BootstrapForm.Group>
                                        );
                                    }}
                                </Field>
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
    )
        ;
};

export default Login;
