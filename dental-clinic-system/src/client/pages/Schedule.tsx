import React, { useEffect, useState } from 'react';
import AppointmentCalendar from '../components/scheduling/AppointmentCalendar';
import DynamicScheduler from '../components/scheduling/DynamicScheduler';
import CancellationPolicy from '../components/scheduling/CancellationPolicy';
import { fetchAppointments } from '../services/api';

const Schedule: React.FC = () => {
    const [appointments, setAppointments] = useState([]);

    useEffect(() => {
        const loadAppointments = async () => {
            const data = await fetchAppointments();
            setAppointments(data);
        };

        loadAppointments();
    }, []);

    return (
        <div>
            <h1>Manage Appointments</h1>
            <AppointmentCalendar appointments={appointments} />
            <DynamicScheduler appointments={appointments} />
            <CancellationPolicy />
        </div>
    );
};

export default Schedule;