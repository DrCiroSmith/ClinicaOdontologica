import React from 'react';
import Layout from './shared/Layout';
import AppointmentCalendar from './scheduling/AppointmentCalendar';
import DynamicScheduler from './scheduling/DynamicScheduler';
import BatchProcessing from './radiography/BatchProcessing';
import RadiographViewer from './radiography/RadiographViewer';
import CancellationPolicy from './scheduling/CancellationPolicy';

const Dashboard: React.FC = () => {
    return (
        <Layout>
            <h1>Dental Clinic Dashboard</h1>
            <section>
                <h2>Radiograph Management</h2>
                <BatchProcessing />
                <RadiographViewer />
            </section>
            <section>
                <h2>Appointment Scheduling</h2>
                <AppointmentCalendar />
                <DynamicScheduler />
                <CancellationPolicy />
            </section>
        </Layout>
    );
};

export default Dashboard;