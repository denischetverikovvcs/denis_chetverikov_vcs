import React, { Component } from 'react';


class Author extends Component {
    constructor(props) {
        super(props);
       this.state = {display: true};
    }

    render() {
        return (
            <div>
                <p>{this.props.author.firstName} {this.props.author.lastName}</p>
            </div>
        );
    }
}

export default Author;