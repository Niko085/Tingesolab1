import './App.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import Navbar from "./components/Navbar"
import Home from './components/Home';
import AutomovilesList from './components/AutomovilesList';
import AddEditAutomovil from './components/AddEditAutomovil';
import NotFound from './components/NotFound';
import HistorialReparacionesList from './components/HistorialReparacionesList';

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
              <Route path="/historialreparaciones/list" element={<HistorialReparacionesList/>} />
              <Route path="*" element={<NotFound/>} />
            </Routes>
          </div>
      </Router>
  );
}

export default App
