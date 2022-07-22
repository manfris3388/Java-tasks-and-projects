import { useParams } from 'react-router-dom';

const ChartPage = () => {
    const { chartId } = useParams(); //destruktinam productId is url
    return <h1>Anestezijos lapo id: {chartId}</h1>;
};

export default ChartPage;

