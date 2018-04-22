import React, { Component } from 'react';
import './App.css';
import Main from './Main';
import AdminMenu from './AdminMenu';
import Footerb from './components/Footer';
import NavbarTop from './components/NavbarTop';

class App extends Component {
  render() {
    return (
      <div className='app'>
        <NavbarTop />
        <AdminMenu />
        <div className="main">
        <Main />
        </div>
        <Footerb />
      </div>
    );
  }
}

export default App;