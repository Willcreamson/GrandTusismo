import logo from './logo.svg';
import './App.css';
import MyGallery from './Components/MyGallery';
import ImageGallery from 'react-image-gallery';

function App() {

  const images = [
    {
      original: "https://media.istockphoto.com/id/490360464/fr/photo/personnes-b%C3%A9n%C3%A9ficiant-dune-journ%C3%A9e-sans-automobile-%C3%A0-paris-en-france.jpg?s=612x612&w=0&k=20&c=rwzqXA6DkbqEMNs6_RI0qyhDkstUWjJaRrry64QG91k="
    }
  ]

  return (
    <div className="App">
      <header class = "container" style={{display :"flex" }}>
        <img src={logo} className="App-logo" alt="logo" />
        <h1 style={{color: "lightblue" }}> Grand Turismo </h1>
      </header>
      <ImageGallery items={images} />
    </div>
    
  );
}

export default App;
