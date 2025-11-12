import './App.css';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListEmployee from './components/ListEmployee';
import 'bootstrap/dist/css/bootstrap.min.css';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployee from './components/UpdateEmployee';
function App() {
  return (
    <div >
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path='/' element={<ListEmployee />} />
          <Route path='/employees' element={<ListEmployee />} />
          <Route path='add-employee' element={<CreateEmployeeComponent/>}/>
          <Route path='update-employee/:id' element={<UpdateEmployee/>}/>
        </Routes>
        <FooterComponent />
      </BrowserRouter>
    </div>
  );
}

export default App;
