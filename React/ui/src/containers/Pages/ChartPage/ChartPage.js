import { useParams } from 'react-router-dom';

const ChartPage = () => {
    const { chartId } = useParams();
    return <h1>Anestezijos lapo id: {chartId}</h1>;
};

export default ChartPage;
