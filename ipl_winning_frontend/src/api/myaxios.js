import axios from 'axios';
import axiosObject from './axiosInterceptor';
const baseUrl = "http://localhost:9090";

export const signup = async (val) => {
    const res = await axios({
        method: 'POST',
        url: `${baseUrl}/signup`,
        data: val
    });
    return res;
};

export const login = async (val) => {
    const res = await axios({
        method: 'post',
        url: `${baseUrl}/authenticate`,
        data: val
    });
    return res;
};

export const fetchTodayMatch = () => {
    const promise = axiosObject.get('fetch-today-match');
    const dataPromise = promise.then((response) => response);
    return dataPromise;
};
export const fetchAllMatch = () => {

    const promise = axiosObject.get('/fetch-all-match');// axios.get(`${baseUrl}/fetch-all-match`);
    const dataPromise = promise.then((response) => response);
    return dataPromise;
};
export const fetchUserById = (userId) => {
    const promise = axiosObject.post(`/get-user/${userId}`);
    const dataPromise = promise.then((response) => response);
    return dataPromise;
}
export const guessTheWinner = (elementId, userId) => {
    const promise = axiosObject.post(`/guess-the-winner/${elementId}/${userId}`);
    const dataPromise = promise.then((response) => response);
    return dataPromise;
}