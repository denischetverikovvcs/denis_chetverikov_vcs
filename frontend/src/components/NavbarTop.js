import React from 'react';
import { NavLink } from 'react-router-dom';

function NavbarTop() {

  return (
    <nav className="navbartop">
      <div className="name">
        <p><i className="fa fa-book menu-icon" aria-hidden="true"></i>Knygų Parduotuvė</p>
      </div>
      <div className="headermenu">
        <ul className="topmenu">
          <li><NavLink to='/'>Pagalba</NavLink></li>
          <li><NavLink to='/'>Susisiekti</NavLink></li>
          <li><NavLink to='/'>Prisijungti <i className="fa fa-check-circle" aria-hidden="true"></i></NavLink></li>
        </ul>
      </div>
    </nav>

  )

}
export default NavbarTop