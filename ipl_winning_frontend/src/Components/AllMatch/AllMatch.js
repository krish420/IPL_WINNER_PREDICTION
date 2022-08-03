import React, { useState } from 'react';
import ListGroup from 'react-bootstrap/ListGroup';


function AllMatch(props) {
  const matches = props.allMatchList;
  const divStyle = {
    overflowY: 'scroll',
    height: '650px',
  };
  const [color, setColor] = useState([]);
  return (
    <div style={divStyle}>
      {matches.map((match) => (
        <ListGroup key={match} horizontal className="my-2" >
          <ListGroup.Item action style={{backgroundColor:'#F8CB2E'}}>{match.date}</ListGroup.Item>
          <ListGroup.Item action style={{backgroundColor:'#EE5007'}}>{match.teamA} vs {match.teamB}</ListGroup.Item>

        </ListGroup>
      ))}

    </div>
  )
}

export default AllMatch