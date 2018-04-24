import React from 'react';
import './App.css';
import { NavLink } from 'react-router-dom';

const Navigation = () => (
    <nav>
      <ul>
        <li><NavLink to='/login'>Login</NavLink></li>
      </ul>
    </nav>
  );

  export default Navigation;