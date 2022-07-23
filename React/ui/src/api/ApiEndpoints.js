import HTTP from './AxiosConfig';

const getChartsApi = () => HTTP.get('/charts');

const createProductApi = (productData) =>
    HTTP.post('/charts', productData)
        .finally(response =>
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve(response);
                }, 3000);
            })
        );

export {getChartsApi}