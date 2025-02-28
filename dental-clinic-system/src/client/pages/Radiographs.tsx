import React, { useEffect, useState } from 'react';
import { fetchRadiographs } from '../services/api';
import { Radiograph } from '../../shared/types/radiograph';

const Radiographs: React.FC = () => {
    const [radiographs, setRadiographs] = useState<Radiograph[]>([]);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const loadRadiographs = async () => {
            try {
                const data = await fetchRadiographs();
                setRadiographs(data);
            } catch (err) {
                setError('Failed to load radiographs');
            } finally {
                setLoading(false);
            }
        };

        loadRadiographs();
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>{error}</div>;
    }

    return (
        <div>
            <h1>Radiographs</h1>
            <ul>
                {radiographs.map((radiograph) => (
                    <li key={radiograph.id}>
                        <h2>{radiograph.title}</h2>
                        <p>Status: {radiograph.status}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Radiographs;