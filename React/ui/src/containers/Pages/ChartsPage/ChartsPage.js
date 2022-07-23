
import {useEffect, useState} from 'react';
import {getChartsApi} from "../../../api/ApiEndpoints";
import { Card, Col, Container, Row } from 'react-bootstrap';

const ChartsPage = () => {

    const [chartFields, setChartFields] = useState([])

    useEffect(() => {
        getChartsApi()
            .then(({data}) => {
                console.log('response', data)
                setChartFields(data.charts)
            })
            .catch((error) => console.log('error', error))
    })

    return (
        <Container fluid>
            <h1 className={"text-center"}>Charts list</h1>
            <Row xs={1} md={2} className="g-4">
                {chartFields.map(chart => (
                    <Col key={chart.chartId}>
                        <Card>
                            <Card.Header>
                                <div className="d-flex justify-content-lg-around">
                                    <div>{chart.name}</div>
                                    <div>{chart.surname}</div>
                                </div>
                            </Card.Header>
                            <Card.Body>
                                <Card.Title>{chart.hospitalNumber}</Card.Title>
                                <Card.Text>{chart.dob}</Card.Text>
                                <Card.Text>{chart.operation}</Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    )
}

export default ChartsPage;
