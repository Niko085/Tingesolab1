import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import historialReparacionesService from "../services/historialReparaciones.service";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";

const HistorialesReparacionesList = () => {
  const [HistorialReparaciones, setHistorialReparaciones] = useState([]);

  const navigate = useNavigate();

  const init = () => {
    historialReparacionesServiceService
      .getAll()
      .then((response) => {
        console.log("Mostrando listado de todos los historiales de reparación de automoviles.", response.data);
        setHistorialReparaciones(response.data);
      })
      .catch((error) => {
        console.log(
          "Se ha producido un error al intentar mostrar listado de todos los historiales de reparación de automoviles.",
          error
        );
      });
  };

  useEffect(() => {
    init();
  }, []);

  const handleDelete = (id) => {
    console.log("Printing id", id);
    const confirmDelete = window.confirm(
      "¿Esta seguro que desea borrar este historial?"
    );
    if (confirmDelete) {
      historialReparacionesServiceService
        .remove(id)
        .then((response) => {
          console.log("El historial ha sido eliminado.", response.data);
          init();
        })
        .catch((error) => {
          console.log(
            "Se ha producido un error al intentar eliminar el automovil",
            error
          );
        });
    }
  };

  const handleEdit = (id) => {
    console.log("Printing id", id);
    navigate(`/historialReparaciones/edit/${id}`);
  };

  return (
    <TableContainer component={Paper}>
      <br />
      <Link
        to="/historialReparaciones/add"
        style={{ textDecoration: "none", marginBottom: "1rem" }}
      >
        <Button
          variant="contained"
          color="primary"
          startIcon={<PersonAddIcon />}
        >
          Ingresar automovil
        </Button>
      </Link>
      <br /> <br />
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              Patente
            </TableCell>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              Marca
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Modelo
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Tipo de auto
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Año de fabricación
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Tipo de motor
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Tipo cantidad de asientos
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Kilometraje
            </TableCell>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              Operaciones
            </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {historialesReparaciones.map((historialReparaciones) => (
            <TableRow
              key={historialReparaciones.id}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell align="left">{historialReparaciones.fechaIngresoTaller}</TableCell>
              <TableCell align="left">{historialReparaciones.horaIngresoTaller}</TableCell>
              <TableCell align="right">{historialReparaciones.fechaSalidaTaller}</TableCell>
              <TableCell align="right">{historialReparaciones.horaSalidaTaller}</TableCell>
              <TableCell align="right">{historialReparaciones.anioFabricacion}</TableCell>
              <TableCell align="right">{historialReparaciones.fechaClienteSeLlevaVehiculo}</TableCell>
              <TableCell align="right">{historialReparaciones.horaClienteSeLlevaVehiculo}</TableCell>
              <TableCell align="right">{historialReparaciones.recargos}</TableCell>
              <TableCell align="right">{historialReparaciones.descuentos}</TableCell>
              <TableCell align="right">{historialReparaciones.iva}</TableCell>
              <TableCell align="right">{historialReparaciones.montoTotalPagar}</TableCell>
              <TableCell>
                <Button
                //variant es el recuadro en azul
                  variant="contained"
                  color="info"
                  size="small"
                  onClick={() => handleEdit(historialReparaciones.id)}
                  style={{ marginLeft: "0.5rem" }}
                  startIcon={<EditIcon />}
                >
                  Editar
                </Button>

                <Button
                  variant="contained"
                  color="error"
                  size="small"
                  onClick={() => handleDelete(historialReparaciones.id)}
                  style={{ marginLeft: "0.5rem" }}
                  startIcon={<DeleteIcon />}
                >
                  Eliminar
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default HistorialesReparacionesList;
