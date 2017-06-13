import React, { Component } from 'react';
import { MdArrowDropDown } from 'react-icons/lib/md';

export default class Select extends Component {
  render() {
    const items = this.props.items;

    return (
      <div className={"Select" + (this.props.isLoading ? " is-loading" : "")}>
        <select id={this.props.id} className="pv1 pl2 pr3 b" onChange={(e) => this.props.onChange(e.target.value)} disabled={this.props.isLoading}>
          <option value=""> </option>
          {typeof items !== 'undefined' && items !== null && items.map((item, index) => (
            <option key={index} value={item}>
              {item}
            </option>
          ))}
        </select>
        <MdArrowDropDown className="Select-icon" />
      </div>
    )
  }
}