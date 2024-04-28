import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ReporteTiempoPromedio() {
    const [reporte, setReporte] = useState([]);

    useEffect(() => {
        const obtenerReporteTiempoPromedio = async () => {
            try {
                const response = await axios.get('http://localhost:8090/api/historialreparaciones/reporte/marcas-vs-tiempo-promedio');
                setReporte(response.data);
            } catch (error) {
                console.error('Error al obtener los datos:', error);
            }
        };

        obtenerReporteTiempoPromedio();
    }, []);

    return (
        <div>
            <h2>Reporte de Tiempo Promedio de Reparaciones por Marca</h2>
            <table>
                <thead>
                    <tr>
                        <th>Marca</th>
                        <th>Tiempo Promedio (días)</th>
                    </tr>
                </thead>
                <tbody>
                    {reporte.map(item => (
                        <tr key={item.marcaAutomovil}>
                            <td>{item.marcaAutomovil}</td>
                            <td>{item.tiempoEnDias}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default ReporteTiempoPromedio;
