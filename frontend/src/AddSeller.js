import React, { Component } from 'react';
import axios from 'axios';
import {FormControl} from 'react-bootstrap';
import {Button} from 'react-bootstrap';

class AddSeller extends Component {
  constructor(props) {
    super(props);
    this.state = {
      fname: '',
      lname: '',
      email: '',
      phone: '',
      username: '',
      password: '',
      passwordConfirm: '',
    }
  }

    handleChangeFor = (propertyName) => (event) => {
      this.setState({ [propertyName]: event.target.value });
    }

      addSeller = event => {
        event.preventDefault();

        const newSeller = {
          "userType": 'SELLER',
          "firstName": this.state.fname,
          "lastName": this.state.lname,
          "email": this.state.email,
          "phoneNo": this.state.phone,
          "username": this.state.username,
          "password": this.state.password,
          "passwordConfirm": this.state.passwordConfirm
        }
        axios.post('http://localhost:8080/api/users', newSeller);
        console.log(newSeller);

        this.setState({
          fname: '',
          lname: '',
          email: '',
          phone: '',
          username: '',
          password: '',
          passwordConfirm: '',
        })
      }

      render(){
        return (
          <div className='addSeller'>
            <form>
              <label>Vardas</label>
              <FormControl placeholder="Įveskite vardą" name="fname" type="text"  onChange={this.handleChangeFor("fname")} value={this.state.fname}/>
              <label>Pavardė</label>
              <FormControl placeholder="Įveskite pavardę" name="lname" type="text"  onChange={this.handleChangeFor("lname")} value={this.state.lname} />
              <label>Elektronis paštas</label>
              <FormControl placeholder="Įveskite elektroninį paštą" name="email" type="text"  onChange={this.handleChangeFor("email")} value={this.state.email} />
              <label>Telefono numeris</label>
              <FormControl placeholder="Įveskite telefono numerį" name="phone" type="text"  onChange={this.handleChangeFor("phone")} value={this.state.phone}/>
              <label>Vartotojo vardas</label>
              <FormControl placeholder="Įveskite vartotojo vardą" name="username" type="text"  onChange={this.handleChangeFor("username")} value={this.state.username} />
              <label>Slaptažodis</label>
              <FormControl placeholder="Įveskite slaptažodį" name="password" type="password" onChange={this.handleChangeFor("password")} value={this.state.password} />
              <label>Pakartokite slaptažodį</label>
              <FormControl placeholder="Pakartokite slaptažodį" name="passwordConfirm" type="password"  onChange={this.handleChangeFor("passwordConfirm")} value={this.state.passwordConfirm} /><br/>
              <Button type="submit" onClick={this.addSeller}>Išsaugoti</Button>
            </form>
          </div>
        );
      }
    }

    export default AddSeller;