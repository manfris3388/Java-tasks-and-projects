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

    const [visible, setVisible] = useState(false);

    const handleChange = (e) => {
        setChart({
            ...chart,
            [e.target.name]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();
        console.log(chart);
        setVisible(true);
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
                <Button variant='primary' type='submit'>
                    Submit
                </Button>
            </Form>
            { visible &&
                <>
                    <hr/>
                    <div>
                        Sukurtas anestezijos lapas:
                        <div>{chart.name}</div>
                        <div>{chart.surname}</div>
                        <div>{chart.hospitalNumber}</div>
                        <div>{chart.dob}</div>
                        <div>{chart.operation}</div>
                    </div>
                </>
            }
        </Container>
    );
};

export default NewChartPage;
