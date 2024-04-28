import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import historialReparacionesService from "../services/historialReparaciones.service";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import BuildIcon from "@mui/icons-material/Build";
import axios from "axios";

const HistorialReparacionesList = () => {
  const [historialReparaciones, setHistorialReparaciones] = useState([]);
  const navigate = useNavigate();

  const init = () => {
    historialReparacionesService
      .getAll()
      .then((response) => {
        console.log("Mostrando historial de reparaciones:", response.data);
        setHistorialReparaciones(response.data);
      })
      .catch((error) => {
        console.log("Error al cargar historial de reparaciones:", error);
      });
  };

  useEffect(() => {
    init();
  }, []);

  const handleDelete = (id) => {
    console.log("Eliminando historial de reparaciones con ID:", id);
    const confirmDelete = window.confirm(
      "¿Estás seguro de que deseas eliminar este historial de reparaciones?"
    );
    if (confirmDelete) {
      historialReparacionesService
        .remove(id)
        .then(() => {
          console.log("Historial de reparaciones eliminado con éxito");
          init();
        })
        .catch((error) => {
          console.log("Error al eliminar historial de reparaciones:", error);
        });
    }
  };

  const handleEdit = (id) => {
    console.log("Editando historial de reparaciones con ID:", id);
    navigate(`/historialreparaciones/edit/${id}`);
  };

  const handleCalculate = (patente) => {
    console.log("Calculando historial de reparaciones para la patente:", patente);
    axios
      .get(`http://localhost:8090/api/historialreparaciones/calculate?patente=${patente}`)
      .then(() => {
        console.log("Historial de reparaciones calculado con éxito");
        init(); // Actualiza la lista de historiales después de calcular
      })
      .catch((error) => {
        console.log("Error al calcular historial de reparaciones:", error);
      });
  };

  return (
    <TableContainer component={Paper}>
      <br />
      <Link
        to="/historialreparaciones/add"
        style={{ textDecoration: "none", marginBottom: "1rem" }}
      >
        <Button
          variant="contained"
          color="primary"
          startIcon={<BuildIcon />}
        >
          Añadir Historial de Reparaciones
        </Button>
      </Link>
      <br /> <br />
      <Table sx={{ minWidth: 650 }} size="small" aria-label="historial de reparaciones">
        <TableHead>
          <TableRow>
            <TableCell align="left">Patente</TableCell>
            <TableCell align="left">Fecha Ingreso Taller</TableCell>
            <TableCell align="left">Hora Ingreso Taller</TableCell>
            <TableCell align="right">Monto Total a Pagar</TableCell>
            <TableCell align="right">Recargos</TableCell>
            <TableCell align="right">Descuentos</TableCell>
            <TableCell align="right">IVA</TableCell>
            <TableCell align="left">Fecha Salida Taller</TableCell>
            <TableCell align="left">Hora Salida Taller</TableCell>
            <TableCell align="left">Fecha Cliente se Lleva Vehículo</TableCell>
            <TableCell align="left">Hora Cliente se Lleva Vehículo</TableCell>
            <TableCell align="left">Pagado</TableCell>
            <TableCell align="left">Operaciones</TableCell>
            <TableCell align="left">Calcular</TableCell> {/* Nuevo encabezado de columna */}
          </TableRow>
        </TableHead>
        <TableBody>
          {historialReparaciones.map((historialReparacion) => (
            <TableRow
              key={historialReparacion.id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell align="left">{historialReparacion.patente}</TableCell>
              <TableCell align="left">{historialReparacion.fechaIngresoTaller}</TableCell>
              <TableCell align="left">{historialReparacion.horaIngresoTaller}</TableCell>
              <TableCell align="right">{historialReparacion.montoTotalPagar}</TableCell>
              <TableCell align="right">{historialReparacion.recargos}</TableCell>
              <TableCell align="right">{historialReparacion.descuentos}</TableCell>
              <TableCell align="right">{historialReparacion.iva}</TableCell>
              <TableCell align="left">{historialReparacion.fechaSalidaTaller}</TableCell>
              <TableCell align="left">{historialReparacion.horaSalidaTaller}</TableCell>
              <TableCell align="left">{historialReparacion.fechaClienteSeLlevaVehiculo}</TableCell>
              <TableCell align="left">{historialReparacion.horaClienteSeLlevaVehiculo}</TableCell>
              <TableCell align="left">{historialReparacion.pagado ? 'Sí' : 'No'}</TableCell>
              <TableCell>
                <Button
                  variant="contained"
                  color="info"
                  size="small"
                  onClick={() => handleEdit(historialReparacion.id)}
                  style={{ marginLeft: "0.5rem" }}
                  startIcon={<EditIcon />}
                >
                  Editar
                </Button>

                <Button
                  variant="contained"
                  color="error"
                  size="small"
                  onClick={() => handleDelete(historialReparacion.id)}
                  style={{ marginLeft: "0.5rem" }}
                  startIcon={<DeleteIcon />}
                >
                  Eliminar
                </Button>
              </TableCell>

              <TableCell> {/* Nueva celda para el botón de calcular */}
                <Button
                  variant="contained"
                  color="secondary"
                  size="small"
                  onClick={() => handleCalculate(historialReparacion.patente)}
                  style={{ marginLeft: "0.5rem" }}
                >
                  Calcular
                </Button>
              </TableCell>

            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default HistorialReparacionesList;
