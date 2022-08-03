import React from 'react';

import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import { display, positions } from '@mui/system';

export default function MyCard(props) {
  const teamName = props.teamName;
  return (
    <Card style={{display:'flex',flexDirection:'row',backgroundColor:'#6aa3b1',cursor:'pointer'}}>
      <Card.Body>
        <Card.Title>{teamName}</Card.Title>
      </Card.Body>
    </Card>
  )
};
