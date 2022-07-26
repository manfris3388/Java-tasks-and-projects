import {useContext, useState} from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import FormTemplate from '../../../components/FormTemplate/FormTemplate';
import {AuthUserContext} from "../../../context/AuthUserContext";
import {postChartsEndpoint} from "../../../api/ApiEndpoints";

const NewChartPage = () => {
    const [chart, setChart] = useState({
        name: '',
        surname: '',
        hospitalNumber: '',
        dob: '',
        operation: '',
    });

    const [visible, setVisible] = useState(false);

    const { authUser } = useContext(AuthUserContext)

    const handleChange = (e) => {
        setChart({
            ...chart,
            [e.target.name]: e.target.value,
        });
    };

    const createChartInfo = () => {
        const { name, surname, hospitalNumber, dob, operation } = chart;
        return (
            visible && (
                <>
                    <hr />
                    <div>
                        Sukurtas anestezijos lapas:
                        <div>{name}</div>
                        <div>{surname}</div>
                        <div>{hospitalNumber}</div>
                        <div>{dob}</div>
                        <div>{operation}</div>
                    </div>
                </>
            )
        );
    };

    const onSubmit = (e) => {
        e.preventDefault();

        postChartsEndpoint(chart)
            .then((response) => setVisible(true))

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
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
            {createChartInfo()}
        </Container>
    );
};

export default NewChartPage;
