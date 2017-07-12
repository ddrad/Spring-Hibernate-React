import React from 'react';
import ReactDOM from 'react-dom';
import Counter, {LogMixin} from './Counter'

export default TextCounter = React.createClass({
    name: 'MyComponent',
    mixins: [LogMixin],
    propTypes: {
        defaultText: React.PropTypes.string.isRequired,
        address: React.PropTypes.string
    },
    getDefaultProps: function() {
        return {
            address: '',
        };
    },
    getInitialState: function() {
        return {
            internalValue: this.props.defaultText,
        };
    },
    _textChange:function(ev){
         if( this.state.internalValue.length >= 10) {
            alert("error text must not be more 10");
        } else {
            this.setState({
                internalValue: ev.target.value,
            });
        }
    },
    render: function() {
        var counter = null;
        if (this.state.internalValue.length > 0) {
            counter = React.DOM.h3(null,
                React.createElement(Counter, {
                    count: this.state.internalValue.length,
                }
            ));
        }
        return React.DOM.div(null, 
                    React.DOM.textarea({
                        value: this.state.internalValue,
                        onChange: this._textChange,
                    }),
                  counter
        );
    }
});
