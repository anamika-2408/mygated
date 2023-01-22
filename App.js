import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import GuestListing from './GuestListing';
import GuestCreate from './GuestCreate';
import GuestDetail from './GuestDetail';
import GuestEdit from './GuestEdit';

function App() {
  return (
    <div className="App">
      <h1>React JS CRUD Opertations</h1>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<GuestListing />}></Route>
          <Route path='/Guest/create' element={<GuestCreate />}></Route>

          <Route path='http://localhost:8080/society/Guest/detail/:id' element={<GuestDetail />}></Route>
          <Route path='http://localhost:8080/society/Guest/edit/:id' element={<GuestEdit />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );

}

export default App;