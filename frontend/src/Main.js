import React from 'react';
import './App.css';
import {Route, Switch} from 'react-router-dom';
import Login from './Login';
import AdminMenu from './AdminMenu';
import AddBook from './AddBook';
import AddAdmin from './AddAdmin';
import AddSeller from './AddSeller';

import SignUp from './SignUp';

import BookList from './BookList';
import Users from './Users';



const Main = () => (
    <Switch>
        <Route exact path='/login' component={Login}></Route>
        <Route exact path='/signup' component={SignUp}></Route>
        {/* <Route exact path='/adminmenu' component={AdminMenu}></Route> */}
        <Route exact path='/adminmenu/addBook/' component={AddBook}></Route>
        <Route exact path='/adminmenu/addBook/:id' component={AddBook}></Route>
        <Route exact path='/adminmenu/addAdmin' component={AddAdmin}></Route>
        <Route exact path='/adminmenu/addSeller' component={AddSeller}></Route>
        <Route exact path='/adminmenu/allBooks/' component={BookList}></Route>
        <Route exact path='/adminmenu/users' component={Users}></Route>
    </Switch>
  );

  export default Main;