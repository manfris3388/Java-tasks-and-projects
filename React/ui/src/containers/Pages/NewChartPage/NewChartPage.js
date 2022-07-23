import { useState } from 'react';
import {Button, Container, Form} from "react-bootstrap";

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
                <Form.Group className='mb-3' controlId='name'>
                    <Form.Label>Patient's name</Form.Label>
                    <Form.Control placeholder='Write name'
                                  name="name"
                                  onChange={handleChange} />
                </Form.Group>

                <Form.Group className='mb-3' controlId='surname'>
                    <Form.Label>Patient's surname</Form.Label>
                    <Form.Control placeholder='Write surname'
                                  name="surname"
                                  onChange={handleChange} />
                </Form.Group>

                <Form.Group className='mb-3' controlId='hospitalNumber'>
                    <Form.Label>Hospital number</Form.Label>
                    <Form.Control placeholder='Write hospital number'
                                  name="hospitalNumber"
                                  onChange={handleChange} />
                </Form.Group>

                <Form.Group className='mb-3' controlId='dob'>
                    <Form.Label>Date of birth</Form.Label>
                    <Form.Control placeholder='Write date of birth'
                                  name="dob"
                                  onChange={handleChange} />
                </Form.Group>

                <Form.Group className='mb-3' controlId='operation'>
                    <Form.Label>Operation</Form.Label>
                    <Form.Control placeholder='Write the type of operation'
                                  name="operation"
                                  onChange={handleChange} />
                </Form.Group>

                <Button variant='primary' type='submit'>
                    Submit
                </Button>
            </Form>
        </Container>
    );
};

export default NewChartPage;
