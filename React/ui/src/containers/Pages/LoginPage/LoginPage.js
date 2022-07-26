import { Field, Form, Formik } from 'formik';
import { Button, Container, Spinner } from 'react-bootstrap';
import FormikFieldInputGroup from '../../../components/FormikFieldInputGroup/FormikFieldInputGroup';
import * as Yup from 'yup';
import { loginEndpoint } from '../../../api/ApiEndpoints';
import { AuthUserContext } from '../../../context/AuthUserContext';
import { useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import {useTranslation} from "react-i18next";

const validationSchema = Yup.object().shape({
    email: Yup.string()
        .min(5, 'Ilgis turi buti ne mazesnis nei 5')
        .required()
        //.email()
        .matches(/^(.+)@(.+)$/, 'email neatitinka standarto'),
    password: Yup.string()
        .min(4, 'Slaptazodzio ilgis turi buti >= 6')
        .required(),
});

const LoginPage = () => {
    const { putAuthUser } = useContext(AuthUserContext);
    const navigate = useNavigate();
    const { t } = useTranslation('user');
    const postLogin = (login, helper) => {
        loginEndpoint({
            username: login.email,
            password: login.password,
        })
            .then(({ data }) => {
                putAuthUser(data);
                navigate('/');
            })
            .catch((error) => console.log(error))
            .finally(() => helper.setSubmitting(false));
    };

    return (
        <Formik
            initialValues={{
                email: '',
                password: '',
            }}
            onSubmit={postLogin}
            validationSchema={validationSchema}
        >
            {(props) => {
                return (
                    <Container>
                        <Form>
                            <Field
                                name="email"
                                labelText={t("email")}
                                type="text"
                                component={FormikFieldInputGroup}
                            />
                            <Field
                                name="password"
                                labelText={t("password")}
                                type="password"
                                component={FormikFieldInputGroup}
                            />

                            <div className="text-center">
                                {props.isSubmitting ? (
                                    <Button variant="primary" disabled>
                                        <Spinner
                                            as="span"
                                            animation="grow"
                                            size="sm"
                                            role="status"
                                            aria-hidden="true"
                                        />
                                        Processing...
                                    </Button>
                                ) : (
                                    <Button type="submit" variant="primary">
                                        {t("common:buttons.submit")}
                                    </Button>
                                )}
                            </div>
                        </Form>
                    </Container>
                );
            }}
        </Formik>
    );
};

export default LoginPage;
