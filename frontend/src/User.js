import React, { Component } from 'react';
import axios from 'axios';


class User extends Component {
    constructor(props) {
        super(props);
        this.state =
            {
                display: true,
                mode: 'view',
                userType: this.props.user.userType,
                fname: this.props.user.username,
                lname: this.props.user.lastName,
                email: this.props.user.email,
                phone: this.props.user.phoneNo,
                username: this.props.user.username,
                password: this.props.user.password,
                passwordConfirm: this.props.user.password,
            };

        this.handleEdit = this.handleEdit.bind(this);
    }
    handleChangeFor = (propertyName) => (event) => {
        this.setState({ [propertyName]: event.target.value });
    }
    handleEdit = event => {
        this.setState({ mode: 'edit' });
    }
    addAdmin = event => {
        this.setState({ mode: 'view' });
        event.preventDefault();

        const UpdatedUser = {

            "userType": this.state.userType,
            "firstName": this.state.fname,
            "lastName": this.state.lname,
            "email": this.state.email,
            "phoneNo": this.state.phone,
            "username": this.state.username,
            "password": this.state.password,
            "passwordConfirm": this.state.password
        }
        axios.put('http://localhost:8080/api/users/'+ this.props.user.id, UpdatedUser).then(console.log('prideta'));
        console.log(UpdatedUser);
 
        this.setState({ mode: 'view' });
    }

    deleteUser = (id) => {

        axios.delete('http://localhost:8080/api/users/' + id).then(console.log('ištryniau'))
        this.setState({ display: false })
    }
    render() {
        if (this.state.mode === 'view') {

            return (
                <div>
                    <tr>
                        <td>{this.props.user.id}</td>
                        <td>{this.props.user.username}</td>
                        <td>{this.props.user.firstName}</td>
                        <td>{this.props.user.lastName}</td>
                        <td>{this.props.user.phoneNo}</td>
                        <td>{this.props.user.email}</td>
                        <td className="button1"><button onClick={() =>
                            this.deleteUser(this.props.user.id)}>Ištrinti </button></td>
                        <td className="button2"><button onClick={this.handleEdit}>Redaguoti</button></td>
                    </tr>
                </div>

            );
        }

        else {
            return (
                <div>
                    <tr>
                        <td><input type="text" size="5" defaultValue={this.props.user.id} /></td>
                        <td><input type="text" size="30" defaultValue={this.props.user.username} onChange={this.handleChangeFor("username")} /></td>
                        <td><input type="text" size="30" defaultValue={this.props.user.firstName} onChange={this.handleChangeFor("fname")} /></td>
                        <td><input type="text" size="30" defaultValue={this.props.user.lastName} onChange={this.handleChangeFor("lname")} /></td>
                        <td><input type="text" size="30" defaultValue={this.props.user.phoneNo} onChange={this.handleChangeFor("phone")} /></td>
                        <td><input type="text" size="30" defaultValue={this.props.user.email} onChange={this.handleChangeFor("email")} /></td>

                        <td className="button3"><button onClick=
                            {this.addAdmin}>Išsaugoti</button></td><td>6</td></tr>

                </div>
            )
        }
    }
}

export default User;