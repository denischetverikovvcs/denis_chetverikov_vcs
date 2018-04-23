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
        this.setState({style : {display: false}})
    }

    cancel = () => {
        this.setState(this.initialState);
        console.log(this.state);
    }
    render() {
        // if (this.state.mode === 'view') {     return (         <tr>
        // <td>{this.props.user.id}</td>             <td
        // contentEditable="{this.state.editMode}">{this.props.user.username}</td>
        //       <td>{this.props.user.firstName}</td>
        // <td>{this.props.user.lastName}</td>
        // <td>{this.props.user.phoneNo}</td>
        // <td>{this.props.user.email}</td>             
        // <td className="button2">
        //         <button onClick={this.handleEdit}>Taisyti</button>             </td>
        //            <td className="button1">                 <button onClick={() =>
        // this.deleteUser(this.props.user.id)}>                     Trinti
        //    </button>             
        //</td>         
        //</tr>     ); // } else {
        return (
            <tr>
                <td>
                    <input type="text" size="5" defaultValue={this.props.user.id}/>
                </td>
                <td>
                    <input
                        className={this.state.style.className}
                        type="text"
                        size="20"
                        readOnly={this.state.style.readOnly}
                        defaultValue={this.state.user.username}
                        onChange={this.handleChangeFor("username").bind(this)}/>
                </td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="20"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.firstName}
                    onChange={this.handleChangeFor("fname")}/></td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="20"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.lastName}
                    onChange={this.handleChangeFor("lname")}/></td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="20"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.phoneNo}
                    onChange={this.handleChangeFor("phone")}/></td>
                <td><input
                    className={this.state.style.className}
                    type="text"
                    size="20"
                    readOnly={this.state.style.readOnly}
                    defaultValue={this.state.user.email}
                    onChange={this.handleChangeFor("email")}/></td>
                <td className="button2">
                    <button
                        className={this.state.style.readOnly ? "" : "invisible"} 
                        onClick={this.handleEdit}>
                        Taisyti
                    </button>
                    <button 
                        className={this.state.style.readOnly ? "invisible":""} 
                        onClick={this.addAdmin}>
                        Saugoti
                    </button>
                </td>         
                <td className="button1">
                    <button
                        className={this.state.style.readOnly ? "" : "invisible"} 
                        onClick={() => this.deleteUser(this.props.user.id)}>
                        &nbsp;Trinti&nbsp;
                    </button>             
                    <button
                        className={this.state.style.readOnly ? "invisible":""} 
                        onClick={() => this.cancel()}>
                        Atšaukti
                    </button>             
                </td>
            </tr>
        )
        // }
    }
}

export default User;