import React, {Component} from 'react';
import axios from 'axios';


class User extends Component {
    constructor(props) {
        super(props);
        this.state = {
            style : {
                className: "",
                readOnly: true,
                display: true,
            },
            user : this.props.user
        };

        this.initialState = this.state;
        this.handleEdit = this.handleEdit.bind(this);
        this.handleChangeFor = this.handleChangeFor.bind(this);
    }
    handleChangeFor = (propertyName) => (event) => {
        this.setState({[propertyName]: event.target.value});
    }
    handleEdit = event => {
        this.setState({style : {readOnly: false, className: "inEditMode" }});
        this.initialState = this.state;
    }
    addAdmin = event => {
        this.setState({style : {readOnly: true, className: "" }});
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
        axios
            .put('http://localhost:8080/api/users/' + this.props.user.id, UpdatedUser)
            .then(console.log('prideta'));
        console.log(UpdatedUser);

        this.setState({style : {readOnly: true, className: "" }});
    }

    deleteUser = (id) => {

        axios
            .delete('http://localhost:8080/api/users/' + id)
            .then(console.log('ištryniau'))
        this.setState({style : {display: false}, user:{username:""}})
        console.log(this.state);
    }

    cancel = () => {
        this.setState(this.initialState);
        console.log(this.state);
    }
    render() {
        return (
            <tr className = "input">
                <td>
                    <input type="text" size="5" defaultValue={this.props.user.id}/>
                </td>
                <td>
                    <input
                        className={this.state.style.className}
                        type="text"
                        size="15"
                        readOnly={this.state.style.readOnly}
                        defaultValue={this.state.user.username}
                        onChange={this.handleChangeFor("username").bind(this)}/>
                </td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="15"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.firstName}
                    onChange={this.handleChangeFor("fname")}/></td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="15"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.lastName}
                    onChange={this.handleChangeFor("lname")}/></td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="15"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.phoneNo}
                    onChange={this.handleChangeFor("phone")}/></td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="15"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.email}
                    onChange={this.handleChangeFor("email")}/></td>
                <td className="button2">
                    <button 
                        className={(this.state.style.readOnly ? "" : "invisible") + " glyphicon glyphicon-pencil"} 
                        onClick={this.handleEdit}>
                    </button>
                    <button 
                        className={(this.state.style.readOnly ? "invisible":"") + " glyphicon glyphicon-ok"} 
                        onClick={this.addAdmin}>
                    </button>
                </td>         
                <td className="button1">
                    <button
                        className={(this.state.style.readOnly ? "" : "invisible") + " glyphicon glyphicon-trash"} 
                        onClick={() => this.deleteUser(this.props.user.id)}>
                    </button>             
                    <button
                        className={(this.state.style.readOnly ? "invisible":"") + " glyphicon glyphicon-remove"} 
                        onClick={() => this.cancel()}>
                    </button>             
                </td>
            </tr>
        )
    }
}

export default User;