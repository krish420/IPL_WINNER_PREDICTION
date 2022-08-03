import React, { useState } from 'react';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import AccountBalanceWalletIcon from '@mui/icons-material/AccountBalanceWallet';
import CurrencyRupeeIcon from '@mui/icons-material/CurrencyRupee';
import LogoutIcon from '@mui/icons-material/Logout';


function NavBar() {
  const user = JSON.parse(localStorage.getItem('user'));
  const [user_profile_img, setUser_profile_img] = useState([  "https://www.w3schools.com/howto/img_avatar.png"
])
  const name = user.name; 
  // user.name;
  const balance = user.walletBalance;
  const doLogoutUser = () => {
    localStorage.clear()
    window.location.replace("/");
  };
  const setProfilePicture = () =>{
    console.log("Profile picture uploaded");
    setUser_profile_img("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ1GMJfQi59ueLVVtMm8ujztuCQtNMSUq28CA&usqp=CAU");
  };
  return (
    <Navbar fixed='top' bg="dark" variant="dark">
        <Container>
          <Navbar.Brand>
            <img
              alt="Profile Pic"
              src={user_profile_img}
              width="30"
              height="30"
              className="d-inline-block align-top"
              onClick={setProfilePicture}
            />{' '}
            {name}
          </Navbar.Brand>
          <Navbar.Toggle />
          <Navbar.Collapse className="justify-content-end">
          <Navbar.Text style={{display:'flex'}}>
            <AccountBalanceWalletIcon/>: {balance}<CurrencyRupeeIcon/>
            <LogoutIcon 
            style={{marginLeft:'10px',
                    cursor:'pointer',
                    backgroundColor:'transparent',
                    border:'1px solid #ff6666',
                    borderRadius:'5px'}}
            onClick={doLogoutUser}/>
          </Navbar.Text>
        </Navbar.Collapse>
        </Container>
      </Navbar>
  )
}

export default NavBar