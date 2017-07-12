import React, {Component} from 'react';
import ReactDOM from 'react-dom';


var headers = [
    "Book", "Author", "Language", "Published", "Sales"
];
var data = [
    ["The Lord of the Rings", "J. R. R. Tolkien", "English", "1954–1955", "150 million"],
    ["Le Petit Prince (The Little Prince)", "Antoine deSaint-Exupéry","French", "1943", "140 million"],
    ["Harry Potter and the Philosopher's Stone", "J. K. Rowling","English", "1997", "107 million"],
    ["And Then There Were None", "Agatha Christie","English", "1939", "100 million"],
    ["Dream of the Red Chamber", "Cao Xueqin","Chinese", "1754–1791", "100 million"],
    ["The Hobbit", "J. R. R. Tolkien","English", "1937", "100 million"],
    ["She: A History of Adventure", "H. Rider Haggard","English", "1887", "100 million"],
];

//console.log(":: "+ TextCounter);

class Excel extends Component{
    // getInitialState() {
    //     return {data: this.props.initialData};
    // };
    render() {
    var state = this.state;
    return (
        <table>
            <thead onClick={this._sort}>
                <tr>
                    {this.props.headers.map(function(title, idx) {
                        if (state.sortby === idx) {
                            title += state.descending ? ' \u2191' : ' \u2193';
                        }
                        return <th key={idx}>{title}</th>;
                    })}
                </tr>
            </thead>
            <tbody>
                {state.data.map(function(row, idx) {
                    return (
                        <tr key={idx}>
                            {row.map(function(cell, idx) {
                                return <td key={idx}>{cell}</td>;
                            })}
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
    }
}

export default Excel;