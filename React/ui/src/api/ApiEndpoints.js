import HTTP from './AxiosConfig';

const getChartsEndpoint = (chartData) =>
    HTTP.get('/charts', chartData).finally(
        (response) =>
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve(response);
                }, 2000);
            })
    );

const postChartsEndpoint = () => HTTP.post('/charts');

export { getChartsEndpoint };
