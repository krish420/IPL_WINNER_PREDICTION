import React, { useState,useEffect } from 'react';
import NavBar from '../../NavBar/NavBar';
import Slider from '../../Slider/Slider';
import cashBg from '../../../assets/cash_background.jpg'

import GamingArea from '../../GamingArea/GamingArea';
import { Fullpage, FullPageSections, FullpageSection, FullpageNavigation } from '@ap.cx/react-fullpage';
// import HorizontalScroll from 'react-scroll-horizontal';
import './HomePage.css';
import * as myaxios from '../../../api/myaxios';

// import CoverPicture



function HomePage() {
    const [todaysMatch, setTodaysMatch] = useState({
        "match_id": 3,
        "teamA": "MIR",
        "teamB": "CSK",
        "date": "7/21/2022"
    });
    const [AllMatch, setAllMatch] = useState([{"match_id":1,"teamA":"CSK","teamB":"KKR","date":"7/24/2022"}]);
    console.log(AllMatch);
    console.log(JSON.stringify(AllMatch))
    useEffect(()=>{ 
        myaxios.fetchTodayMatch().then((res)=>{setTodaysMatch(res.data)});
        myaxios.fetchAllMatch().then((res)=>{setAllMatch(res.data)})},[]);
    const sectionStyle = {
        height: '100vh',
        width: '100%',
        justifyContent: 'center',
        allignItem: 'center'

    };
    // const todaysMatch = myaxios.fetchTodayMatch();

    return (
        <div style={{ backgroundColor: '#538cc6', overflow: 'hidden' }}>
            <Fullpage>
                <FullpageNavigation />
                <FullPageSections>
                    <FullpageSection style={sectionStyle}>
                        <NavBar />
                        <Slider todayMatch = {todaysMatch}/>
                    </FullpageSection>
                    <FullpageSection className='__full' style={{
                        height: "100vh",backgroundColor:'read', backgroundImage: { cashBg }, backgroundPosition: 'center',
                        backgroundSize: 'cover',
                        backgroundRepeat: 'no-repeat'
                    }}>
                        <GamingArea todayMatch = {todaysMatch} allMatch = {AllMatch}/>
                    </FullpageSection>
                </FullPageSections>
            </Fullpage>
        </div>
    )
}

export default HomePage