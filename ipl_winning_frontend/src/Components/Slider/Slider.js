import React, { useState } from 'react';
import { Carousel } from 'react-bootstrap';
import IMAGES from '../../assets/ipl_match_list/IMAGES';

function Slider(props) {
    const [index, setIndex] = useState(1);

    const teamA = props.todayMatch.teamA;
    const teamB = props.todayMatch.teamB;
    const imageName = teamA+"vs"+teamB;

    const handleSelect = (selectedIndex, e) => {
        setIndex(selectedIndex);
    };
    return (
        <Carousel activeIndex={index} onSelect={handleSelect}>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://www.financialexpress.com/wp-content/uploads/2022/02/IPL.jpg"
                    alt="First slide"
                    height={713}
                />
                <Carousel.Caption>
                    <h3>First slide label</h3>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src={IMAGES[imageName]}
                    alt = ''
                    height={713}
                />
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77701983702.jpg"
                    alt="Third slide"
                    height={713}
                />

                <Carousel.Caption>
                    <h3>Third slide label</h3>
                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                </Carousel.Caption>
            </Carousel.Item>
        </Carousel>

    )
}

export default Slider