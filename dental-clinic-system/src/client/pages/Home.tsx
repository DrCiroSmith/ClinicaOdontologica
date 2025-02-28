import React from 'react';
import Layout from '../components/shared/Layout';
import Dashboard from '../components/Dashboard';

const Home: React.FC = () => {
    return (
        <Layout>
            <h1>Welcome to the Dental Clinic System</h1>
            <Dashboard />
        </Layout>
    );
};

export default Home;