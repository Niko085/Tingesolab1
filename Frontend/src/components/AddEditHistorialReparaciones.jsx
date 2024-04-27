import { useState, useEffect } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";
import automovilService from "../services/automovil.service";
import historialReparacionesService from "../services/historialReparaciones.service";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import FormControl from "@mui/material/FormControl";
import MenuItem from "@mui/material/MenuItem";
import SaveIcon from "@mui/icons-material/Save";

const AddEditHistorialReparaciones = () => {
  //Esto es para poder escribir en el formulario
  const [patente, setPatente] = useState("");
  const [marca, setMarca] = useState("");
  const [modelo, setModelo] = useState("");
  const [tipo, setTipo] = useState("");
  const [anioFabricacion, setAnioFabricacion] = useState("");
  const [motor, setMotor] = useState("");
  const [cantAsientos, setCantAsientos] = useState("");
  const [kilometraje, setKilometraje] = useState("");
  const { id } = useParams();
  const [titleAutomovilForm, setTitleAutomovilForm] = useState("");
  const navigate = useNavigate();

  const saveHistorial = (a) => {
    a.preventDefault();

    //Objeto con los datos del auto
    const automovil = { patente, marca, modelo, tipo, anioFabricacion, motor, cantAsientos, kilometraje, id };
    //Se verifica si el auto existe para actualizar o crear
    if (id) {
      //Actualizar Datos Automovil
      automovilService
        .update(automovil)
        .then((response) => {
          console.log("El eutomovil ha sido actualizado.", response.data);
          navigate("/automovil/list");
        })
        .catch((error) => {
          console.log(
            "Ha ocurrido un error al intentar actualizar datos del automovil.",
            error
          );
        });
    } else {
      //Crear nuevo Automovil
      automovilService
        .create(automovil)
        .then((response) => {
          console.log("El automovil ha sido añadido.", response.data);
          navigate("/automovil/list");
        })
        .catch((error) => {
          console.log(
            "Ha ocurrido un error al intentar crear un nuevo automovil.",
            error
          );
        });
    }
  };

  useEffect(() => {
    if (id) {
      setTitleAutomovilForm("Editar Automovil");
      automovilService
        .get(id)
        .then((automovil) => {
          //Se establecen los valores del auto en el formulario
          setPatente(automovil.data.patente);
          setMarca(automovil.data.marca);
          setModelo(automovil.data.modelo);
          setTipo(automovil.data.tipo);
          setAnioFabricacion(automovil.data.anioFabricacion);
          setMotor(automovil.data.motor);
          setCantAsientos(automovil.data.cantAsientos);
          setKilometraje(automovil.data.kilometraje);
        })
        .catch((error) => {
          console.log("Se ha producido un error.", error);
        });
    } else {
      setTitleAutomovilForm("Nuevo Automovil");
    }
  }, []);

  //Estilo del formulario
  return (
    //Recuadro
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
      <h3>{titleAutomovilForm}</h3>
      <hr />
      <form>
        <FormControl fullWidth>
          <TextField
            id="patente"
            label="Patente"
            value={patente}
            variant="standard"
            onChange={(a) => setPatente(a.target.value)}
            helperText="Ej: CFTF45"
          />
        </FormControl>
  
        <FormControl fullWidth>
          <TextField
            id="marca"
            label="Marca"
            value={marca}
            variant="standard"
            onChange={(a) => setMarca(a.target.value)}
            helperText="Ej: Hyundai"
          />
        </FormControl>
  
        <FormControl fullWidth>
          <TextField
            id="modelo"
            label="Modelo"
            value={modelo}
            variant="standard"
            onChange={(a) => setModelo(a.target.value)}
            helperText="Ej: Getz"
          />
        </FormControl>
  
        <FormControl fullWidth>
          <TextField
            id="anioFabricacion"
            label="Año de fabricación"
            type="number"
            value={anioFabricacion}
            variant="standard"
            inputProps={{ min: "0" }} // Establece el valor mínimo permitido como 0
            onChange={(a) => setAnioFabricacion(a.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="cantAsientos"
            label="Cantidad de asientos"
            type="number"
            value={cantAsientos}
            variant="standard"
            inputProps={{ min: "0" }}
            onChange={(a) => setCantAsientos(a.target.value)}
          />
        </FormControl>
  
        <FormControl fullWidth>
          <TextField
            id="kilometraje"
            label="Kilometraje"
            type="number"
            value={kilometraje}
            variant="standard"
            inputProps={{ min: "0" }} 
            onChange={(a) => setKilometraje(a.target.value)}
            helperText="Ej: 120000"
          />
        </FormControl>

        <div style={{ display: "flex", gap: "2rem" }}>
          <FormControl fullWidth>
            <TextField
              id="tipo"
              label="Tipo de automóvil"
              value={tipo}
              select
              variant="standard"
              defaultValue="Sedan"
              onChange={(a) => setTipo(a.target.value)}
              style={{ flex: 1 }}
            >
              <MenuItem value={"Sedan"}>Sedán</MenuItem>
              <MenuItem value={"Hatchback"}>Hatchback</MenuItem>
              <MenuItem value={"Suv"}>SUV</MenuItem>
              <MenuItem value={"Pickup"}>Pickup</MenuItem>
              <MenuItem value={"Furgoneta"}>Furgoneta</MenuItem>
            </TextField>
          </FormControl>

          <FormControl fullWidth>
            <TextField
              id="motor"
              label="Tipo de motor"
              value={motor}
              select
              variant="standard"
              defaultValue="Gasolina"
              onChange={(a) => setMotor(a.target.value)}
              style={{ flex: 1 }}
            >
              <MenuItem value={"Gasolina"}>Gasolina</MenuItem>
              <MenuItem value={"Diesel"}>Diésel</MenuItem>
              <MenuItem value={"Hibrido"}>Híbrido</MenuItem>
              <MenuItem value={"Electrico"}>Eléctrico</MenuItem>
            </TextField>
          </FormControl>
        </div>

        <FormControl>
          <br />
          <Button
            variant="contained"
            color="info"
            onClick={(a) => saveAutomovil(a)}
            style={{ marginLeft: "0.5rem" }}
            startIcon={<SaveIcon />}
          >
            Guardar
          </Button>
        </FormControl>
      </form>
      <hr />
      <Link to="/historialReparaciones/list">Volver a la lista de automoviles</Link>
    </Box>
  );  
};

export default AddEditHistorialReparaciones;
