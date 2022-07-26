import axios from 'axios';
import { loadFromSessionStorage, StorageKey } from '../utils/SessionStorage';

const HTTP = axios.create({});

HTTP.interceptors.request.use((config) => {
    const jwt = loadFromSessionStorage(StorageKey.jwt);
    // console.log("Before every request jwt", jwt)

    if (jwt) {
        config.headers.authorization = 'Bearer ' + jwt;
    }

    return config;
});
export default HTTP;
