import React, { useEffect } from 'react';
import { Signup } from '../../SignUp/Signup';
import Typewriter from 'typewriter-effect';



function SignupPage() {
  useEffect(() => { document.title = "Guess & Win || Sign Up"; localStorage.clear() }, []);
  return (
    <div style={{ backgroundColor: '#151D3B', height: '100vh', width: '100vw' }}>
      <div style={{ position: 'relative', }}>
        <div className=''
          style={{
            backgroundColor: '#97BFB4',
            backdropFilter: 'blur',
            position: 'absolute',
            marginTop: '20px',
            marginLeft: '90px',
            height: '40rem',
            width: '30rem',
            padding: '2rem',
            borderRadius: '30px',
            boxShadow: '1px 2px 9px #181D31',
            zIndex: 1,
            overflowX: 'hidden',
            overflowY: 'scroll'
          }}>
          <Signup />
        </div>
        <div style={{ position: 'absolute', top: 10, right: '33%' }}>
          <img src='https://media.giphy.com/media/WQJbiTZ9Iz17FPjJE4/giphy.gif' alt='' />
        </div>
        <div style={{
          position: 'absolute',
          top: 60,
          right: 60,
          fontFamily: 'Lobster Two',
          color: '#EBE645',
          textAlign: 'center',
        }}>
          <div style={{ textShadow: '1px 1px 2px red, 0 0 1em blue, 0 0 0.2em blue' }}>
            <h1 style={{ fontSize: '90px' }}>DON'T</h1>
            <h1 style={{ fontSize: '50px' }}>PLAY THE GAME</h1>
            <h1 style={{ fontSize: '100px' }}>WIN IT</h1>
          </div>
          <div style={{ fontFamily: 'Roboto Mono', color: 'gold', fontSize: '30px' }}>
            <Typewriter
              options={{
                strings: ['REGISTER', 'PREDICT THE WINNER', '& WIN'],
                autoStart: true,
                loop: true,
              }}

            />
          </div>
        </div>
      </div>
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#FABB51" fill-opacity="1" d="M0,224L34.3,234.7C68.6,245,137,267,206,240C274.3,213,343,139,411,106.7C480,75,549,85,617,112C685.7,139,754,181,823,181.3C891.4,181,960,139,1029,101.3C1097.1,64,1166,32,1234,21.3C1302.9,11,1371,21,1406,26.7L1440,32L1440,0L1405.7,0C1371.4,0,1303,0,1234,0C1165.7,0,1097,0,1029,0C960,0,891,0,823,0C754.3,0,686,0,617,0C548.6,0,480,0,411,0C342.9,0,274,0,206,0C137.1,0,69,0,34,0L0,0Z"></path></svg>

    </div>
  )
}

export default SignupPage