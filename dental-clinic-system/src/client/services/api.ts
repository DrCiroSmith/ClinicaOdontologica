import axios from 'axios';

const API_BASE_URL = 'http://localhost:5000/api';

export const fetchAppointments = async () => {
    const response = await axios.get(`${API_BASE_URL}/appointments`);
    return response.data;
};

export const createAppointment = async (appointmentData) => {
    const response = await axios.post(`${API_BASE_URL}/appointments`, appointmentData);
    return response.data;
};

export const fetchRadiographs = async () => {
    const response = await axios.get(`${API_BASE_URL}/radiographs`);
    return response.data;
};

export const uploadRadiographs = async (formData) => {
    const response = await axios.post(`${API_BASE_URL}/radiographs/upload`, formData, {
        headers: {
            'Content-Type': 'multipart/form-data',
        },
    });
    return response.data;
};

export const fetchPatients = async () => {
    const response = await axios.get(`${API_BASE_URL}/patients`);
    return response.data;
};

export const createPatient = async (patientData) => {
    const response = await axios.post(`${API_BASE_URL}/patients`, patientData);
    return response.data;
};