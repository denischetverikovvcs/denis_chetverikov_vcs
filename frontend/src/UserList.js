import React, {Component} from 'react';
import axios from 'axios';
import User from './User';
import './UserList.css';

class UserList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {
        axios
            .get('http://localhost:8080/api/users')
            .then(response => {
                this.setState({users: response.data})
            })
    }

    render() {
        const userList = this
            .state
            .users
            .map(user => {
                return <User key={user.id} user={user}/>
            })

        return (
            <div>
                <h1>Visi vartotojai</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Vartotojas</th>
                            <th>Vardas</th>
                            <th>Pavardė</th>
                            <th>Telefonas</th>
                            <th>El. paštas</th>
                            <th colSpan="2">Veiksmai</th>
                        </tr>
                    </thead>
                    <tbody>
                        {userList}
                    </tbody>
                </table>
            </div>
        )
    }
}

export default UserList;