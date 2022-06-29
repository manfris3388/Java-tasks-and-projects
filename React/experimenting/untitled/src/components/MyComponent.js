import React from "react";

export default class MyComponent extends React.Component{
    constructor(props) {
        super(props)
        this.state = {text : this.props.text}
        this.counter = 0;
    }

    onClick = () =>{
        this.setState({text : this.counter++})
    }

    render() {
        return (<>
        <h2>{this.state.text}
            <button type="button" onClick={this.onClick}>Paspausk</button>
        </h2>
    </>)
    }
}