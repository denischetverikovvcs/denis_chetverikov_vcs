import React from 'react';
import './App.css';
import { NavLink } from 'react-router-dom';
import Navbar from 'react-bootstrap/lib/Navbar';

const AdminMenu = () => (
  <Navbar inverse collapseOnSelect className="Navbar">
      <div className="navmenu">
        <ul className="mainmenu">
          <li><NavLink to='/adminmenu/allBooks/'><i className="fa fa-globe menu-icon" aria-hidden="true"></i>Visos knygos</NavLink></li>
          <li><NavLink to='/adminmenu/addAdmin'><i className="fa fa-th-list menu-icon" aria-hidden="true"></i>Pridėti administratorių</NavLink></li>
          <li><NavLink to='/adminmenu/addSeller'><i className="fa fa-th-list menu-icon" aria-hidden="true"></i>Pridėti pardavėją</NavLink></li>
          <li><NavLink to='/adminmenu/addBook/'><i className="fa fa-th-list menu-icon" aria-hidden="true"></i>Pridėti knygą</NavLink></li>
          <li><NavLink to='/adminmenu/users'>Vartotojai</NavLink></li>
        </ul>
      </div>
  </Navbar>
);

export default AdminMenu;