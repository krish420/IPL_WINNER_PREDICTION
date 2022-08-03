import React, { useEffect, useState } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import MyCard from "../Card/MyCard";
import ResultCard from '../Card/ResultCard';
import AllMatch from '../AllMatch/AllMatch';
import * as myaxios from '../../api/myaxios';
import Typewriter from 'typewriter-effect';
import Card from 'react-bootstrap/Card';
import './GamingArea.css';

function GamingArea(props) {

    const AllMatchList = props.allMatch;
    const user = JSON.parse(localStorage.getItem('user'));
    const guessStartTime = "11:00";
    const matchStartTime = "12:00";
    const matchEndTime = "13:00";
    const [currentTime, setCurrentTime] = useState("00:00 AM");

    const [ifSelected, setIfSelected] = useState(user.playForToday);
    const [player, setPlayer] = useState(user);
    const [result, setResult] = useState(user.win);

    setInterval(() => {
        setCurrentTime(new Date().toLocaleTimeString([], { hour12: false, hour: '2-digit', minute: '2-digit' }))
    }, 1000);

    useEffect(() => {
        setTheState();
        console.log(ifSelected);
        console.log(result);
        console.log(player);

    }, []);
    const fetchPlayerDetails = () => {
        myaxios.fetchUserById(player.userId).then((res) => {
            localStorage.setItem('user', JSON.stringify(res.data));
        });
    }
    const setTheState = () => {
        const user = JSON.parse(localStorage.getItem('user'));
        setPlayer(user);
        setResult(user.win);
        setIfSelected(user.playForToday);
    }
    const handleOnClick = (event) => {
        const elementId = event.currentTarget.id;
        const userId = "" + player.userId;
        console.log(elementId)
        console.log(userId)
        myaxios.guessTheWinner(elementId, userId).then((res) =>{console.log(res); localStorage.setItem('user', JSON.stringify(res.data))});
        
        setTheState();
        // window.location.reload();
    };

    return (
        <Container className='__main'>
            <Row>
                <Col className='d-flex justify-content-center' sm={4} style={{ height: '100vh' }}>


                    <img src='https://media.giphy.com/media/JQSgcNtBmhG45931m8/giphy.gif' alt='' style={{ marginLeft: '-35%', marginTop: '40%', height: '30rem', width: '30rem' }} />


                </Col>
                <Col sm={4} style={{ height: '100vh' }}>
                    <img src='https://media.giphy.com/media/l3mNAloBtRhCuGyDO5/giphy.gif' alt='' style={{ marginTop: '-50px', height: '20rem', width: '15rem' }} />
                    <div >
                        {currentTime < guessStartTime ?
                            <h1 className='text-card'>Game Not Stared Yet</h1> : currentTime >= guessStartTime && currentTime < matchStartTime && !ifSelected ?
                                <div className='d-flex flex-row justify-content-between'><div id='1' onClick={handleOnClick} ><MyCard teamName={props.todayMatch.teamA} /></div>
                                    <div id='2' onClick={handleOnClick} ><MyCard teamName={props.todayMatch.teamB} /></div></div> : currentTime >= guessStartTime && currentTime < matchStartTime && ifSelected ?
                                    <ResultCard /> : currentTime >= matchStartTime && currentTime < matchEndTime && ifSelected ?
                                        <h1 className='text-card'>Thanks for Playing.Wait for Result</h1> : currentTime >= matchStartTime && currentTime < matchEndTime && !ifSelected ?
                                            <h1 className='text-card'>Match Started. You have not Play for today</h1>
                                            : currentTime >= matchEndTime && ifSelected ?
                                                <h1 className='text-card'>Result</h1> : <h1 className='text-card'>Match Over</h1>
                        }
                    </div>
                </Col>
                <Col sm={4} style={{ height: '100vh' }}>
                    <div className=''
                        style={{
                            backgroundColor: '#006E7F',
                            backdropFilter: 'blur',
                            position: 'absolute',
                            marginTop: '20px',
                            marginLeft: '90px',
                            height: '42rem',
                            width: '25rem',
                            padding: '2rem',
                            borderRadius: '30px',
                            boxShadow: '1px 2px 9px #181D31',
                            zIndex: 1,
                            overflowX: 'hidden',
                            overflowY: 'scroll'
                        }}>
                        <h1 className='d-flex justify-content-center'>Match Lists</h1>
                        <AllMatch allMatchList={AllMatchList} />
                    </div>

                </Col>
            </Row>
        </Container>
    )
}

export default GamingArea;