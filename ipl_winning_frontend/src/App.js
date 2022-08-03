import { BrowserRouter, Route,Routes } from 'react-router-dom';
import SignupPage from './Components/Pages/SignupPage/SignupPage';
import LoginPage from './Components/Pages/LoginPage/LoginPage';
import HomePage from './Components/Pages/HomePage/HomePage';
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
      <Route path='/' element={<SignupPage/>}/>
      <Route path='/login' element={<LoginPage/>}/>
      <Route path='/user/home' element={<HomePage/>}/>

      </Routes>
    </BrowserRouter>
    
  );
}

export default App;
