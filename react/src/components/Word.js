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
    this.getData = this.getData.bind(this);
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
  getData() {
    return this.state.data;
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