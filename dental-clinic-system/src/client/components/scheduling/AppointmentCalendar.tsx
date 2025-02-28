import React from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'react-big-calendar/lib/css/react-big-calendar.css';

const localizer = momentLocalizer(moment);

const AppointmentCalendar = () => {
    const [appointments, setAppointments] = React.useState([]);

    const fetchAppointments = async () => {
        // Fetch appointments from the API
        const response = await fetch('/api/appointments');
        const data = await response.json();
        setAppointments(data);
    };

    React.useEffect(() => {
        fetchAppointments();
    }, []);

    const events = appointments.map(appointment => ({
        title: appointment.title,
        start: new Date(appointment.start),
        end: new Date(appointment.end),
        allDay: appointment.allDay,
    }));

    return (
        <div>
            <h2>Appointment Calendar</h2>
            <Calendar
                localizer={localizer}
                events={events}
                startAccessor="start"
                endAccessor="end"
                style={{ height: 500, margin: '50px' }}
            />
        </div>
    );
};

export default AppointmentCalendar;