import api from "../api/axiosConfig";

export const signup = async (userData) => {

    const response = await api.post(
        "/api/auth/signup",
        userData
    );

    return response.data;

};

export const login = async (loginData) => {

    const response = await api.post(
        "/api/auth/login",
        loginData
    );

    return response.data;

};