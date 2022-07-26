import { useContext, useState } from 'react';
import { Button, Container, Form } from 'react-bootstrap';
import FormTemplate from '../../../components/FormTemplate/FormTemplate';
import { AuthUserContext } from '../../../context/AuthUserContext';
import { postChartsEndpoint } from '../../../api/ApiEndpoints';
import { useTranslation } from 'react-i18next';

const NewChartPage = () => {
    const [chart, setChart] = useState({
        name: '',
        surname: '',
        hospitalNumber: '',
        dob: '',
        operation: '',
    });

    const [visible, setVisible] = useState(false);

    const { authUser } = useContext(AuthUserContext);

    const { t } = useTranslation('chartForm');

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

        postChartsEndpoint(chart).then((response) => setVisible(true));
    };

    return (
        <Container>
            <Form onSubmit={onSubmit}>
                <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t('placeholders.name')}
                    name="name"
                    labelText={t('labels.name')}
                />
                <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t('placeholders.surname')}
                    name="surname"
                    labelText={t('labels.surname')}
                />
                <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t('placeholders.hospitalNumber')}
                    name="hospitalNumber"
                    labelText={t('labels.hospitalNumber')}
                />
                <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t('placeholders.dob')}
                    name="dob"
                    labelText={t('labels.dob')}
                />
                <FormTemplate
                    className="mb-3"
                    onChange={handleChange}
                    placeholderText={t('placeholders.operation')}
                    name="operation"
                    labelText={t('labels.operation')}
                />
                <Button variant="primary" type="submit">
                    {t('common:buttons.submit')}
                </Button>
            </Form>
            {createChartInfo()}
        </Container>
    );
};

export default NewChartPage;
