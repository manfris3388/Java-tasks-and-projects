import React from "react";

// export default (props) => <h1> Hello, {props.name}!</h1>

export default class MyCoolComponent extends React.Component{
    constructor(props) {
        super(props);
    }

    render() {return <h1> Hello, {this.props.name}</h1>
    }
}