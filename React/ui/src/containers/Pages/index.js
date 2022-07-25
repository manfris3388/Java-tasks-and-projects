import { Routes, Route } from 'react-router-dom';
import HomePage from './HomePage/HomePage';
import NewChartPage from './NewChartPage/NewChartPage';
import ChartPage from './ChartPage/ChartPage';
import ChartsPage from './ChartsPage/ChartsPage';
import LoginPage from './LoginPage/LoginPage';

export default () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/charts" element={<ChartsPage />} />
        <Route path="/charts/:chartId" element={<ChartPage />} />
        <Route path="/charts/create" element={<NewChartPage />} />
        <Route path="/login" element={<LoginPage />} />
    </Routes>
);
