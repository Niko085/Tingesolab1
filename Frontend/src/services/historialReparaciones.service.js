import httpClient from "../http-common";

const getAll = () => {
    return httpClient.get('/api/historialreparaciones/');
}

const create = data => {
    return httpClient.post("/api/historialreparaciones/", data);
}

const get = id => {
    return httpClient.get(`/api/historialreparaciones/${id}`);
}

const update = data => {
    return httpClient.put('/api/historialreparaciones/', data);
}

const remove = id => {
    return httpClient.delete(`/api/historialreparaciones/${id}`);
}

function obtenerReporteTiempoPromedio() {
    return axios.get('/api/historialreparaciones/reporte/marcas-vs-tiempo-promedio');
}



export default { getAll, create, get, update, remove , obtenerReporteTiempoPromedio};