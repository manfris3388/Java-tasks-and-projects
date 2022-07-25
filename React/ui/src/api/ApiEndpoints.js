import HTTP from './AxiosConfig';

const getChartsEndpoint = (chartData) =>
    HTTP.get('/api/charts', chartData).finally(
        (response) =>
            new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve(response);
                }, 2000);
            })
    );

const postChartsEndpoint = () => HTTP.post('/api/charts');

/**
 * i.e. loginData:
 * {
 *     username: string;
 *     password: string;
 * }
 * @param loginData
 * @returns {Promise<AxiosResponse<any>>}
 */
const loginEndpoint = (loginData) => HTTP.post('/login', loginData);

export { getChartsEndpoint, loginEndpoint };
