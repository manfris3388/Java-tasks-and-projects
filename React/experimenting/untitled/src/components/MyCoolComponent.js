import React from "react";

// export default (props) => <h1> Hello, {props.name}!</h1>

export default class MyCoolComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {name: 'World'}
    }

    render() {
        return(
            <>
                <input type={'Text'} name={'Manfris'}/>
                <h1> Hello, {this.state.name}</h1>
            </>
        )
    }
}