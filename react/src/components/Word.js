import React, {Component} from 'react';

export default class Word extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isSelected: false,
      data: this.props.data
    }

    this.handleClick = this.handleClick.bind(this);
    this.deselect = this.deselect.bind(this);
  }
  handleClick(event) {
    this.props.onClick();
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
      let className = this.props.className + (this.state.isSelected ? " is-selected" : " ");
    return (
      <button
        className={className}
        type="button"
        onClick={this.handleClick}>{ this.props.children }
      </button>
    )
  }
}