import React from 'react';
import './App.css';
import NavBar from './component/Navbar'
import LandingPage from './component/LandingPage'
import Page1 from './component/Page1'
import {
  Route,
  BrowserRouter as Router
} from "react-router-dom";

function App() {
  return (
    <div>
      <NavBar/>
      <Router>
          <Route exact path="/" component={LandingPage} />
          <Route exact path="/Page1" component={Page1} />
      </Router>
    </div>  
  );
}

export default App;
