import { useState } from 'react';

const Chart = () => {
    const [chart, setChart] = useState({
        name: '',
        surname: '',
        hospitalNumber: '',
        dob: '',
        operation: '',
    });

    const handleChange = (e) => {
        setChart({
            ...chart,
            [e.target.name]: e.target.value,
        });
    };

    const onSubmit = (e) => {
        e.preventDefault();

        console.log(chart);
    };

    return (
        <form onSubmit={onSubmit}>
            <div>
                <label htmlFor="name">Name:</label>
                <input
                    name="name"
                    id="name"
                    value={chart.name}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label htmlFor="surname">Surname:</label>
                <input
                    name="surname"
                    id="surname"
                    value={chart.surname}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label htmlFor="hospitalNumber">Hospital Number:</label>
                <input
                    name="hospitalNumber"
                    id="hospitalNumber"
                    value={chart.hospitalNumber}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label htmlFor="dob">Date of Birth:</label>
                <textarea
                    name="dob"
                    id="dob"
                    value={chart.dob}
                    onChange={handleChange}
                />
            </div>

            <div>
                <label htmlFor="operation">Operation:</label>
                <textarea
                    name="operation"
                    id="operation"
                    value={chart.operation}
                    onChange={handleChange}
                />
            </div>

            <button type="submit">Submit</button>
        </form>
    );
};

export default Chart;
