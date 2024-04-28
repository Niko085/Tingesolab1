// SeleccionarReparacion.jsx

import React, { useState } from "react";
import axios from "axios";

const SeleccionarReparacion = ({ historialReparacionId }) => {
  const [selectedReparacion, setSelectedReparacion] = useState("");

  const fetchReparaciones = async () => {
    try {
      const response = await axios.get(`http://localhost:8090/api/reparaciones?historialId=${historialReparacionIdd}`);
      setReparaciones(response.data);
    } catch (error) {
      console.error("Error al cargar reparaciones:", error);
    }
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    // Crear una nueva reparación con el tipo seleccionado y el ID del historial de reparaciones
    const nuevaReparacion = {
      tipoReparacion: parseInt(selectedReparacion), // Convertir a entero si es necesario
      idHistorialReparaciones: historialReparacionIdd,
      patente: "a" // Aquí deberías establecer la patente adecuada si es necesario
    };
    try {
      // Enviar la nueva reparación al backend
      const response = await axios.post("http://localhost:8090/api/reparaciones/", nuevaReparacion);
      console.log("Reparación guardada con éxito:", response.data);
    } catch (error) {
      console.error("Error al guardar la reparación:", error);
    }
  };

  return (
    <div>
      <h1>Seleccionar Reparación</h1>
      <p>Historial de Reparación ID: {historialReparacionId}</p>
      <form onSubmit={handleSubmit}>
        <label>
          Seleccione una reparación:
          <select value={selectedReparacion} onChange={(e) => setSelectedReparacion(e.target.value)}>
            <option value="">Seleccione...</option>
            {[...Array(11)].map((_, index) => (
              <option key={index + 1} value={index + 1}>
                {index + 1}
              </option>
            ))}
          </select>
        </label>
        <button type="submit">Seleccionar</button>
      </form>
    </div>
  );
};

export default SeleccionarReparacion;
