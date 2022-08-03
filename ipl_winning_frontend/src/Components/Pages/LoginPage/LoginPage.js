import React from 'react'
import { Login } from '../../Login/Login'

export default function LoginPage() {
  const url1 = 'https://ak.picdn.net/shutterstock/videos/1081549034/thumb/1.jpg?ip=x480';
  const url = 'https://images.pexels.com/photos/1655166/pexels-photo-1655166.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260';
  const url2 = 'https://images.unsplash.com/photo-1540747913346-19e32dc3e97e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8Y3JpY2tldHxlbnwwfHwwfHw%3D&w=1000&q=80'
  return (
    <div style={{
      height:'100vh',
      width:'100vw',
      backgroundSize:'cover' ,
      backgroundImage:`url("${url}")`,
      }}>
        <div>
          <img src='https://media.giphy.com/media/XylgR4xzqtaVRHN756/giphy.gif' alt=""/>
        </div>
      <div style={{
            backgroundColor: '#97BFB4',
            backdropFilter: 'blur',
            position: 'absolute',
            top:'2%',
            left:'50%',
            height: '30rem',
            width: '30rem',
            padding: '2rem',
            borderRadius: '45px',
            boxShadow: '1px 2px 9px #181D31',
            zIndex: 1,
            overflowX: 'hidden',
            overflowY: 'scroll'
          }}>
        <Login />
      </div>
      <div style={{position:'absolute',left:'50%',top:'60%'}}>
        <img src = 'https://media.giphy.com/media/dupMOL8nNK1ghDT6qQ/giphy-downsized.gif' alt='' style={{width:'57%',height:'45%'}}/>
      </div>
   </div>
  )
}
