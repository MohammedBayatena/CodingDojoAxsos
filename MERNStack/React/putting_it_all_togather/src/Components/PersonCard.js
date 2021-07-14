import React, {Component} from 'react';

class PersonCard extends Component {

    constructor(props) {
        super(props);
        this.state = {
            personAge: props.age
        }
    }

    increaseAge = () => {this.setState({personAge: this.state.personAge+1});}

    render() {
        return (
            <div>
                <h1>{this.props.lastname} {this.props.lastname}</h1>
                <p>Age: {this.state.personAge}</p>
                <p>Hair Color: {this.props.haircolor}</p>
                <button onClick={this.increaseAge}>Birthday Button
                    for {this.props.firstname} {this.props.lastname}</button>
            </div>
        );
    }
}

export default PersonCard;