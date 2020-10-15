import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Map from "./component/map/Map";

ReactDOM.render(
  //잠재 적인 문제 체크<StrictMode>
  <React.StrictMode>
    <Map />
  </React.StrictMode>,
  document.getElementById('root')
);
