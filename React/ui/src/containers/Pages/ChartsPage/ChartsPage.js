
import {useEffect, useState} from 'react';
import {getChartsApi} from "../../../api/ApiEndpoints";
import {Card, Col, Container, Row, Spinner} from 'react-bootstrap';

const ChartsPage = () => {

    const [chartFields, setChartFields] = useState([])
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        getChartsApi()
            .then(({data}) => {
                setChartFields(data.charts)
            })
            .catch((error) => console.log('error', error))
            .finally(() => setLoading(false));
    },[])

    return (
        <Container fluid>
            <h1 className={"text-center"}>Charts list</h1>
            <Row xs={1} md={2} className="g-4">
                {loading
                    ? <Spinner className="text-center" animation='border' />:
                chartFields.map(chart => (
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
