
import { useEffect } from 'react';
import {getChartsApi} from "../../../api/ApiEndpoints";

const ChartsPage = () => {

    useEffect(() => {
        getChartsApi()
            .then((response) => console.log('response', response))
            .catch((error) => console.log('error', error))
    })

    return (
        <>
            <h1>Charts list</h1>
        </>
    )
}

export default ChartsPage;
