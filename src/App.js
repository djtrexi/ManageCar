import HomeClient from './components/Client/HomeClient';
import Login from './components/Client/Login';
import IndexClient from './components/Client/IndexClient';
import AddCar from './components/Worker/AddCar';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Signup from './components/Client/Signup';
import AllCarOfWorker from './components/Worker/AllCarOfWorker';
import StartTheRental from './components/Car/StartTheRental';
import CarAvalible from './components/Car/CarAvalible';
import CarRental from './components/Worker/CarRental';
import CarRentalForClient from './components/Car/CarRentalForClient';
import OrderCar from './components/Car/OrderCar';
import Home from './components/Home';
import LoginWorker from './components/Worker/LoginWorker';
import IndexWorker from './components/Worker/IndexWorker';
import ChangeVisibilityCar from './components/Worker/ChangeVisibilityCar';
import FunctionChangeVisibilityCar from './components/Worker/FunctionChangeVisibilityCar';
import DeleteCar from './components/Worker/DeleteCar';
import FinishOrder from './components/Client/FinishOrder';
import DoorCashClient from './components/Client/DoorCashClient';
import ChangeDatesVisibilityCar from './components/Worker/ChangeDatesVisibilityCar';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route exact path='/' element={<Home></Home>}></Route>
          <Route exact path='/loginUser' element={<Login></Login>}></Route>
          <Route exact path='/signup' element={<Signup></Signup>}></Route> 
          <Route exact path='/indexClient' element={<IndexClient></IndexClient>}></Route>    
          <Route exact path='/addcar' element={<AddCar></AddCar>}></Route>   
          <Route exact path='/allcarofworker' element={<AllCarOfWorker></AllCarOfWorker>}></Route>
          <Route exact path='/rental' element={<StartTheRental></StartTheRental>}></Route>
          <Route exact path='/caravalible' element={<CarAvalible></CarAvalible>}></Route>
          <Route exact path='/carrental' element={<CarRental></CarRental>}></Route>
          <Route exact path ='/clientrental' element={<CarRentalForClient></CarRentalForClient>}></Route>
          <Route exact path='/order' element={<OrderCar></OrderCar>}></Route>
          <Route exact path='/client' element={<HomeClient></HomeClient>}></Route>
          <Route exact path='/worker' element={<LoginWorker></LoginWorker>}></Route>
          <Route exact path='/indexWorker' element={<IndexWorker></IndexWorker>}></Route>
          <Route exact path='/changeVisibilty' element={<ChangeVisibilityCar></ChangeVisibilityCar>}></Route>
          <Route exact path='/functionChangeVisibilityCar' element={<FunctionChangeVisibilityCar></FunctionChangeVisibilityCar>}></Route>
          <Route exact path='/deleteCar' element={<DeleteCar></DeleteCar>}></Route>
          <Route exact path='/finishOrder' element={<FinishOrder></FinishOrder>}></Route>
          <Route exact path='/doorCashClient' element={<DoorCashClient></DoorCashClient>}></Route>
          <Route exact path='/changeDatesVisibilityCar' element={<ChangeDatesVisibilityCar></ChangeDatesVisibilityCar>}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;