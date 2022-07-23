import HTTP from './AxiosConfig';

const getChartsApi = (chartData) =>
    HTTP.get('/charts', chartData)
        .finally(response =>
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve(response);
                }, 3000);
            })
        );

const postChartsApi = () => HTTP.post('/charts');

export {getChartsApi}