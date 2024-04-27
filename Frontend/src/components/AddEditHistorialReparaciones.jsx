import React, { useState, useEffect } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";
import Box from "@mui/material/Box";
import historialReparacionesService from "../services/historialReparaciones.service";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import FormControl from "@mui/material/FormControl";
import MenuItem from "@mui/material/MenuItem";
import SaveIcon from "@mui/icons-material/Save";

const AddEditHistorialReparaciones = () => {
  const [fechaIngresoTaller, setFechaIngresoTaller] = useState("");
  const [horaIngresoTaller, setHoraIngresoTaller] = useState("");
  const [montoTotalPagar, setMontoTotalPagar] = useState("");
  const [recargos, setRecargos] = useState("");

  const { id } = useParams();
  const [titleHistorialReparacionesForm, setTitleHistorialReparacionesForm] = useState("");
  const navigate = useNavigate();

  const saveHistorial = (e) => {
    e.preventDefault();

    const historialReparaciones = {
      fechaIngresoTaller,
      horaIngresoTaller,
      montoTotalPagar,
      recargos,

      id
    };

    if (id) {
      historialReparacionesService
        .update(historialReparaciones)
        .then((response) => {
          console.log("El Historial de Reparaciones ha sido actualizado.", response.data);
          navigate("/historialreparaciones/list");
        })
        .catch((error) => {
          console.log("Ha ocurrido un error al intentar actualizar datos del historial de reparaciones.", error);
        });
    } else {
      historialReparacionesService
        .create(historialReparaciones)
        .then((response) => {
          console.log("El historial de reparaciones ha sido añadido.", response.data);
          navigate("/historialreparaciones/list");
        })
        .catch((error) => {
          console.log("Ha ocurrido un error al intentar crear un nuevo historial de reparaciones.", error);
        });
    }
  };

  useEffect(() => {
    if (id) {
      setTitleHistorialReparacionesForm("Editar Historial de Reparaciones");
      historialReparacionesService
        .get(id)
        .then((historialReparaciones) => {
          setFechaIngresoTaller(historialReparaciones.data.fechaIngresoTaller);
          setHoraIngresoTaller(historialReparaciones.data.horaIngresoTaller);
          setMontoTotalPagar(historialReparaciones.data.montoTotalPagar);
          setRecargos(historialReparaciones.data.recargos);
  
        })
        .catch((error) => {
          console.log("Se ha producido un error.", error);
        });
    } else {
      setTitleHistorialReparacionesForm("Nuevo Historial de Reparaciones");
    }
  }, [id]);
  
  
  return (
    <Box
      display="flex"
      flexDirection="column"
      alignItems="center"
      justifyContent="center"
      component="form"
      sx={{
        padding: "20px",
        borderRadius: "25px",
        boxShadow: "0px 0px 100px rgba(0, 0, 0, 0.3)",
        backgroundColor: "#f9f9f9",
        maxWidth: "650px",
        margin: "auto",
        marginTop: "30px",
      }}
    >
      <h3>{titleHistorialReparacionesForm}</h3>
      <hr />
      <form>
        <FormControl fullWidth>
          <TextField
            id="fechaIngresoTaller"
            label="Fecha de ingreso al taller"
            type="date"
            value={fechaIngresoTaller}
            onChange={(e) => setFechaIngresoTaller(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="horaIngresoTaller"
            label="Hora de ingreso al taller"
            type="time"
            value={horaIngresoTaller}
            onChange={(e) => setHoraIngresoTaller(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="montoTotalPagar"
            label="Monto total a pagar"
            type="number"
            value={montoTotalPagar}
            onChange={(e) => setMontoTotalPagar(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="recargos"
            label="Recargos"
            type="number"
            value={recargos}
            onChange={(e) => setRecargos(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="descuentos"
            label="Descuentos"
            type="number"
            value={descuentos}
            onChange={(e) => setDescuentos(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="iva"
            label="IVA"
            type="number"
            value={iva}
            onChange={(e) => setIva(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="fechaSalidaTaller"
            label="Fecha de salida del taller"
            type="date"
            value={fechaSalidaTaller}
            onChange={(e) => setFechaSalidaTaller(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="horaSalidaTaller"
            label="Hora de salida del taller"
            type="time"
            value={horaSalidaTaller}
            onChange={(e) => setHoraSalidaTaller(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="fechaClienteSeLlevaVehiculo"
            label="Fecha en que el cliente se lleva el vehículo"
            type="date"
            value={fechaClienteSeLlevaVehiculo}
            onChange={(e) => setFechaClienteSeLlevaVehiculo(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="horaClienteSeLlevaVehiculo"
            label="Hora en que el cliente se lleva el vehículo"
            type="time"
            value={horaClienteSeLlevaVehiculo}
            onChange={(e) => setHoraClienteSeLlevaVehiculo(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="pagado"
            label="Pagado"
            select
            value={pagado}
            onChange={(e) => setPagado(e.target.value)}
          >
            <MenuItem value={true}>Sí</MenuItem>
            <MenuItem value={false}>No</MenuItem>
          </TextField>
        </FormControl>

        <FormControl>
          <br />
          <Button
            variant="contained"
            color="info"
            onClick={(e) => saveHistorial(e)}
            style={{ marginLeft: "0.5rem" }}
            startIcon={<SaveIcon />}
          >
            Guardar
          </Button>
        </FormControl>
      </form>
      <hr />
      <Link to="/historialreparaciones/list">Volver a la lista de historial de reparaciones</Link>
    </Box>
  );
};

export default AddEditHistorialReparaciones;
