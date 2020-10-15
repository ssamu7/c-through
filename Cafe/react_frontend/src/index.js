import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import KakaoMap from "./pages/KakaoMap";

ReactDOM.render(
  //잠재 적인 문제 체크<StrictMode>
  <React.StrictMode>
    <KakaoMap />
  </React.StrictMode>,
  document.getElementById('root')
);
