import api from "../api/axiosConfig";

export const signup = async (userData) => {

    const response = await api.post(
        "/api/auth/signup",
        userData
    );

    return response.data;

};