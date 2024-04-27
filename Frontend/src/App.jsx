import './App.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import Navbar from "./components/Navbar"
import Home from './components/Home';
import AutomovilesList from './components/AutomovilesList';
import AddEditAutomovil from './components/AddEditAutomovil';
import NotFound from './components/NotFound';
import HistorialReparacionesList from './components/HistorialReparacionesList';
import AddEditHistorialReparaciones from './components/AddEditHistorialReparaciones';
import IngresarAutomovil from './components/IngresarAutomovil';

function App() {
  return (
      <Router>
          <div className="container">
          <Navbar></Navbar>
            <Routes>
              <Route path="/" element={<Home/>} />
              <Route path="/home" element={<Home/>} />
              <Route path="/automovil/list" element={<AutomovilesList/>} />
              <Route path="/automovil/add" element={<AddEditAutomovil/>} />
              <Route path="/automovil/edit/:id" element={<AddEditAutomovil/>} />

              <Route path="/historialReparaciones/list" element={<HistorialReparacionesList/>} />
              <Route path="/historialReparaciones/add" element={<AddEditHistorialReparaciones/>} />
              <Route path="/historialReparaciones/edit/:id" element={<AddEditHistorialReparaciones/>} />


              <Route path="/ingresarAutomovil/add" element={<IngresarAutomovil/>} />
              <Route path="/ingresarAutomovil/edit/:id" element={<IngresarAutomovil/>} />
              <Route path="*" element={<NotFound/>} />
            </Routes>
          </div>
      </Router>
  );
}

export default App
