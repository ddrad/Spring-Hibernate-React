import React, {Component} from 'react';
import ReactDOM from 'react-dom';


export const LogMixin = {
     _log: function(methodName, args) {
        console.log(this.name + '::' + methodName, args);
    },
    componentWillUpdate: function() {
        this._log('componentWillUpdate', arguments);
    },
    componentDidUpdate: function(oldProps, oldState) {
        this._log('componentDidUpdate', arguments);
    },
    componentWillMount: function() {
        this._log('componentWillMount', arguments);
    },
    componentDidMount: function() {
        this._log('componentDidMount', arguments);
    },
    componentWillUnmount: function() {
        this._log('componentWillUnmount', arguments);
    }
}

export default Counter = React.createClass({
    name: 'Counter',
    mixins: [LogMixin],
    propTypes: {
        count: React.PropTypes.number.isRequired,
    },
    shouldComponentUpdate(nextProps, nextState_ignore) {
        console.log(this.name + "::"+"shouldComponentUpdate", arguments);
        console.log(nextProps.count +"  "+ this.props.count);
        return nextProps.count !== this.props.count && nextProps.count <= 10;
    },
    render: function() {
        return React.DOM.span(null, this.props.count);
    }
});