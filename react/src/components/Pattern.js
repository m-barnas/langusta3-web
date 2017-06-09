import React, {Component} from 'react';
import {MdCheck, MdRadioButtonChecked} from 'react-icons/lib/md';

export default class Pattern extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isSelected: false
    }

    this.handleClick = this.handleClick.bind(this);
  }
  handleClick(event) {
    this.props.onClick(this);
    this.setState({
        isSelected: true
    });
  }
  deselect() {
      this.setState({
          isSelected: false
      })
  }
  render() {
    let icon = null;
    // let icon = this.state.isSelected ? <MdCheck className="icon mr1" /> : null;

    let className = this.props.className + (this.state.isSelected ? " is-selected" : " ");

    return (
      <button
        className={className}
        type="button"
        onClick={this.handleClick}>
        { icon }{ this.props.children }
      </button>
    )
  }
}