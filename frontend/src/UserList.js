import React, {Component} from 'react';
import axios from 'axios';
import User from './User';
import { Table } from 'react-bootstrap';

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
            <div className="users">
                <Table bordered condensed>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Vartotojas</th>
                            <th>Vardas</th>
                            <th>Pavardė</th>
                            <th>Telefonas</th>
                            <th>El. paštas</th>
                            <th colSpan="2">Redaguoti/Trinti</th>
                        </tr>
                    </thead>
                    <tbody>
                        {userList}
                    </tbody>
                </Table>
            </div>
        )
    }
}

export default UserList;