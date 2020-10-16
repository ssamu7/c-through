import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';

ReactDOM.render(
  //잠재 적인 문제 체크<StrictMode>
  <React.StrictMode>
    <App/>
  </React.StrictMode>,
  document.getElementById('root')
);
