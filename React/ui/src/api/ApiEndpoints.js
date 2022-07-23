import HTTP from './AxiosConfig';

const getChartsApi = () => HTTP.get('/charts');

const createProductApi = (productData) => HTTP.post('/charts', productData);

export {getChartsApi}