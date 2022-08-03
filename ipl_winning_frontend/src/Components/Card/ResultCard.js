import Card from 'react-bootstrap/Card';

function ResultCard() {
    return (
        <Card className="bg-dark text-white">
            <Card.Img src="https://c.tenor.com/rec5dlPBK2cAAAAd/mr-bean-waiting.gif" alt="Card image" />
            <Card.ImgOverlay>
                <Card.Title>Waiting</Card.Title>
            </Card.ImgOverlay>
        </Card>
    );
}

export default ResultCard;