import { useState } from 'react';
import {Button, Container, Form} from "react-bootstrap";
import FormTemplate from "../../../components/FormTemplate/FormTemplate";

const NewChartPage = () => {
    const [chart, setChart] = useState({
        name: '',
        surname: '',
        hospitalNumber: '',
        dob: '',
        operation: '',
    });

    const handleChange = (e) => {
        setChart({
            ...chart,
            [e.target.name]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();

        console.log(chart);
    };

    return (
        <Container>
            <Form onSubmit={onSubmit}>
                <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write name"
                    name="name"
                    labelText="Patient's name"
                />
                <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write surname"
                    name="surname"
                    labelText="Patient's surname"
                />
                 <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write hospital number"
                    name="hospitalNumber"
                    labelText="Patient's hospital number"
                />
                 <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write date of birth"
                    name="dob"
                    labelText="Patient's date of birth"
                />
                 <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write operation"
                    name="operation"
                    labelText="Patient's operation"
                />
                 <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText="Write operation"
                    name="operation"
                    labelText="Patient's operation"
                />
                <Button variant='primary' type='submit'>
                    Submit
                </Button>
            </Form>
        </Container>
    );
};

export default NewChartPage;
